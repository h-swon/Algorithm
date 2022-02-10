import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] people = new int[N+1];        
        int[] answer = new int[N];
        Stage[] fail = new Stage[N];

        for(int stage : stages){
            people[stage-1]++;    
        }

        for(int i=people.length-1; i>0; i--){
            people[i-1] += people[i];
        }

        for(int i=0; i<people.length-1; i++){
            int total = people[i];
            int num = people[i] - people[i+1];
            fail[i] = new Stage(i+1, (double)(total - num) / total);
        }
        Arrays.sort(fail);
        for(int i=0; i<answer.length; i++){
            answer[i] = fail[i].stage;
        }

        return answer;
    }
}

class Stage implements Comparable<Stage> {
    int stage;
    double percent;

    public Stage(int stage, double percent) {
        this.stage = stage;
        this.percent = percent;
    }

    @Override
    public int compareTo(Stage o){
        int diff = Double.compare(this.percent, o.percent);
        return diff==0 ? this.stage-o.stage : diff;
    }
}