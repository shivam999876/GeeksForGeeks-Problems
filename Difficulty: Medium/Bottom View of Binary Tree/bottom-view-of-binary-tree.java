



//User function Template for Java


class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();
        
        
        q.add(new Pair(0, root));
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            map.put(curr.horizontal_dist, curr.node.data);
            
            if (curr.node.left != null){
                q.add(new Pair(curr.horizontal_dist -1, curr.node.left));
            }
            if (curr.node.right != null){
                q.add(new Pair(curr.horizontal_dist +1, curr.node.right));
            }
            
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (Map.Entry<Integer,Integer> mp : map.entrySet()){
            ans.add(mp.getValue());
        }
        
        return ans;
    }
    
    static class Pair {
        int horizontal_dist;
        Node node;
        
        public Pair(int horizontal_dist, Node node) {
            this.horizontal_dist = horizontal_dist;
            this.node = node;
        }
    }
}