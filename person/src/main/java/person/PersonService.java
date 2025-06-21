package person;

public class PersonService {
	
	private static final PersonDAO dao;
	
	static {
		dao = new PersonDAO();
	}
	
	public static void createPerson() {
		dao.insertPerson();
	}
	
	public static void readPerson() {
		dao.searchPerson();
	}
	
	public static void updatePerson() {
		dao.updatePerson();
	}
	
	public static void deletePerson() {
		dao.deletePerson();
	}
	
	public static void listAllPersons() {
		dao.listAllPersons();
	}
}
