package com.fqyuan.staticClass;

public class TestStatic {

	public static void main(String[] args) {

	}

}

class Singleton {
	/*
	 * Nested classes: inner class & static class. static classes: use the
	 * static nested class without creating an instance of the outer class.
	 */
	private Singleton() {

	}

	/*
	 * The class LazyHolder must be static. static fields and static methods are
	 * prohibited in java, only way it works is to declare a static inner class,
	 * or you can make your field in the nested class non-static.
	 */
	private static class LazyHolder {
		private static Singleton INSTANCE = new Singleton();
	}

	public static Singleton getInstance() {
		return LazyHolder.INSTANCE;
	}
}