import java.util.*;

class Solution {
    
    static HashSet<Integer> hs = new HashSet<>();
    static int[] arr;
    
    public int solution(String numbers) {
        
        int size =  (int)Math.pow(10, numbers.length());
        arr = new int[size];

        initArray(arr, size);
        makeNumber("", numbers);
        
        int answer = 0;
        Iterator<Integer> it = hs.iterator();
        while(it.hasNext()){
            if(isPrime(it.next())){
                answer++;
            }
        }
        
        return answer;
    }
    
    public void initArray(int[] arr, int size){
        Arrays.fill(arr, -1);
        arr[0]=0;
        arr[1]=0;
        for(int i=2; i< size; i++){
            for(int j=i*2; j< size; j+=i){
                arr[j] = 0;
            }
        }
    }
    public boolean isPrime(int num){
        return arr[num]==0 ? false : true;
    }
    public void makeNumber(String result, String number){
        if(!result.equals("")){
            hs.add(Integer.parseInt(result));
        }
        for(int i=0; i< number.length();i++){
            makeNumber(result+number.charAt(i),
                       number.substring(0,i) + number.substring(i+1));
        }
    }
}