class Solution {
    public int[] solution(String s) {
        
        int[] answer = new int[2];
        int deleteCnt = 0;
        int convertCnt = 0;
        
        while(!s.equals("1")) {
            int oneCnt = 0;
            
            for(char c : s.toCharArray()) {
                if(c == '0'){
                    deleteCnt++;                                        
                } else {
                    oneCnt++;
                }
            }
            s = Integer.toBinaryString(oneCnt);
            convertCnt++;
        }
        answer[0] = convertCnt;
        answer[1] = deleteCnt;
        
        return answer;
    }
}