package person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDAO {
	
	private Connection connectToDb() {
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/nithin_db";
		try {
			connection = DriverManager.getConnection(url, "root", "Root123");
			System.out.println("DB connected");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB connection failed");
		}
		return connection;
	}
	
	private Person readPersonDetails() {
		System.out.print("Enter person name: ");
		String name = PersonDemo.scanner.next();
		System.out.print("Enter person location: ");
		String location = PersonDemo.scanner.next();
		System.out.print("Enter person gender: ");
		String gender = PersonDemo.scanner.next();
		System.out.print("Enter person age: ");
		short age = PersonDemo.scanner.nextShort();
		Person person = new Person(name, location, gender, age);
		return person;
	}
	
	public void insertPerson() {
		Connection connection = connectToDb();
		Person person = readPersonDetails();
		String query = "insert into people(name, location, gender, age) values(?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(query);		
			stmt.setString(1, person.getName());
			stmt.setString(2, person.getLocation());
			stmt.setString(3, person.getGender());
			stmt.setInt(4, person.getAge());
			int i = stmt.executeUpdate();
			if (i == 1) {
				System.out.println("Row Inserted successfully");
			}
			connection.close();
			System.out.println("DB disconnected");
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Row insertion failed");
		}
	}
	
	public void searchPerson() {
		Connection connection = connectToDb();
		String query = "select * from people where id = ?";
		System.out.print("Enter Id of the Person to search: ");
		int id = PersonDemo.scanner.nextInt();
		try {
			PreparedStatement stmt = connection.prepareStatement(query);	
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Person person = new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getShort(5));
				System.out.println(person);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Search Record failed");
		}
	}

	public void updatePerson() {
		Connection connection = connectToDb();
		String query = "update people set location = ? where id = ?";
		System.out.print("Enter new location of the Person: ");
		String location = PersonDemo.scanner.next();
		System.out.print("Enter Id of the Person to update: ");
		int id = PersonDemo.scanner.nextInt();
		try {
			PreparedStatement stmt = connection.prepareStatement(query);	
			stmt.setString(1, location);
			stmt.setInt(2, id);
			int count = stmt.executeUpdate();
			if(count == 1)
				System.out.println("Row updated");
			else
				System.out.println("Person with Id = " + id + " not found");
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Search Record failed");
		}	
	}

	public void deletePerson() {
		
		
	}

	public void listAllPersons() {
		Connection connection = connectToDb();
		String query = "select * from people";
		try {
			Statement stmt = connection.createStatement();	
			stmt.execute(query);
			ResultSet rs = stmt.getResultSet();
			while(rs.next()) {
				Person person = new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getShort(5));
				System.out.println(person);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Search Record failed");
		}
	}

}
