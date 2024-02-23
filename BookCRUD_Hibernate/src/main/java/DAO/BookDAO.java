package DAO;

public interface BookDAO {

	public void create(String title, String author, float price);
	public void read(int id);
	public void readAll();
	public void update(int id);
	public void delete(int id);
	
}
