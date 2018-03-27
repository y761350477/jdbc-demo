package daofactory;

import java.util.List;

public class TestMyBaseDB {
    public static void main(String[] args) {
        String sql = "select * from tb_user";
        Object[] params = new Object[1];
        params[0] = "1";
        List<List<Object>> a = MyBaseDB.quert(sql, null);
        System.out.println(a.get(0));//获取a的数值。
    }
}
