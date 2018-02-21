package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class DefaultObservableProperty<V> implements ObservableProperty<V>, PropertyObserver<V> {
	private V value;
	private List<PropertyObserver<V>> observers;
	
	public DefaultObservableProperty(V value) {
		this.value = value;
		this.observers = new ArrayList<PropertyObserver<V>>();
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public void addObserver(PropertyObserver<V> o) {
		if(!observers.contains(o)) {
			observers.add(o);
		}
		
	}

	@Override
	public void removeObserver(PropertyObserver<V> o) {
		if(observers.contains(o)) {
			observers.remove(o);
		}
	}
	
	protected void setValue(V newValue) {
		V oldValue = value;
		value = newValue;
		if(oldValue == value) {
			return;
		}
		for(PropertyObserver<V> o: observers) {
			o.propertyChanged(this, oldValue);
		}
	}
	
	public String toString() {
		return "(" + this.value + ": Observers: " + this.observers + ")";
	}

}
