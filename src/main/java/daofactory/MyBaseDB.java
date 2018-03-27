package daofactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC(mysql)
 * 步骤:
 * 1. 导入mysql-connector-java架包;
 * 2.
 *
 * @author YC
 * @create 2018/3/27 23:09.
 */
public class MyBaseDB {
    static final String jdbcs = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/yc_database?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    static final String user = "root";
    static final String pwd = "aA123";

    //获取连接
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(jdbcs);
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    //增减改的方法
    public static int update(String sql, Object[] params) {
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int i = 0;
        if (conn != null) {
            try {
                pstmt = conn.prepareStatement(sql);
                setPatams(pstmt, params);
                i = pstmt.executeUpdate();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                closeAll(conn, pstmt, rs);
            }
        } else {
            i = -1;
        }
        return i;
    }

    public static List<List<Object>> quert(String sql, Object[] params) {
        Connection conn = getConnection();
        ResultSet rs = null;
        List<List<Object>> list = new ArrayList<List<Object>>();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            setPatams(pstmt, params);
            rs = pstmt.executeQuery();
            ResultSetMetaData rstd = rs.getMetaData();
            int colnum = rstd.getColumnCount();

            while (rs.next()) {
                List<Object> l = new ArrayList<Object>();
                for (int i = 1; i <= colnum; i++) {
                    Object o = rs.getObject(i);
                    l.add(o);
                }
                list.add(l);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeAll(conn, pstmt, rs);
        }

        return list;
    }

    public static void setPatams(PreparedStatement pstmt, Object[] params) {
        if (params != null) {
            for (int i = 1; i <= params.length; i++) {
                try {
                    pstmt.setObject(i, params[i - 1]);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {

        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
