//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int counts[] = new int[26];
            for (int i = 0; i <str.length(); i++) {
                counts[str.charAt(i)-'a']++;
            }
            StringBuffer sb=new StringBuffer();
            for (int i = 0; i < 26; i++) {
                sb.append((char) i+'a');
                sb.append(counts[i]);
            }
            String key=sb.toString();
            List list=map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}