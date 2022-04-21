class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            String num = Long.toBinaryString(numbers[i]);
            
            if(numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                int lastIdx = num.lastIndexOf("0");
                String n;
                
                if(lastIdx == -1) {
                    n = "10" + num.substring(1);
                } else {
                    int firstIdx = num.indexOf("1", lastIdx);
                    n = num.substring(0,lastIdx) + "1" + num.substring(lastIdx+1, firstIdx) + "0"
                        + num.substring(firstIdx+1);
                }
                answer[i] = Long.parseLong(n, 2);
            }
        }
        return answer;
    }
}