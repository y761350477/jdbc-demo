package basedao;


import daofactory.DaoFactory;
import entity.Client;

public class Text {
	public static void main(String[] args) {
		Client c=new Client();
		c.setCliNo("1");
		c.setCliName("aaa");
		int i=DaoFactory.clientDao.insert(c);	
		System.out.println(i);
	}
}
