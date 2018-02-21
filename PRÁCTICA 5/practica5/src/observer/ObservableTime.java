package observer;

public class ObservableTime extends DefaultObservableProperty<Integer> implements AdjustableTime {
	public ObservableTime(Integer value) {
		super(value);
	}

	public void addProperty(ObservableProperty<Integer> prop) {
		prop.addObserver(this);
		this.setValue(this.getValue() + prop.getValue());
	}
	
	public void removeProperty(ObservableProperty<Integer> prop) {
		prop.removeObserver(this);
		this.setValue(this.getValue() - prop.getValue());
	}
	
	@Override
	public void incrementTime(int inc) {
		int value = this.getValue() + inc;
		if (value < 0) {
			throw new IllegalArgumentException();
		}
		this.setValue(value);
	}

	@Override
	public void propertyChanged(ObservableProperty<Integer> property, Integer oldValue) {
		this.setValue(this.getValue() + property.getValue() - oldValue);
	}
	
}
