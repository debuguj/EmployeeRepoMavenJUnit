package pl.debuguj.spring.services.employee;

import java.util.List;

import pl.debuguj.spring.dataaccess.RecordNotFoundException;
import pl.debuguj.spring.domain.Employee;

public interface EmployeeManagementService {

	public void addEmployee(Employee e);
	public void removeEmployee(Employee e) throws RecordNotFoundException;
	public Employee findEmployeeById(int id) throws RecordNotFoundException;
	
	public List<Employee> getAllEmployees();

}
