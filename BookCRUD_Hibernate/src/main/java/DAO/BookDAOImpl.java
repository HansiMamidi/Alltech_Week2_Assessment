package DAO;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.Book;
import util.HibernateUtil;

public class BookDAOImpl implements BookDAO {

	@Override
	public void create(String title, String author, float price) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.buildSessionFactory().openSession();
		session.beginTransaction();
		Book book = new Book(title,author, price);
		session.persist(book);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void read(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.buildSessionFactory().openSession();
		session.beginTransaction();
		Book book = session.get(Book.class, 1);
//		session.persist(book);
		System.out.println("Book Details: \nBook ID: "+book.getId()+"\nTitle: "+book.getTitle()+"\nAuthor: "+book.getAuthor()+"\nPrice: "+book.getPrice());
		session.getTransaction().commit();
		session.close();		
	}

	@Override
	public void readAll() {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.buildSessionFactory().openSession();
		session.beginTransaction();
		// Use HQL to retrieve all books
        String hql = "FROM Book";
        Query<Book> query = session.createQuery(hql, Book.class);
        java.util.List<Book> books = query.list();

        if (!books.isEmpty()) {
            // Print or process each book information
            System.out.println("All Books:");
            for (Book book : books) {
                System.out.println("ID: " + book.getId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Price: " + book.getPrice());
                System.out.println("--------------");
            }
        } else {
            System.out.println("No books found in the database.");
        }
        session.getTransaction().commit();
		session.close();		
	}

	@Override
	public void update(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.buildSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		txn.begin();
		Book book = session.get(Book.class, id);
		Scanner sc = new Scanner(System.in);

        System.out.println("Choose the column to update (title, author, price): ");
        String columnToUpdate = sc.next();

        switch (columnToUpdate.toLowerCase()) {
            case "title":
                System.out.println("Enter a new Title: ");
                String newTitle = sc.next();
                book.setTitle(newTitle);
                break;
            case "author":
                System.out.println("Enter a new Author: ");
                String newAuthor = sc.next();
                book.setAuthor(newAuthor);
                break;
            case "price":
                System.out.println("Enter a new Price: ");
                float newPrice = sc.nextFloat();
                book.setPrice(newPrice);
                break;
            default:
                System.out.println("Invalid column choice. No updates performed.");
                break;
        }
		txn.commit();	
		session.close();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.buildSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		txn.begin();
		Book book = session.get(Book.class, id);
		session.remove(book);		
		txn.commit();	
		session.close();		
	}
	
	
	

}
