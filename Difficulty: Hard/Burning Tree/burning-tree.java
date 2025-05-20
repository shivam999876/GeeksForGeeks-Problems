

//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    static int timeTaken;
    public static int minTime(Node root, int target) 
    {
        timeTaken=0;
        solve(root,target);
        return timeTaken;
    }
    
    static Info solve(Node root,int target){
        if(root==null)
        return new Info(false,-1);
        Info left=solve(root.left,target);
        Info right=solve(root.right,target);
        
        int max=1+Math.max(left.height,right.height);
        //timeTaken=Math.max(timeTaken,max);
        if(root.data==target){
            // check and update height with children
            timeTaken=Math.max(timeTaken,max);
            right.fireSet=true;
            right.height=0;
            return right;
        }
        if(left.fireSet){
            timeTaken=Math.max(timeTaken,left.height+right.height+2);
            left.height+=1;
            return left;
        }
        if(right.fireSet){
            timeTaken=Math.max(timeTaken,left.height+right.height+2);
            right.height+=1;
            return right;
        }
        left.height=max;
        return left;
    }
    
    
    static class Info{
        boolean fireSet;
        int height;
        Info(boolean fireSet,int height){
            this.fireSet=fireSet;
            this.height=height;
        }
    }
}