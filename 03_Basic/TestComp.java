package Basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class TestComp {

	public static void main(String[] args) {

		List<Developer> listDevs = getDevelopers();

		System.out.println("Before Sort");
		for (Developer developer : listDevs) {
			System.out.print(" : " + developer.getName()+" "+developer.getSalary()+" "+developer.getAge()+"\n");
		}
		
		//sort by age
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		
		//lambda here!
		listDevs.sort((Developer o1, Developer o2)->o1.getAge()-o2.getAge());
		
		listDevs.sort((o1, o2)->o1.getName().compareTo(o2.getName()));	
		

	
	
		//java 8 only, lambda also, to print the List
		listDevs.forEach((developer)->System.out.println(developer));
			
//		
//		//2
//		//sort by name
//		Collections.sort(listDevs, new Comparator<Developer>() {
//			@Override
//			public int compare(Developer o1, Developer o2) {
//				return o1.getName().compareTo(o2.getName());
//			}
//		});
//		//lambda
//		listDevs.sort((Developer o1, Developer o2)->o1.getName().compareTo(o2.getName()));		
//		//lambda
//		listDevs.sort((o1, o2)->o1.getName().compareTo(o2.getName()));		
//		
		//3
		//sort by salary
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
		});				
		//lambda
		listDevs.sort((Developer o1, Developer o2)->o1.getSalary().compareTo(o2.getSalary()));
		//lambda
		listDevs.sort((o1, o2)->o1.getSalary().compareTo(o2.getSalary()));
		
		listDevs.sort((o1, o2)->o1.getSalary()- o2.getSalary());
		
	
		System.out.println("After Sort");
		for (Developer developer : listDevs) {
			System.out.print(" : " + developer.getName()+" "+developer.getSalary()+" "+developer.getAge()+"\n");
		}
		
	}

	private static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

//		result.add(new Developer("david", new BigDecimal("70000"), 33));
//		result.add(new Developer("James", new BigDecimal("80000"), 20));
//		result.add(new Developer("jason", new BigDecimal("100000"), 10));
//		result.add(new Developer("arikato", new BigDecimal("170000"), 55));
		
		result.add(new Developer("david",70000, 33));
		result.add(new Developer("James", 80000, 20));
		result.add(new Developer("jason", 100000, 10));
		result.add(new Developer("arikato", 170000, 55));
		
		return result;

	}
	
}

class Developer {
	private String name;
	private int salary;
	private int age;
	public Developer(String name, int salary, int age) {
		this.name=name;
		this.salary=salary;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return name+"" +salary+" "+age;
	}
}
