import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        
        StringBuilder sb = new StringBuilder();
        int leftPos = 10;
        int rightPos= 12;
        
        for(int number : numbers) {
            switch(number) {
                case 1: case 4: case 7:
                    sb.append("L");
                    leftPos = number;
                    break;
                    
                case 3: case 6: case 9:
                    sb.append("R");
                    rightPos = number;
                    break;
                    
                default :
                    int leftDiff = calLength(number, leftPos);
                    int rightDiff = calLength(number, rightPos);
                
                    if(leftDiff > rightDiff) {
                        sb.append("R");
                        rightPos = number;
                    } else if(leftDiff < rightDiff) {
                        sb.append("L");
                        leftPos = number;
                    } else {
                        if(hand.equals("left")) {
                            sb.append("L");
                            leftPos = number;
                        } else {
                            sb.append("R");
                            rightPos = number;
                        }
                    }
            }
        }
        
        return sb.toString();
    }
    
    public int calLength(int num1, int num2){
        num1 = (num1==0) ? 11 : num1;
        num2 = (num2==0) ? 11 : num2;
        
        int y1 = (num1-1) / 3;
        int x1 = (num1-1) % 3;
        int y2 = (num2-1) / 3;
        int x2 = (num2-1) % 3;
        
        return Math.abs(y2-y1) + Math.abs(x2-x1);
    }
}