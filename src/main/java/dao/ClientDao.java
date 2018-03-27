package dao;

import entity.Client;

public interface ClientDao {
	public int insert(Client c);
	public int delete(Client c);
	public int update(Client c);
	public Client findbyid(int id);
}
