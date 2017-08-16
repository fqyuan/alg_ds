package com.fqyuan.Wrapper;

import java.util.concurrent.atomic.AtomicInteger;

public class TestWrapper {

	public static void main(String[] args) {
		Foo f1 = new Foo();
		Foo f2 = new Foo();
		Foo f3 = new Foo();
		AtomicInteger i = new AtomicInteger(1);

		f1.setValue(i);
		i.incrementAndGet();
		f2.setValue(i);
		i.incrementAndGet();
		f3.setValue(i);

		Integer j = new Integer(1);
		f1.setItem(j);
		++j;
		f2.setItem(j);
		++j;
		f3.setItem(j);
		System.out.println(f1.getValue() + " " + f2.getValue() + " " + f3.getValue());
		System.out.println(f1.getItem() + " " + f2.getItem() + " " + f3.getItem());
	}
}

class Foo {
	/*
	 * The primitive type are mutable, but they are not sharable- That's why no
	 * 2 sections of code will ever be referring to the same int variable (they
	 * are always pass by value). So you can change your copy and no one else
	 * sees the change, and vice versa.
	 */

	private AtomicInteger value;
	private Integer item;

	/*
	 * If strings and wrapper classes are non-final, anybody can extend those
	 * classes and write their own code to modify the wrapped primitive data.
	 * So, in order to maintain data integrity, the variables which we are using
	 * for data storage must be read-only. i.e., Strings and Wrapper classes
	 * must be final & immutable and 'pass-by-reference' feature should not be
	 * provided.
	 */
	public void setValue(AtomicInteger value) {
		this.value = value;
	}

	public AtomicInteger getValue() {
		return value;
	}

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}
}
