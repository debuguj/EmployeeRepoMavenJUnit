package pl.debuguj.spring.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.debuguj.spring.dataaccess.RecordNotFoundException;
import pl.debuguj.spring.domain.Employee;
import pl.debuguj.spring.domain.Task;
import pl.debuguj.spring.services.employee.EmployeeManagementService;
import pl.debuguj.spring.services.task.TaskService;

public class Client {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
		
		TaskService taskService = container.getBean(TaskService.class);
		EmployeeManagementService employeeService = container.getBean(EmployeeManagementService.class);
		
//		Employee e1 = new Employee(1, "Zbychu", "Zychu", 8000);	
//		Employee e2 = new Employee(2, "Zdzichu", "Smutas", 5000);
//		Employee e3 = new Employee(3, "Wladziu", "Smiglo", 6000);
//		Employee e4 = new Employee(4, "Bronek", "Grodek", 2000);		
//		employeeService.addEmployee(e1);
//		employeeService.addEmployee(e2);
//		employeeService.addEmployee(e3);
//		employeeService.addEmployee(e4);
		
		try {
			System.out.println("Employee found: "+employeeService.findEmployeeById(3));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Task t1 = new Task(1, "Make database management");
//		Task t2 = new Task(2, "Make security");		
//				
//		t1.addEmployee(e1);
//		t1.addEmployee(e2);
//		t1.addEmployee(e4);
//		
//		t2.addEmployee(e2);
//		t2.addEmployee(e3);		
//		
//		taskService.addTask(t1);
//		taskService.addTask(t2);
		
	    System.out.println(employeeService.getAllEmployees());
//	    System.out.println(taskService.showTasks());

		container.close();
	}
}
