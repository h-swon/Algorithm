class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++) {
            String s = Integer.toBinaryString(arr1[i] | arr2[i]);
            s = String.format("%"+n+"s" , s);
            s = s.replaceAll("0", " ");
            s = s.replaceAll("1", "#");
            answer[i] = s;
        }
        return answer;
    }
}