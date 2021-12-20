import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] score = new int[3];
        for(int i=0; i< answers.length; i++){
            if(answers[i] == person1[i%5]) score[0]++;
            if(answers[i] == person2[i%8]) score[1]++;
            if(answers[i] == person3[i%10]) score[2]++;
        }
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++){
            if(max == score[i]){
                list.add(i+1);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0;i< list.size();i++)
            answer[i] = list.get(i);
        return answer;
    }
}