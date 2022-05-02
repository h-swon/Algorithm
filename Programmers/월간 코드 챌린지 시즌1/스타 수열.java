class Solution {
    public int solution(int[] a) {
        int[] num = new int[a.length];
        for(int value : a) {
            num[value]++;
        }
        
        int answer = 0;
        for(int i=0; i<num.length; i++) {
            if(num[i] <= answer) continue;
            
            int cnt = 0;
            for(int j=0; j<num.length-1; j++) {
                if(a[j] != i && a[j+1] != i) continue;
                if(a[j] == a[j+1]) continue;
                cnt++;
                j++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer * 2;
    }
}