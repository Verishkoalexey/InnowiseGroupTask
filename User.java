package model;

public class User {
	private int id;
	private String name;
	private String lastName;
	private String email;
	private String role;
	private String numberPhone;
	
	public User(String name, String lastName, String email, String role, String numberPhone) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.numberPhone = numberPhone;
	}

	public User(int id) {
		this.id = id;
	}
	
	public User() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		String str = "Ваш Email не содержит @ или отсутствует . ";
		if(email.contains("@")&& email.contains(".")) {
			return email;
		}
		return str;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNumberPhone() {
		String str = "Номер введённого телефона начинается не с 375";
		if(numberPhone.startsWith("375")) {
			return numberPhone;
		}
		return str;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", role=" + role
				+ ", numberPhone=" + numberPhone + "]";
	}
	
	
	
	
}
