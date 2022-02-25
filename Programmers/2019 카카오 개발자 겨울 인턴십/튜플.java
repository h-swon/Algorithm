import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        HashSet<Integer> hs = new HashSet<>();
        s = s.substring(2, s.length()-2).replaceAll("\\},\\{","-");
        String[] arr = s.split("-");
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        int[] answer = new int[arr.length];
        
        for(int i=0; i<arr.length; i++) {
            String[] tmp = arr[i].split(",");
            for(String t : tmp) {
                int num = Integer.parseInt(t);
                if(!hs.contains(num)) {
                    hs.add(num);
                    answer[i] = num;
                    break;
                }
            }
        }
        
        return answer;
    }
}