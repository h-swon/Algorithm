import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] arr = new int[n];
        int answer = 0;

        for(int num : lost){
            arr[num-1]--;
        }
        for(int num : reserve){
            arr[num-1]++;
        }
        
        for(int i=0; i<n;i++){
            if(arr[i]<0){
               if(i>0 && arr[i-1]>0){
                   arr[i]++;
                   arr[i-1]--;
               } else if(i<n-1 && arr[i+1]>0){
                   arr[i]++;
                   arr[i+1]--;
               } 
            }
        }
        for(int i : arr){
            if(i>=0){
                answer++;
            }
        }
    
        return answer;
    }
}