/*
 *  Copyright 2021-2021 zenghao
 */
package segment.six;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @auhtor: zenghao
 * @date: 2021/11/5
 **/
public class SegmentSix {
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		List<String> sortWords = map.keySet().stream().sorted((o1, o2) -> {
			int x = map.get(o2) - map.get(o1);
			String sum1 = o1 + o2;
			String sum2 = o2 + o1;
			if (x == 0) {
				if (sum1.equals(sum2)) {
					return o1.length() > o2.length() ? 1 : -1;
				} else {
					return (o1 + o2).compareTo(o2 + o1);
				}
			} else {
				return x;
			}
		}).collect(Collectors.toList());
		return sortWords.subList(0, k);
	}

	@Test
	public void test692() {
		List<String> res = topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
		System.out.println(100);
	}
	public static void main(String[] args) {
		SegmentSix in = new SegmentSix();
	}
}
