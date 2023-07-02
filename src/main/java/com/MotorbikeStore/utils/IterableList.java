package com.MotorbikeStore.utils;

import java.util.Iterator;
import java.util.List;

import com.MotorbikeStore.model.ProductDetailModel;

public class IterableList<T> implements Iterable<T> {

    private List<T> arrayList;
    private int currentSize;
    
 // Getter
    public List<T> getArrayList() {
      return arrayList;
    }

    public IterableList(List<T> list) {
        this.arrayList = list;
        this.currentSize = arrayList.size();
    }

    public IterableList() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && arrayList.get(currentIndex) != null;
            }

            @Override
            public T next() {
            		return arrayList.get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
        };
        return it;
    }

	public void remove(int i) {
		arrayList.remove(i);
    	currentSize = arrayList.size();
		
	}
}