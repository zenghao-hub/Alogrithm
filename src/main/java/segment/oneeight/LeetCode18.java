/*
 *  Copyright 2021-2021 zenghao
 */
package segment.oneeight;

import org.junit.Test;

import java.util.Arrays;

/**
 * @auhtor: zenghao
 * @date: 2021/11/7
 **/
public class LeetCode18 {
	public int maxIceCream(int[] costs, int coins) {
		Arrays.sort(costs);
		int res = 0;
		int money = coins;
		for (int cost : costs) {
			if (cost <= money) {
				res++;
				money = money - cost;
			} else {
				return res;
			}
		}
		return res;
	}

	@Test
	public void test1833() {
		System.out.println(maxIceCream(new int[] {1,3,2,4,1}, 7));
	}

	public int longestBeautifulSubstring(String word) {
		int length = word.length();
		int res = 0;
		int begin = word.indexOf('a');
		if (begin < 0) {
			return 0;
		}
		char lastChar = 'a';
		begin++;
		int tmpLength = 1;
		while (begin < length) {
			if (word.charAt(begin) == 'a') {
				if (lastChar == 'a') {
					tmpLength++;
				} else {
					tmpLength = 1;
				}
				begin++;
				lastChar = 'a';
				continue;
			}
			if (word.charAt(begin) == 'e' && (lastChar == 'a' || lastChar == 'e')) {
				tmpLength++;
				begin++;
				lastChar = 'e';
				continue;
			}
			if (word.charAt(begin) == 'i' && (lastChar == 'e' || lastChar == 'i')) {
				tmpLength++;
				begin++;
				lastChar = 'i';
				continue;
			}
			if (word.charAt(begin) == 'o' && (lastChar == 'i' || lastChar == 'o')) {
				tmpLength++;
				begin++;
				lastChar = 'o';
				continue;
			}
			if (word.charAt(begin) == 'u' && (lastChar == 'o' || lastChar == 'u')) {
				tmpLength++;
				res = Math.max(res, tmpLength);
				begin++;
				lastChar = 'u';
				continue;
			}
			lastChar = 'A';
			begin++;
		}
		return res;
	}

	@Test
	public void test1839() {
		System.out.println(longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
	}
}
