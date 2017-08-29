package pl.debuguj.spring.services.task;

import pl.debuguj.spring.domain.Task;

public interface TaskService {

	public void addTask(Task t);
	public String showTasks();
}
