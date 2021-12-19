import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int len = numbers.length;
        String[] arr = new String[len];
        for(int i=0; i<len; i++){
            arr[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(String num : arr){
            sb.append(num);
        }
        if(sb.toString().startsWith("0"))
            return "0";
        else
            return sb.toString();
    }
}