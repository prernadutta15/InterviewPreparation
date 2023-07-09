package com.practice.StacksAndQueues;

import java.util.Stack;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/simplify-path/description/
 */

/**
 * Input: path = "/a/./b/../../c/" Output: "/c"
 * 
 * Let's understand what this mean's, so basically this seems like you a path of
 * your folder, so generically we use this kind of command's in terminal. I hope
 * u know a bit about that. Anyway's let's move further on.
 * 
 * okay, so the first command /a/ means get into the folder /a/
 * 
 * The next command is /./ means stay over there
 * 
 * The next command is /b/ means get into the folder /b/
 * 
 * The next command is /../ means come out from the folder /b/
 * 
 * The next command is /../ means come out from the folder /a/
 * 
 * Now we are kind of in home directory
 * 
 * The next command is /c/ means get into the folder /c/
 * 
 * And in the output we return what command we left with.
 */

public class SimplifyPath {
	public String simplifyPath(String path) {
		Stack<String> s = new Stack<>();
		StringBuilder res = new StringBuilder();
		String[] p = path.split("/");

		for (int i = 0; i < p.length; i++) {
			if (!s.isEmpty() && p[i].equals(".."))
				s.pop();
			else if (!p[i].equals("") && !p[i].equals(".") && !p[i].equals(".."))
				s.push(p[i]);
		}

		if (s.isEmpty())
			return "/";
		while (!s.isEmpty()) {
			res.insert(0, s.pop()).insert(0, "/");
		}

		return res.toString();
	}
	public static void main(String[] args) {
		String str = "..///a/./b/../../.../c/";
		String str1 = "..///a/./b/../../c/";
		SimplifyPath ob = new SimplifyPath();
		System.out.println(ob.simplifyPath(str));
		System.out.println(ob.simplifyPath(str1));
	}
}
