package daofactory;

import dao.ClientDao;
import daoimpl.ClientImpl;

public class DaoFactory {
	public static ClientDao clientDao=new ClientImpl();
}
