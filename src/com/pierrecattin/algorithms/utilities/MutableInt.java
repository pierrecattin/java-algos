package com.pierrecattin.algorithms.utilities;

public class MutableInt {
	private int value;

	MutableInt(int value) {
		// initialize with the specified value
		this.value = value;
	}

	public void increment() {
		// increment value by 1
		value++;
	}

	public int getAndIncrement() {
		// increment value by 1 and return previous value
		return value++;
	}

	public int incrementAndGet() {
		// increment value by 1 and return
		return ++value;
	}

	public void decrement() {
		// decrement value by 1
		value--;
	}

	public int getAndDecrement() {
		// decrement value by 1 and return previous value
		return value--;
	}

	public int decrementAndGet() {
		// decrement value by 1 and return
		return --value;
	}

	public void add(int operand) {
		// add operand value to value of this instance
		value += operand;
	}

	public void remove(int operand) {
		// remove operand value from the value of this instance
		value -= operand;
	}

	public int getValue() {
		// return value of this instance as int
		return value;
	}

	public void setValue(int value) {
		// set value of this instance to specified int value
		this.value = value;
	}

	@Override
	public String toString() {
		// returns corresponding String value of this mutable
		return String.valueOf(getValue());
	}
}
