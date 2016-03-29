package my.singleton;

public class MySingletonOne {
	
	private String name;
	
	private MySingletonOne(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
