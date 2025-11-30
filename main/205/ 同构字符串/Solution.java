//给定两个字符串 s 和 t ，判断它们是否是同构的。
//如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
//每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
// 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS=s.charAt(i);
            char charT=t.charAt(i);
            if (map1.containsKey(charS) && map1.get(charS) != charT) {
                return false;
            }
            if (map2.containsKey(charT) && map2.get(charT) != charS) {
                return false;
            }
            if (!map1.containsKey(charS)) {
                map1.put(charS, charT);
            }
            if (!map2.containsKey(charT)) {
                map2.put(charT, charS);
            }
        }
        return true;
    }
}