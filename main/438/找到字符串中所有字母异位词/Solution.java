import java.util.ArrayList;
import java.util.List;

//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        int left=0;
        int right=0;
        int[] needs=new int[26];
        int require=0;
        for(char c:p.toCharArray()){
            needs[c-'a']++;
        }
        for (int i:needs){
            if (i!=0){
                require++;
            }
        }
        while (right<s.length()){
            char rightChar=s.charAt(right);
            needs[rightChar-'a']--;
            if (needs[rightChar-'a']==0){
                require--;
            }
            if (require==0&&right-left+1==p.length()){
                ans.add(left);
            }
            if (right-left+1>=p.length()){
                char leftChar=s.charAt(left);
                needs[leftChar-'a']++;
                if (needs[leftChar-'a']==1){
                    require++;
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}