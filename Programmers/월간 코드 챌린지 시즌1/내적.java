class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        int n = a.length;
        
        for(int i=0; i<n; i++) {
            answer += a[i]*b[i];
        }
        return answer;
    }
}