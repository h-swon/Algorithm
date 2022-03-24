class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cur = 1;
        int stationIdx = 0;
        
        while(cur <= n) {
            if(stationIdx < stations.length && cur >= stations[stationIdx]-w) {
                cur = stations[stationIdx++] + w + 1;
            } else {
                cur += (2 * w + 1);
                answer++;
            }
        }
        
        return answer;
    }
}