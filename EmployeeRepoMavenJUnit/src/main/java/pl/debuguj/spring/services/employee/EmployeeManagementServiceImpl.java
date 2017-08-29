package pl.debuguj.spring.services.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.debuguj.spring.dataaccess.EmployeeDao;
import pl.debuguj.spring.dataaccess.RecordNotFoundException;
import pl.debuguj.spring.domain.Employee;

@Transactional
@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

	
	EmployeeDao dao;
	
	@Autowired
	public EmployeeManagementServiceImpl(EmployeeDao dao){
		this.dao = dao;
	}

	@Override
	public void addEmployee(Employee e) {
		dao.createEmployee(e);
		
	}

	@Override
	public void removeEmployee(Employee e) throws RecordNotFoundException {
		dao.deleteEmployeeById(e);		
	}

	@Override
	public Employee findEmployeeById(int id) throws RecordNotFoundException {
		return dao.findEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}
	



}
