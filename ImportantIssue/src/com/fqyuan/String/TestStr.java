package com.fqyuan.String;

public class TestStr {
	public static void main(String[] args) {
		String str1 = "someThing";
		String str2 = "someThing";
		String str3 = new String("someThing");
		String str4 = new String("someThing");
		/*
		 * ����֮��equal�������û�б���д����ô��Ч�ú�'=='��ͬ�� �����д��equals()��������ô�ǵ���дhashCode������
		 * ��������Ϊ��==�Ƚϵ������õ�λ�ã���equal()�Ƚϵ������õ����ݡ�
		 * ����equal()�������Ϊtrue������hashCode()��Ȼ��ͬ������֮������һ��������
		 */
		if (str1 == str2)
			System.out.println("str1 == str2");
		else
			System.out.println("str1 != str2");
		if (str1 == str3)
			System.out.println("str1 == str3");
		else
			System.out.println("str1 != str3");
		if (str3 == str4)
			System.out.println("str3 == str4");
		else
			System.out.println("str3 !=str4");

		if (str1 == str3.intern())
			System.out.println("str1 == str3.intern()");
		else
			System.out.println("str1 != str3.intern()");

		if (str4.intern() == str3.intern())
			System.out.println("str4() == str3.intern()");
		else
			System.out.println("str4.intern() != str3.intern()");

		System.out.println("str1.equals(str3): " + str1.equals(str3));

	}
}