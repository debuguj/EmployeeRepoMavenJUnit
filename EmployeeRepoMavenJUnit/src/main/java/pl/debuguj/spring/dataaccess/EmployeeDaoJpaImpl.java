package pl.debuguj.spring.dataaccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pl.debuguj.spring.domain.Employee;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void createEmployee(Employee e) {
		em.persist(e);
		
	}

	@Override
	public void deleteEmployeeById(Employee e) throws RecordNotFoundException 
	{		
		em.remove(e);
	}

	@Override
	public Employee findEmployeeById(int id) throws RecordNotFoundException {
		try
		{
			return (Employee)em.createQuery("select employee from Employee as employee where employee.id=:id")
				.setParameter("id", id)
				.getSingleResult();
		}
		catch (NoResultException e)
		{
			throw new RecordNotFoundException();
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		return em.createQuery("select employee from Employee as employee").getResultList();
	}

}
