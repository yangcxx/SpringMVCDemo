package test.map;

import java.util.*;

/**
 * Function: 利用 HashMap 查找字符串/数组中出现次数最多的元素
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/15 9:52 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class HashMapTest {

    public static void main(String[] args) {
        String str = "asdgsfhwsfasgfwefcsahrtbycasxas";
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char datum : chars) {
            if (map.containsKey(datum)) {
                Integer value = map.get(datum);
                map.put(datum, ++value);
            } else {
                map.put(datum, 1);
            }
        }
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        Iterator<Map.Entry<Character, Integer>> iterator = list.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            System.out.println(String.valueOf(next.getKey()) + " - " + next.getValue());
        }
    }

}
