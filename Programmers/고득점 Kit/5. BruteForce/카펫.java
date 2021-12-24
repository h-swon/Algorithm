class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int width = 0;
        int height = 0;
        for(int i=3; i*i<=total; i++){
            if(total%i==0){
                if(yellow == (i-2)*(total/i-2)){
                    height = i;
                    break;
                }
            }
        }

        width = total / height;
        int[] answer = {width, height};
        return answer;
    }
}