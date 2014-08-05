import java.util.*;

/*
 * 1. Add all the items and their weights using the Add() function.
 * 2. Create a random float between 0 and the total weight, gotten from GetTotalWeight()
 * 3. Use Select(), giving it the random number in order to retrieve the item
 * 
 * The random number generation is left out of this class to allow for different implementations
 * of random functions.
 */ 

public class WeightedSelector<T> {
	
	private ArrayList<WeightedSelectorItem<T>> items = new ArrayList<WeightedSelectorItem<T>>();
	private float totalWeight = 0f;
	
	public void add(T item, float weight) {
		WeightedSelectorItem<T> newItem = new WeightedSelectorItem<T>(item, weight);
		totalWeight += weight;
		items.add(newItem);
	}
	
	public float getTotalWeight() {
		return totalWeight;
	}
	
	public T select(float val) {
		float weightSum = 0f;
		for(WeightedSelectorItem<T> item : items) {
			weightSum += item.weight;
			if (val <= weightSum) {
				return (T)item.item;	
			}
		}
		return null;
	}

	private class WeightedSelectorItem<T> {
		public T item;
		public float weight;
		
		public WeightedSelectorItem(T item, float weight) {
			this.item = item;
			this.weight = weight;
		}
	}
}