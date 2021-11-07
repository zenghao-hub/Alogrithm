/*
 *  Copyright 2021-2021 zenghao
 */
package segment.zero;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @auhtor: zenghao
 * @date: 2021/11/7
 **/
public class LeetCode0 {

	public int lengthOfLongestSubstring(String s) {
		int length = s.length();
		if (length < 2) {
			return length;
		}
		Map<Integer, Integer> map = new HashMap<>();
		int left = 0;
		int res = 1;
		for (int i = 0; i < length; i++) {
			int index = s.charAt(i);
			if (map.containsKey(index)) {
				left = Math.max(map.get(index) + 1, left);
			}
			map.put(index, i);
			res = Math.max(res, i - left + 1);
		}
		return res;
	}

	@Test
	public void test3() {
		System.out.println(lengthOfLongestSubstring("abba"));
		System.out.println((int) 'a');
	}

	public boolean isPalindrome(String str) {
		int length = str.length();
		for (int i = 0; i < length / 2; i++) {
			if (str.charAt(i) != str.charAt(length - i - 1)) {
				return false;
			}
		}
		return true;
	}
	public String longestPalindrome(String s) {
		String res = "";
		int length = s.length();
		for (int i = 0; i < length - res.length() ; i++) {
			int right = length - 1;
			for (int j = right; j >= i; j--) {
				String str = s.substring(i, j + 1);
				if (isPalindrome(str) && res.length() < str.length()) {
					res = str;
				}
			}
		}
		return res;
	}
	@Test
	public void test5() {
		System.out.println(longestPalindrome("babad"));
		System.out.println((int) 'a');
	}
}
