package pl.debuguj.spring.dataaccess;

import java.util.List;

import pl.debuguj.spring.domain.Employee;

public interface EmployeeDao {

	public void createEmployee(Employee e);
	

	public void deleteEmployeeById(Employee e) throws RecordNotFoundException ;


	public Employee findEmployeeById(int id) throws RecordNotFoundException ;

	
	public List<Employee> getAllEmployees() ;
}
