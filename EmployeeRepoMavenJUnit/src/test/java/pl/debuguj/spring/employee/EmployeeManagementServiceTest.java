package pl.debuguj.spring.employee;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pl.debuguj.spring.dataaccess.EmployeeDaoMockImpl;
import pl.debuguj.spring.dataaccess.RecordNotFoundException;
import pl.debuguj.spring.domain.Employee;
import pl.debuguj.spring.services.employee.EmployeeManagementService;
import pl.debuguj.spring.services.employee.EmployeeManagementServiceImpl;

public class EmployeeManagementServiceTest {
	
	EmployeeDaoMockImpl employeeDao = new EmployeeDaoMockImpl();
	EmployeeManagementService employeeService = new EmployeeManagementServiceImpl(employeeDao);

	@Test
	public void testAddEmployee()
	{
		
		Employee testEmployee1 = new Employee(10, "Makr", "Zuckenber", 100);
		Employee testEmployee2 = new Employee(11, "Wiktor", "Orban", 10000);
		
		employeeService.addEmployee(testEmployee1);
		employeeService.addEmployee(testEmployee2);
		
		int employeesInDb = employeeService.getAllEmployees().size(); 		
		assertEquals("There should be 6 employees in the database", 6, employeesInDb);		 
	}		
	
	@Test(expected = RecordNotFoundException.class)
	public void testRemoveEmployee() throws RecordNotFoundException
	{		
		Employee removeEmployee = new Employee(998989, "Teo", "Teofilski", 100);		
		employeeService.removeEmployee(removeEmployee);	 
	}
	
	@Test
	public void testFindEmployeeById()
	{
		int employeeId = 12;
		Employee testEmployee = new Employee(employeeId, "Zurma", "Stanisławski", 100);
		
		employeeService.addEmployee(testEmployee);
		
		Employee foundEmployee;
		try
		{
			foundEmployee = employeeService.findEmployeeById(employeeId);
			assertEquals("Teh employee returned is not correct", testEmployee, foundEmployee);
		} 
		catch(Exception ex)
		{
			fail("Uknown error occured");
		}
	}
	
	@Test(expected = RecordNotFoundException.class)  
	public void testFindingNonExistentBook() throws RecordNotFoundException
	{
 	    Employee foundEmployee = employeeService.findEmployeeById(999999999);
	}
}
