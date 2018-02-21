package tasks;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import observer.ObservableTime;

public class Task {
	String name;
	ObservableTime estimated;
	ObservableTime dedicated;
	Task parent;
	Set<Task> childs;
	
	public Task(String name, ObservableTime estimated, ObservableTime dedicated) {
		this.name = name;
		this.estimated = estimated;
		this.dedicated = dedicated;
		this.parent = null;
		this.childs = new HashSet<Task>();
	}

	public String getName() {
		return name;
	}
	
	public boolean addTask(Task t) {
		if(this.containsTask(t) || t.containsTask(this)) {
			return false;
		}
		if(t.getParent() != null) {
			throw new IllegalArgumentException();
		}
		this.childs.add(t);
		t.parent = this;
		this.getEstimated().addProperty(t.getEstimated());
		t.getEstimated().addObserver( (p,v) -> System.out.println("La tarea " + t.name + " ha cambiado. Nuevo tiempo estimado: " + p.getValue() + ". Valor antiguo: " + v + "."));
		this.getDedicated().addProperty(t.getDedicated());
		t.getDedicated().addObserver( (p,v) -> System.out.println("La tarea " + t.name + " ha cambiado. Nuevo tiempo dedicado: " + p.getValue() + ". Valor antiguo: " + v + "."));
		return true;
	}
	
	public boolean removeTask(Task t) {
		if(!this.containsTask(t)) {
			return false;
		}
		if(this.childs.contains(t)) {
			this.childs.remove(t);
			t.parent = null;
			return true;
		} else {
			return this.parent.removeTask(t);
		}
	}
	
	public Set<Task> getTasks() {
		return Collections.unmodifiableSet(childs);
	}
	
	public boolean containsTask(Task t) {
		if (this == t) {
			return true;
		}
		if(this.childs.contains(t)) {
			return true;
		}
		for(Task t1: this.childs) {
                    if(t1.containsTask(t) == true) {
                        return true;
                    }
                }
                return false;
	}
	
	public Task getParent() {
		return parent;
	}
	
	public void setParent(Task parent) {
		if(this.containsTask(parent)) {
			throw new IllegalArgumentException();
		}
		if(this.parent != null) {
			this.parent.removeTask(this);
		}
		parent.addTask(this);
	}
	
	public ObservableTime getEstimated() {
		return estimated;
	}
	
	public ObservableTime getDedicated() {
		return dedicated;
	}
	
	public String toString() {
		return "[" + this.name + " (E:" + this.estimated.getValue() + "|D:" + this.dedicated.getValue() + ") ]";
	}

}
