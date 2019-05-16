/**
 * Name: Matt Whitehead
 * Title: Binary Search Trees
 * Due Date: 11/29/18
 * Description: Tree node class to be used to add and print words in the
 * binary search tree.
 */

public class TreeNode {
	private String word;
	private TreeNode left;
	private TreeNode right;
	private int count;

	public TreeNode() {
        this.word = null;
        this.left = null;
        this.right = null;
        this.count = 0;}
	//Could be int number
	public TreeNode(String word) {
        this.word = word;
        this.left = null;
        this.right = null;
        this.count = 1;}
	
	public int getCount() {
		return count;}

	public void setCount(int count) {
		this.count = count;}

	public TreeNode(String word, TreeNode
			left, TreeNode right) {
        this.word = word;
        this.left = left;
        this.right = right;}
	//Or getNumber
	public String getWord() {
		return word;}
	//Or setNumber(int number)
	public void setWord(String word) {
		this.word = word;}

	public TreeNode getLeft() {
		return left;}

	public void setLeft(TreeNode left) {
		this.left = left;}

	public TreeNode getRight() {
		return right;}

	public void setRight(TreeNode right) {
		this.right = right;}
	
}
