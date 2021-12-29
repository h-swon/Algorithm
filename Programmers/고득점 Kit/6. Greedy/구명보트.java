import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int end = people.length - 1;
        int start = 0;
        Arrays.sort(people);
        
        for(; end>=start; end--){
            if(people[end]+people[start] <= limit){
                start++;
            }
            answer++;
        }
        return answer;
    }
}