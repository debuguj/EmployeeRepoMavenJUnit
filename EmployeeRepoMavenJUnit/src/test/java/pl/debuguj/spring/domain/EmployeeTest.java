package pl.debuguj.spring.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

	private static final double DELTA = 1e-15;
	@Test
	public void testClassConstructor() {
		
		int id = 100;
		String name = "Greg";
		String surname = "Gonzo";
		double salary = 1000;
		
		Employee testEmployee = new Employee(id, name, surname, salary);
		
		assertEquals("Incorrect id", id, testEmployee.getId());
		assertEquals("Incorrect name", name, testEmployee.getName());
		assertEquals("Incorrect surname", surname, testEmployee.getSurname());
		assertEquals("Incorrect salary", salary, testEmployee.getSalary(), DELTA);//DELTA bo u¿ywamy typu double


	}

}
