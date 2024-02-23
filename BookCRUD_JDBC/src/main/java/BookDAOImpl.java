import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookDAOImpl implements BookDAO {
	
	private static final String INSERT_QUERY = "insert into books(bookId, title, price) values (?,?,?)";
	private static final String READ_QUERY = "select * from books where bookId=?";
	private static final String READALL_QUERY = "select * from books";
	private static final String UPDATE_QUERY = "update books set %s  = ? where bookId=?";
	private static final String DELETE_QUERY = "delete from books where bookId = ?";

	Scanner sc = new Scanner(System.in);
	@Override
	public void create(int id, String title, float price) {
		// TODO Auto-generated method stub
		
		try (Connection connection = MyConnection.getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
			preparedStatement.setInt(1,id);
			preparedStatement.setString(2,title);
			preparedStatement.setFloat(3,price);
			
			int us = preparedStatement.executeUpdate();
			
			if(us>0) {
				System.out.println("Book ID: "+id+"\nTitle: "+title+"\nPrice: "+price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void read(int id) {
		// TODO Auto-generated method stub
		try (Connection connection = MyConnection.getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(READ_QUERY);
			preparedStatement.setInt(1,id);
			
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				int bookId = rs.getInt("bookId");
				String title = rs.getString("title");
				float price = rs.getFloat("price");
				System.out.println("Book ID: "+bookId+"\nTitle: "+title+"\nPrice: "+price);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void readAll() {
		// TODO Auto-generated method stub
		try (Connection connection = MyConnection.getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(READALL_QUERY);
			
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				int bookId = rs.getInt("bookId");
				String title = rs.getString("title");
				float price = rs.getFloat("price");
				System.out.println("Book ID: "+bookId+"\nTitle: "+title+"Price: \n"+price);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void update(int id) {
	    System.out.println("Enter the column name you want to update: ");
	    String colName = sc.next();
	    sc.nextLine();
	    System.out.println("Enter new value: ");
	    String newVal = sc.nextLine();
	    
	    if(!((colName.equals("bookId") || colName.equals("title") || colName.equals("price")))) {
	    	System.out.println("Invalid column name. Please enter bookId, title, or price.");
	        return;
	    }

	    try (Connection connection = MyConnection.getConnection()) {
	        String formattedUpdateQuery = String.format(UPDATE_QUERY, colName);
	        PreparedStatement preparedStatement = connection.prepareStatement(formattedUpdateQuery);
	        preparedStatement.setString(1, newVal);
	        preparedStatement.setInt(2, id);

	        int us = preparedStatement.executeUpdate();

	        if (us > 0) {
	            System.out.println("Book ID: " + id + " updated successfully");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try (Connection connection = MyConnection.getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
			preparedStatement.setInt(1,id);
			
			int us = preparedStatement.executeUpdate();
			
			if(us>0) {
				System.out.println("Book ID: "+id+" deleted successfully");
			}
			else {
				System.out.println("Book not found with ID: "+id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	

}
