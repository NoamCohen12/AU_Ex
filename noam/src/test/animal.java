package test;

public class animal {
	protected String name;
	protected double age;
	
	protected animal() {////constructor difultivi
	this.name="rexi";
	this.age=5.5;
	}
	protected animal (String name  , double age ) {//////counstructor
		this.name=name;
		this.age=age;
	}
	
	
	protected void setName(String name) {////functions set
		this.name = name;
	}
	protected void setAge(double age) {
		this.age=age;
	}
	

	protected String getName() {////functions set
		return name;
	}
	protected double  getAge () {
		return age;
	}	
	
	protected void sleep() {///////fanctions sleep and makeSound
		System.out.println("Animal sleep");
	}
	protected void makeSound() {
		System.out.println("haww");
	}
	
	}
	


