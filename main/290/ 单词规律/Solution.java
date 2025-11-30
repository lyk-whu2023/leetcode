//给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
//这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。具体来说：
//pattern 中的每个字母都 恰好 映射到 s 中的一个唯一单词。
//s 中的每个唯一单词都 恰好 映射到 pattern 中的一个字母。
//没有两个字母映射到同一个单词，也没有两个单词映射到同一个字母。

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!Objects.equals(map.put(pattern.charAt(i), i), map.put(words[i], i))) {
                return false;
            }
        }
        return true;
    }
    public boolean wordPattern2(String pattern, String str){
        // 将字符串s按空格分割成单词数组
        String[] words = str.split(" ");

        // 如果模式长度和单词数量不匹配，返回false
        if (pattern.length() != words.length) {
            return false;
        }

        // 创建两个哈希映射，用于双向映射检查
        Map<Character, String> charToWord = new HashMap<>();  // 字符到单词的映射
        Map<String, Character> wordToChar = new HashMap<>();  // 单词到字符的映射

        // 遍历模式和单词数组
        for (int i = 0; i < pattern.length(); i++) {
            char currentChar = pattern.charAt(i);
            String currentWord = words[i];

            // 检查字符到单词的映射是否一致
            if (charToWord.containsKey(currentChar) &&
                    !charToWord.get(currentChar).equals(currentWord)) {
                return false;
            }

            // 检查单词到字符的映射是否一致
            if (wordToChar.containsKey(currentWord) &&
                    wordToChar.get(currentWord) != currentChar) {
                return false;
            }

            // 如果当前字符不在映射中，添加映射关系
            if (!charToWord.containsKey(currentChar)) {
                charToWord.put(currentChar, currentWord);
            }

            // 如果当前单词不在映射中，添加映射关系
            if (!wordToChar.containsKey(currentWord)) {
                wordToChar.put(currentWord, currentChar);
            }
        }

        return true;
    }


}