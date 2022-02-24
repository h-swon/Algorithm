import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        Stack<Integer> stack = new Stack<>();
        for(int move : moves) {
            for(int i=0; i<n; i++) {
                if(board[i][move-1] > 0) {
                    if(!stack.isEmpty() && stack.peek() == board[i][move-1]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.add(board[i][move-1]);
                    }
                    board[i][move-1] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}