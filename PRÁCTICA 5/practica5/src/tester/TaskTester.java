package tester;

import tasks.Task;
import tasks.Tasks;

public class TaskTester {
	public static void main(String[] args) {
		Tasks tasks = Tasks.getInstance();
                System.out.println("Creamos dos tareas: Task1 y Task 2.");
		tasks.newTask("Task1");
		tasks.newTask("Task2");
                System.out.println("Intentamos crear otra tarea Task1.");
		try {
			tasks.newTask("Task1");
		} catch (IllegalArgumentException e) {
			System.out.println(e + ". Nombre de tarea ya existe.");
		}
                System.out.printf("\n");
		Task t1 = tasks.searchTask("task1");
		System.out.println("Búsqueda por \"task1\":" + t1);
		Task t2 = tasks.searchTask("Task2");
                System.out.println("Búsqueda por \"Task2\":" + t2);
                System.out.printf("\n");
                System.out.println("Añadimos Task2 a Task1.");
		if(t1.addTask(t2)) {
                    System.out.println("Tarea Task2 añadida correctamente a Task1.");
                }
		System.out.println("Tareas hijas de 1: " + t1.getTasks());
		System.out.println("Tarea padre de 2: " + t2.getParent());
                System.out.printf("\n");
                System.out.println("Aumentamos los tiempos estimado y dedicado de Task1.");
		t1.getEstimated().incrementTime(10);
		t1.getDedicated().incrementTime(5);
		System.out.println(t1 + " " + t2);
                System.out.println("Aumentamos los tiempos estimado y dedicado de Task2.");
		t2.getEstimated().incrementTime(2);
		t2.getDedicated().incrementTime(1);
		System.out.println(t1 + " " + t2);
                System.out.printf("\n");
                System.out.println("Comprobamos situaciones extremas:");
		if(!t2.addTask(t1)) {
                    System.out.println("No se crean bucles.");
                }
                if(!t1.addTask(t2)) {
                    System.out.println("No se añaden repetidas.");
                }
                System.out.printf("\n");
                System.out.println("Creamos dos tareas: Task3 y Task 4.");
                Task t3 = tasks.newTask("Task3");
                Task t4 = tasks.newTask("Task4");
                System.out.println("Añadimos Task3 a Task2.");
                if(t2.addTask(t3)) {
                    System.out.println("Tarea Task3 añadida correctamente a Task2.");
                }
                System.out.println("Añadimos Task4 a Task1.");
                if(t1.addTask(t4)) {
                    System.out.println("Tarea Task4 añadida correctamente a Task1.");
                }
                System.out.printf("\n");
                System.out.println("Comprobamos situaciones extremas indirectas:");
                if(t1.containsTask(t3)) {
                    System.out.println("Las contenidas indirectamente también se consideran.");
                }
                if(!t3.addTask(t1)) {
                    System.out.println("No se crean bucles indirectos.");
                }
                System.out.printf("\n");
                System.out.println("Intentamos añadir una tarea que ya tiene padre a otra.");
                try {
                    t2.addTask(t4);
                } catch (IllegalArgumentException e) {
                    System.out.println(e + ". Las tareas no pueden tener varios padres.");
                }
                System.out.println("Aumentamos los tiempos de las nuevas tareas.");
                t3.getEstimated().incrementTime(8);
		t3.getDedicated().incrementTime(3);
                t4.getEstimated().incrementTime(30);
		t4.getDedicated().incrementTime(4);
                System.out.println(t1);
                System.out.println(t2);
                System.out.println(t3);
                System.out.println(t4);
                System.out.printf("\n");
                System.out.println("Cambiamos el padre de Task4. Ahora es Task3.");
                t4.setParent(t3);
                System.out.println(t1);
                System.out.println(t2);
                System.out.println(t3);
                System.out.println(t4);
	}
}
