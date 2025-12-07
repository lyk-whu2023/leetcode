//给定数组 people 。people[i]表示第 i 个人的体重 ，船的数量不限，每艘船可以承载的最大重量为 limit。
//每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
//返回 承载所有人所需的最小船数 。

import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int answer=0;
        Arrays.sort(people);
        int light=0;
        int heavy=people.length-1;
        while (light<=heavy){
            if (people[light]+people[heavy]<=limit){
                light++;
            }
            heavy--;
            answer++;
        }
        return answer;
    }
}