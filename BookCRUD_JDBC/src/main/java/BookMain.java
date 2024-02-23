import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) { 
	
		Scanner sc=new Scanner(System.in);
//		Book books[]=null;
		BookDAOImpl dao=new BookDAOImpl();
		int choice=0;
		do
		{
			System.out.println("***********Menu************");
			System.out.println("1-Create a book");
			System.out.println("2-Read a book");
			System.out.println("3-Read All Books");
			System.out.println("4-Update a book");
			System.out.println("5-Delete a book");
			System.out.println("6-Exit");
			System.out.println("Please enter your choice?");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter BookId: ");
				int id=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Book Title: ");
				String title=sc.nextLine();
				System.out.println("Enter Book price:  ");
				float price=sc.nextFloat();
				System.out.println(id+"\n"+title+"\n"+price);
				dao.create(id,title,price);
				
				System.out.println("Book created successfully");
				break;
			case 2:
				System.out.println("Enter BookId: ");
				id=sc.nextInt();
				dao.read(id);
				break;
			case 3:dao.readAll();
				break;
			case 4:
				System.out.println("Enter the BookId to update:");
				id = sc.nextInt();
				dao.update(id);
				break;
			case 5:
				System.out.println("Enter the BookId to delete:");
				id = sc.nextInt();
				dao.delete(id);
				break;
			
			case 6:
				System.exit(0);
			
			}			
		}while(choice!=6);
	}

}
