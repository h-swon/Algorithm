class Solution {
    public int solution(int[] a) {
        
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        
        for(int i=0; i<a.length; i++) {
            if(min > a[i]) {
                min = a[i];
                minIdx = i;
            }
        }

        int answer = 0;
        min = Integer.MAX_VALUE;
        
        for(int i=0; i<minIdx; i++) {
            if(min > a[i]) {
                min = a[i];
                answer++;
            }
        }
        
        min = Integer.MAX_VALUE;
        for(int i=a.length-1; i>minIdx; i--) {
            if(min > a[i]) {
                min = a[i];
                answer++;
            }
        }
        
        return answer+1;
    }
}