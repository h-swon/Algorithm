import java.util.*;

class Solution {
    
    int idx;
    
    public int[][] solution(int[][] nodeinfo) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int i=0; i<nodeinfo.length; i++){
            pq.offer(new Node(nodeinfo[i][0], nodeinfo[i][1], i+1));
        }
        
        Node root = pq.poll();
        while(!pq.isEmpty()){
            insertNode(root, pq.poll());
        }
        
        int[][] answer = new int[2][nodeinfo.length];
        preOrder(root, answer[0]);
        idx=0;
        postOrder(root, answer[1]);
        return answer;
    }
    
    public void preOrder(Node root, int[] arr){
        if(root != null){
            arr[idx++] = root.num;
            preOrder(root.left, arr);
            preOrder(root.right, arr);
        }
    }
    
    public void postOrder(Node root, int[] arr){
        if(root!=null){
            postOrder(root.left, arr);     
            postOrder(root.right, arr); 
            arr[idx++] = root.num; 
        }
    }
    
    public void insertNode(Node parent, Node child){
        if(parent.x < child.x) {
            if(parent.right == null){
                parent.right = child;
            } else{
                insertNode(parent.right, child);
            }
        } else {
            if(parent.left == null){
                parent.left = child;
            } else{
                insertNode(parent.left, child);
            }
        }
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int num;
    Node left;
    Node right;
    
    public Node(int x, int y, int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }
    
    @Override
    public int compareTo(Node o){
        int diff = o.y - this.y;
        return diff==0 ? this.x - o.x : diff;
    }
}