package com.epam.grow;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;

import com.epam.exception.ArrayIndexOutOfBound;

public class CustomList<T> {

	private T[] baseArray;
	private int length;
	private int arrayFillSize;
	private int defaultSizeforClear;

	@SuppressWarnings("unchecked")
	public CustomList(int defaultSize) {
		createBaseArray(defaultSize);
		this.length = defaultSize;
		this.defaultSizeforClear = defaultSize;
	}

	private void createBaseArray(int defaultSize) {
		Class<T> classes = (Class<T>) Object.class;
		this.baseArray = (T[]) Array.newInstance(classes, defaultSize);
		arrayFillSize = 0;
	}

	public void add(T value) {
		checKArrayFillRatio();
		baseArray[arrayFillSize] = value;
		arrayFillSize++;
	}

	private void checKArrayFillRatio() {
		if (arrayFillSize == (length * 75 / 100)) {
			resizeBaseArray();

		}
	}

	
	public T getElementByIndex(int index) throws ArrayIndexOutOfBound {
		if (index < arrayFillSize && index >= 0)
			return baseArray[index];
		throw new ArrayIndexOutOfBound(index);
	}

	public void removeElementByIndex(int index) throws Exception {
		if (index < arrayFillSize) {
			for (int sIndex = 0; sIndex < arrayFillSize; sIndex++) {
				if (index == sIndex) {
					deleteAndswapLeft(index);
				}
			}
		} else {
			throw new ArrayIndexOutOfBound(index);
		}

	}

	private void deleteAndswapLeft(int start) {
		this.arrayFillSize++;
		for (int index = start + 1; index < arrayFillSize; index++) {
			baseArray[index] = baseArray[index + 1];
		}
		arrayFillSize--;
	}

	private void resizeBaseArray() {
		baseArray = Arrays.copyOf(baseArray, baseArray.length * 2);
		this.length = length * 2;
	}

	public void clear() {
		for (int index = 0; index < arrayFillSize; index++)
			baseArray[index] = null;
		createBaseArray(defaultSizeforClear);
	}

	public boolean containValue(T value) {
		boolean isfound = false;
		Optional<T> optional = Arrays.stream(baseArray).filter(x -> value.equals(x)).findFirst();
		if (optional.isPresent()) {
			isfound = true;
		}
		return isfound;
	}

	public void insertElementByPosition(int index, T value) throws Exception {
		if (index < 0 || index > length)
			throw new ArrayIndexOutOfBound(index);
		checKArrayFillRatio();
		if (index > arrayFillSize + 1) {
			baseArray[index] = value;
			return;
		}
		insertAndswapRight(index);
		baseArray[index] = value;
	}

	public void insertAndswapRight(int start) {
		this.arrayFillSize++;
		for (int index = start + 1; index < arrayFillSize; index++) {
			baseArray[index + 1] = baseArray[index];
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(baseArray);
	}

	public void print() {
		Arrays.stream(baseArray).forEach(e -> System.out.println(e));
	}

	public int size() {
		return arrayFillSize;
	}

	public Optional<T> findMax() throws Exception {
		T maxVal = null;
		if (arrayFillSize < 0) {
			return Optional.empty();
		} else {
			maxVal = iterateListForMax();
		}
		return Optional.ofNullable(maxVal);
	}
	
	private T iterateListForMax() {
		T maxVal = baseArray[0];
		for (int index = 1; index < arrayFillSize; index++) {
			if (((Comparable<T>) maxVal).compareTo(baseArray[index]) < 0) {
				maxVal = baseArray[index];
			}
		}
		return maxVal;
	}
	
	public T findMin() throws Exception {
		T minVal = null;
		if (arrayFillSize <= 0) {
			throw new Exception("List is empty");
		} else {
			minVal = iterateArrayListForMin();
		}
		return minVal;
	}
	private T iterateArrayListForMin() {
		T minVal = baseArray[0];
		for (int index = 1; index < arrayFillSize; index++) {
			if (((Comparable<T>) minVal).compareTo(baseArray[index]) > 0) {
				minVal = baseArray[index];
			}
		}
		return minVal;
	}
}
