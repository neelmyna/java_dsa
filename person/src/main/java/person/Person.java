package person;

public class Person {
	private int id;
	private String name;
	private String location;
	private char gender;
	private short age;

	public Person(String name, String location, char gender, short age) {
		super();
		this.name = name;
		this.location = location;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", location=" + location + ", gender=" + gender + ", age=" + age
				+ "]";
	}

}
