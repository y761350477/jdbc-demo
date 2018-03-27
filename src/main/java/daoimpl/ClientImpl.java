package daoimpl;

import dao.ClientDao;
import daofactory.MyBaseDB;
import entity.Client;

public class ClientImpl implements ClientDao {

	@Override
	public int insert(Client c) {
		String sql="insert into T_client(cliNo,cliName) values(?,?)";
		Object[] obj=new Object[2];
		obj[0]=c.getCliNo();
		obj[1]=c.getCliName();
		return MyBaseDB.update(sql, obj);
	}

	@Override
	public int delete(Client c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Client c) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Client findbyid(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
