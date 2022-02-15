import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        List<Food> foods = new LinkedList<>();
        int n = food_times.length;
        
        for(int i=0; i<n; i++){
            foods.add(new Food(i+1, food_times[i]));
        } 
        
        Collections.sort(foods);
        
        int preTime = 0;
        int i=0;
        
        for(Food f : foods) {
            long diff = f.time - preTime;
            if(diff != 0){
                long cost = diff * n;
                if(cost <= k) {
                    k -= cost;
                    preTime = f.time;
                } else {
                    k %= n;
                    foods.subList(i, food_times.length).sort((Food a, Food b) -> a.idx - b.idx );
                    return foods.get(i+(int)k).idx; 
                }
            }
            i++;
            n--;
        }
       
        return -1;
    }
    
}
class Food implements Comparable<Food> {
    int idx;
    int time;
    
    public Food(int idx, int time){
        this.idx = idx;
        this.time = time;
    }
    @Override
    public int compareTo(Food f){
        return this.time - f.time;
    }
}