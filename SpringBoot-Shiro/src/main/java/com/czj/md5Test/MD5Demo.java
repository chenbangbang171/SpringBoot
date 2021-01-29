package com.czj.md5Test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Demo {

	public static void main(String[] args) {
		// 原始 密码
		String password = "123";
		// 盐
		String salt = "abcde";
		// 散列次数
		int hashIterations = 2;
		// 上边散列1次：7bc6c31880aeda581aa34e218af25753
		// 上边散列2次：6585096f3f6735025449cfb351c8cff9

		// 第一种方式
		// 构造方法中：
		// 第一个参数：明文，原始密码
		// 第二个参数：盐，通过使用随机数
		// 第三个参数：散列的次数，比如散列两次，相当 于md5(md5(''))
		Md5Hash md5Hash = new Md5Hash(password, salt, hashIterations);

		String password_md5 = md5Hash.toString();
		System.out.println(password_md5);

		// 第二种方式
		// 第一个参数：散列算法
		SimpleHash simpleHash = new SimpleHash("md5", password, salt,
				hashIterations);
		System.out.println(simpleHash.toString());

	}
}