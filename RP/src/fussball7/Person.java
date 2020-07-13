package fussball7;

public abstract class Person {
	
	private int id;
	private String name;
	private int alter;
	
	public Person(int id, String name, int alter) {
		this.name = name;
		this.alter = alter;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAlter() {
		return alter;
	}
	
	public void setAlter(int alter) {
		this.alter = alter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
