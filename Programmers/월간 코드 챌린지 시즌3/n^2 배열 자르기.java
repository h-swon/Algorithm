class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1);
        int[] answer = new int[size];
        int idx = 0;

        for(long i=left; i<=right; i++) {
            int r = (int)(i/n);
            int c = (int)(i%n);
            int num = Math.max(r, c) + 1;
            answer[idx++] = num;
        }

        return answer;
    }
}