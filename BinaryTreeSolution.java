import java.util.*;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){}
	TreeNode(int val){
		this.val=val;
	}
	TreeNode(int val, TreeNode left, TreeNode  right){
		this.val=val;
		this.left=left;
		this.right=right;
	}
}
public class BinaryTreeSolution {
	Map<Integer,Integer> mapInOrder=new HashMap<>();
	int lastElement;
	public static void main(String[] args) {
		BinaryTreeSolution obj=new BinaryTreeSolution();
		int[] inorder=new int[] {9,3,15,20,7};
		int[] postorder=new int[] {9,15,7,20,3};
		obj.constructBtree(inorder, postorder);

	}

	public void constructBtree(int[] inorder, int[] postorder){
		for(int i=0;i<inorder.length;i++){
			mapInOrder.put(inorder[i],i);
		}
		lastElement=postorder.length-1;
		TreeNode root=buildBtree(0,postorder.length-1, inorder,postorder);
		postOrder(root);
	}
	public TreeNode buildBtree(int left, int right,int[] inorder, int[] postorder){
		if(left>right)
			return null;
		TreeNode root=new TreeNode(postorder[lastElement--]);
		int rootIndex=mapInOrder.get(root.val);//Root index position from inorder traversal
		root.right=buildBtree(rootIndex+1,right,inorder,postorder);
		root.left=buildBtree(left,rootIndex-1,inorder,postorder);
		
		return root;
		
	}
	public void postOrder(TreeNode root){
		if(root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.val);
	}

}
