package tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import observer.ObservableTime;

public class Tasks {
	private static Tasks instance;
	List<Task> tasks;
	
	private Tasks() {
		this.tasks = new ArrayList<Task>();
	}
	
	public static Tasks getInstance() {
		if(instance == null) {
			instance = new Tasks();
		}
		return instance;
	}
        
        public List<Task> getTasks() {
            return Collections.unmodifiableList(tasks);
        }
	
	public Task newTask(String taskName) {
		for(Task t: this.tasks) {
			if(t.getName().equalsIgnoreCase(taskName)) {
				throw new IllegalArgumentException();
			}
		}
		Task t = new Task(taskName, new ObservableTime(0), new ObservableTime(0));
		this.tasks.add(t);
		return t;
	}
	
	public Task searchTask(String name) {
		for(Task t: this.tasks) {
			if(t.getName().equalsIgnoreCase(name)) {
				return t;
			}
		}
		return null;
	}
	
	
}
