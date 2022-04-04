import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        StringBuilder sb = new StringBuilder();
        Node[] nodeArr = new Node[n];
        Stack<Node> stack = new Stack<>();
        
        for(int i=0; i<n; i++)
            nodeArr[i] = new Node();
        
        for(int i=1; i<n; i++) {
            nodeArr[i-1].next = nodeArr[i];
            nodeArr[i].prev = nodeArr[i-1];
        }
        Node cur = nodeArr[k];
        
        for(String command : cmd) {
            switch(command.charAt(0)) {
                case 'D': {
                    int move = Integer.parseInt(command.substring(2));
                    for(int i=0; i<move; i++)
                        cur = cur.next;
                    break;
                }
                case 'U': {
                    int move = Integer.parseInt(command.substring(2));
                    for(int i=0; i<move; i++)
                        cur = cur.prev;
                    break;
                }
                case 'C': {
                    cur.delete = true;
                    stack.push(cur);
                    Node up = cur.prev;
                    Node down = cur.next;
                    if(up != null) {
                        up.next = down;
                    }
                    if(down != null) {
                        down.prev = up;
                        cur = down;
                    } else {
                        cur = up;
                    }
                    break;
                }
                case 'Z': {
                    Node node = stack.pop();
                    node.delete = false;
                    Node up = node.prev;
                    Node down = node.next;
                    if(up != null) {
                        up.next = node;
                    }
                    if(down != null) {
                        down.prev = node;
                    } 
                    break;
                }
            }
        }
        
        for(Node node : nodeArr) {
            if(node.delete) {
                sb.append("X");
            } else {
                sb.append("O");
            }
        }
        return sb.toString();
    }
    
    class Node {
        Node prev;
        Node next;
        boolean delete;
    }
}