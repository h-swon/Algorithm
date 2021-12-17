import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> queue = new LinkedList<>();
        
        int answer = 0;
        int truckWeightCrossingBridge = 0;

        for(int truckWeight: truck_weights){
            while(true){ 
                if(bridge_length == queue.size()){
                    truckWeightCrossingBridge -= queue.poll();
                } else if(weight<truckWeightCrossingBridge + truckWeight){
                    answer++; 
                    queue.offer(0);
                } else{
                    queue.offer(truckWeight);
                    truckWeightCrossingBridge += truckWeight;
                    answer++; 
                    break;
                }
            }
        }
        return answer + bridge_length;
        
    }
}