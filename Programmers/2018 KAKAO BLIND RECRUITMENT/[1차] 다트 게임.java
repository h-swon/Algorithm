class Solution {
    public int solution(String dartResult) {
        
        int answer = 0;
        int[] game = new int[3];
        int idx = 0;
        String num = "";
        int len = dartResult.length();
        
        for(int i=0; i<len; i++) {
            switch(dartResult.charAt(i)) {
                case '*':
                    if(idx > 1) {
                        game[idx-2] *= 2;
                    }
                    game[idx-1] *= 2;
                    break;
                
                case '#':
                    game[idx-1] *= -1;
                    break;
                
                case 'S':
                    game[idx++] = Integer.parseInt(num);
                    num = "";
                    break;
                
                case 'D':
                    game[idx++] = (int)Math.pow(Integer.parseInt(num), 2);                    
                    num = "";                    
                    break;
                    
                case 'T':
                    game[idx++] = (int)Math.pow(Integer.parseInt(num), 3);                    
                    num = "";
                    break;
                
                default:
                    num += dartResult.charAt(i);
                    break;
            }
        }
        
        answer = game[0] + game[1] + game[2];
        return answer;
    }
}