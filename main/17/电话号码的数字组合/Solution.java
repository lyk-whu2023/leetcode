//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    List<String>res;
    String digits;
    Map<Character,String> phoneMap;
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        this.digits=digits;
        res=new ArrayList<>();
        phoneMap=new HashMap<Character,String>(){
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        dfs(0,"");
        return res;
    }
    public void dfs(int index, String str){
        if (index==digits.length()){
            res.add(str);
            return;
        }
        String letters=phoneMap.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            dfs(index+1,str+letters.charAt(i));
        }
    }
}