package units;

public enum Quantity {
	LENGTH, TIME;
	
	public String toString() {
		if(this == LENGTH) {
			return "L";
		} else {
			return "t";
		}
	}
}
