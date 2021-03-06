package com.fqyuan.hashcode;

import java.util.HashSet;

public class TestEquals {
	public static void main(String[] args) {
		Person Person = new Person("rajeev", 24);
		Person Person1 = new Person("rajeev", 25);
		Person Person2 = new Person("rajeev", 24);

		HashSet<Person> Persons = new HashSet<Person>();
		Persons.add(Person);
		Persons.add(Person1);
		Persons.add(Person2);

		// If hashCode() not implemented, the following result will be false.
		System.out.println(Persons.contains(Person2));
		System.out.println(Persons.size());
		System.out.println("Person.hashCode():" + Person.hashCode() + "\nPerson1.hashCode():" + Person1.hashCode()
				+ "\nPerson2.hashCode():" + Person2.hashCode());
	}
}
