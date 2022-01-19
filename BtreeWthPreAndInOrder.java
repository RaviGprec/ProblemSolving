/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BtreeWthPreAndInOrder {
    Map<Integer, Integer> mapInOrder=new HashMap<>();
    public int firstElement;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        firstElement=0;
        for(int i=0;i<inorder.length;i++){
            mapInOrder.put(inorder[i],i);
        }
        return build(0,inorder.length-1,preorder,inorder);
    }
    public TreeNode build(int left, int right, int[] preorder, int[] inorder){
        if(left>right)
            return null;
        TreeNode root=new TreeNode(preorder[firstElement++]);
        int rootIndex=mapInOrder.get(root.val);
        root.left=build(left,rootIndex-1,preorder,inorder);
        root.right=build(rootIndex+1,right,preorder,inorder);
        return root;
    }
}
