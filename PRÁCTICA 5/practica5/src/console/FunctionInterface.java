package console;

@FunctionalInterface
public interface FunctionInterface {
	void execute(String ...args) throws IllegalArgumentException;
}
