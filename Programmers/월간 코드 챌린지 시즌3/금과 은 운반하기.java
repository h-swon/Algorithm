class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        
        long start = 0;
        long end = (long)(10e9 * 10e5 * 4);
        
        while(start <= end) {
            long gold = 0;
            long silver = 0;
            long total = 0;
            long mid = (start + end) / 2;
            int len = g.length;
       
            for(int i=0; i<len; i++) {
                long tmp = (mid/(t[i]*2)) * w[i] + (mid % (t[i]*2) >=t[i] ? w[i] : 0);
                gold += (tmp>g[i] ? g[i] : tmp);
                silver += (tmp>s[i] ? s[i] : tmp);
                total += (tmp>s[i]+g[i] ? s[i]+g[i] : tmp);
            }
            if(gold >= a && silver >=b && total >= a+b) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
}