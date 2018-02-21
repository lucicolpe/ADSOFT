package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tasks.Task;
import tasks.Tasks;

public class TextConsole/* implements FunctionInterface */{
	Map<String, Function> commands;
        Task actual;
        long tiempoInicial;
	
	public TextConsole(){
            commands = new HashMap<String, Function>();
            this.addCommands("start", (args) -> {
                if(args == null) {
                    System.out.println("Introduzca una tarea.");
                } else {
                    if(actual != null) {
                        int tiempoDedicado = (int) (System.currentTimeMillis()/1000 - tiempoInicial);
                        System.out.println("Tarea " + actual.getName() + " detenida. Tiempo dedicado: " + tiempoDedicado);
                        actual.getDedicated().incrementTime(tiempoDedicado);
                    }
                    actual = Tasks.getInstance().searchTask(args[0]);
                    if(actual == null) {
                        actual = Tasks.getInstance().newTask(args[0]);
                        System.out.println("Creada tarea " + actual.getName() + ".");
                    } else {
                        System.out.println("Tarea " + actual.getName() + " fijada como tarea actual.");
                    }
                    tiempoInicial = System.currentTimeMillis()/1000;
                }
            });
            this.addCommands("stop", (args) -> {
                if(actual == null) {
                    System.out.println("No existe una tarea actual.");
                } else {
                    int tiempoDedicado = (int) (System.currentTimeMillis()/1000 - tiempoInicial);
                    System.out.println("Tarea " + actual.getName() + " detenida. Tiempo dedicado: " + tiempoDedicado);
                    actual.getDedicated().incrementTime(tiempoDedicado);
                    actual = null;
                }
            });
            this.addCommands("addEstimate", (args) -> {
                if(actual == null) {
                    System.out.println("No existe una tarea actual.");
                } else {
                    int value = Integer.parseInt(args[0]);
                    if(actual.getEstimated().getValue() + value < 0) {
                        System.out.println("El tiempo estimado no puede ser menor que 0.");
                    } else {
                        actual.getEstimated().incrementTime(value);
                        System.out.println("Tiempo estimado de la tarea " + actual.getName() + " ajustado. Nuevo valor: " + actual.getEstimated().getValue());
                    }
                }
            });
            this.addCommands("spend", (args) -> {
                if(actual == null) {
                    System.out.println("No existe una tarea actual.");
                } else {
                    int value = Integer.parseInt(args[0]);
                    if(actual.getDedicated().getValue() + value < 0) {
                        System.out.println("El tiempo dedicado no puede ser menor que 0.");
                    } else {
                        actual.getDedicated().incrementTime(value);
                        System.out.println("Tiempo dedicado de la tarea " + actual.getName() + " ajustado. Nuevo valor: " + actual.getDedicated().getValue());
                    }
                }
            });
            this.addCommands("parent", (args) -> {
                if(actual == null) {
                    System.out.println("No existe una tarea actual.");
                } else {
                    if(args.length == 0) {
                        actual.setParent(null);
                    } else {
                        Task t = Tasks.getInstance().searchTask(args[0]);
                        if(t == null) {
                            System.out.println("Error: no se encontró la tarea.");
                        } else {
                            if(actual.containsTask(t)) {
                                System.out.println("No se puede designar a esta tarea como padre.");
                            } else {
                                actual.setParent(t);
                                System.out.println("Tarea " + actual.getParent().getName() + " designada como padre de la tarea " + actual.getName() + ".");
                            }
                        }
                    }
                }
            });
            this.addCommands("list", (args) -> {
                List<Task> list = Tasks.getInstance().getTasks();
                List<String> listNombres = new ArrayList<String>(list.size());
                for(Task t: list) {
                    listNombres.add(t.getName());
                }
                Collections.sort(listNombres);
                System.out.println("Lista de tareas: ");
                for(String nombre: listNombres) {
                    System.out.println(nombre);
                }
            });
            this.addCommands("status", (args) -> {
                Task t;
                if(args.length == 0) {
                    t = actual;
                } else {
                    t = Tasks.getInstance().searchTask(args[0]);
                }
                if(t == null) {
                    System.out.println("Especifique una tarea.");
                } else {
                    if(t.getParent() == null) {
                        System.out.println(t.getName() + ": Tiempo estimado: " + t.getEstimated().getValue() + ". Tiempo dedicado: " + t.getDedicated().getValue() + ". Tarea padre: Ninguna");
                    } else {
                        System.out.println(t.getName() + ": Tiempo estimado: " + t.getEstimated().getValue() + ". Tiempo dedicado: " + t.getDedicated().getValue() + ". Tarea padre: " + t.getParent().getName());
                    }
                }
            });
	}
	
	
	public boolean addCommands(String name, Function op){
		if(commands.containsKey(name)){
			return false;
		}
		else{
			commands.put(name, op);
			return true;
		}
	}
	
	
	public void run() throws IOException{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(reader);
		String linea;
		String args[];
		while(!(linea = buffer.readLine().trim()).equals("")) {
			String split[] = linea.split(" ");	
			if(commands.containsKey(split[0])) {
                            commands.get(split[0]).execute(Arrays.copyOfRange(split, 1, split.length));
                        } else {
                            System.out.println("Comando no reconocido.");
                        }
		}
	}
}
