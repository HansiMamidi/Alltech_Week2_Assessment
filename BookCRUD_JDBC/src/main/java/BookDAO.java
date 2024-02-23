
public interface BookDAO {

	public void create(int id, String title, float price);
	public void read(int id);
	public void readAll();
	public void update(int id);
	public void delete(int id);
	
}
