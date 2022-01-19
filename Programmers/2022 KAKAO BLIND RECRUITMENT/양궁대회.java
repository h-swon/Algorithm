import java.util.*;

class Solution {
    
    int[] answer = new int[11];
    int maxScore;
    
    public int[] solution(int n, int[] info) {
        
        dfs(0, n, 0, new int[11], 0, info);
        if(maxScore==0){
            return new int[]{-1};
        } else 
            return answer;
    }
    

    public void dfs(int i, int cnt, int rSum, int[] rScore, int aSum, int[] info){
        if(i==10){
            if(rSum - aSum >= maxScore){
                rScore[10] = cnt;
                
                if(rSum-aSum > maxScore){ // 기존 max보다 큰 경우
                    answer = rScore.clone();
                    maxScore = rSum - aSum;
                } else{ // 값이 같은 경우
                    if(canChangeArr(rScore)){
                        answer = rScore.clone();
                    }
                }
            }
            return;
        }
        
        // 이긴 경우
        if(cnt > info[i]){
            rScore[i] = info[i] + 1;
            dfs(i+1, cnt-info[i]-1, rSum + (10 - i), rScore, aSum, info);
        }
        // 진 경우
        rScore[i] = 0;
        dfs(i+1, cnt, rSum, rScore, aSum + (info[i] > 0 ? (10 - i) : 0), info);

    }
    
    public boolean canChangeArr(int[] arr){
        for(int i=10; i>=0; i--){
            if(answer[i] == arr[i]){
                continue;
            } else if(answer[i] < arr[i]){
                return true;
            } else{
                break;
            }
        }
        return false;
    }
}