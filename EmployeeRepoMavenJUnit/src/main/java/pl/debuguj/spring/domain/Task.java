package pl.debuguj.spring.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task {
	
	private int id;
	private String definition;
	
	List<Employee> listEmployees = new ArrayList<Employee>();	
	
	Task(){
		
	}
	
	public Task(int id, String definition){
		this.id = id;
		this.definition = definition;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDefinition() {
		return definition;
	}


	public void setDefinition(String definition) {
		this.definition = definition;
	}


	public List<Employee> getListEmployees() {
		return Collections.unmodifiableList(listEmployees);
	}	
	
	
	public void addEmployee(Employee e){
		this.listEmployees.add(e);
	}
	
	@Override
	public String toString() {
		
		return "Task: id="+id+" Definition: "+definition;
	}
	
}
