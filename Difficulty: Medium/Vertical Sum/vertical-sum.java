/* Structure of binary tree node
class Node{
public:
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        // code here
        Map<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        helper(root, 0, map);
        
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            ans.add(e.getValue());
        }
        
        return ans;
    }
    
    void helper(Node node, Integer x, Map<Integer, Integer> map) {
        if(node == null) return;
        
        map.put(x, map.getOrDefault(x, 0) + node.data);
        helper(node.left, x-1, map);
        helper(node.right, x+1, map);
    }
}