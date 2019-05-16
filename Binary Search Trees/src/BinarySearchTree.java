/**
 * Name: Matt Whitehead
 * Title: Binary Search Trees
 * Due Date: 11/29/18
 * Description: Methods to add words to the binary search tree, print the tree,
 * delete words, and reset the tree.
 */

public class BinarySearchTree {
	TreeNode root;
	
	BinarySearchTree() {
		root = null;}
			// Add words to binary search tree recursively
	private TreeNode add(TreeNode root, String word) {
		if (root == null) {
			return new TreeNode(word.toLowerCase());}
		//if (key < root.key)
		if (word.toLowerCase().compareTo(root.getWord().toLowerCase()) < 0) {
			root.setLeft(add(root.getLeft(), word));}
		//if (key > root.key)
		else if (word.toLowerCase().compareTo(root.getWord().toLowerCase()) > 0) {
			root.setRight(add(root.getRight(), word));}
		//Cut if not need to count
		else {
			root.setCount(root.getCount() + 1);
        		return root;}
		return root;}
    
    public void add(String word) {
        root = add(root, word);}
    			// Print binary search tree inOrder
    private void printInorder(TreeNode node) { 
        if (node == null) {
        		return; }
        printInorder(node.getLeft()); 
        System.out.print(node.getWord() + " ");
        printInorder(node.getRight()); }
    public void printInorder() {
    		printInorder(root);}
    			// Print binary search tree preOrder
    private void printPreOrder(TreeNode node) { 
        if (node == null) {
        		return;}
        	System.out.print(node.getWord() + " ");
        	printPreOrder(node.getLeft());
        printPreOrder(node.getRight()); }
    public void printPreOrder() {
    		printPreOrder(root);}
    			// Print binary search tree postOrder
    private void printPostOrder(TreeNode node) { 
        if (node == null) {
        		return;}
        printPostOrder(node.getLeft());
        printPostOrder(node.getRight());
        System.out.print(node.getWord() + " "); }
    public void printPostOrder() {
    		printPostOrder(root);}
    			// Finds words that exceed the max. Show the words and occurrences then deletes them
	private void showCommonAndDelete(TreeNode node) {
		if(node != null) {
			showCommonAndDelete(node.getLeft());
	    		if(node.getCount() > Driver.getMax()) {
	    			System.out.println("\"" + node.getWord() + "\"" + " has " + node.getCount()
	    				+ " occurrences. \"" + node.getWord() + "\" has been deleted.");
	    			deleteWord(node.getWord());
	    		}
	    		showCommonAndDelete(node.getRight());  
	    }
	}
	
	public void showCommons() {
		showCommonAndDelete(root);
	}
	
			// Deletes entire tree
	public void deleteTree() {
		 root = null;
		 System.out.println("Tree deleted");
	}
	
	
	public void deleteWord(String word) {
		root = deleteWord(root, word);
	} 
  
			// Finds and deletes word and resets the tree
    private TreeNode deleteWord(TreeNode root, String word) {
    		if (root == null) {
    			return root;
        }
  
        if (word.toLowerCase().compareTo(root.getWord().toLowerCase()) < 0) {
            root.setLeft(deleteWord(root.getLeft(), word));
        }
        
        else if (word.toLowerCase().compareTo(root.getWord().toLowerCase()) > 0) {
            root.setRight(deleteWord(root.getRight(), word));
        }
  
        else {
            if (root.getLeft() == null) {
            		return root.getRight();
            }
            
            else if (root.getRight() == null) 
                return root.getLeft(); 
  
            root.setWord(lastWord(root.getRight())); 
            root.setRight(deleteWord(root.getRight(), root.getWord())); 
        } 
        return root; 
    }
    
    private String lastWord(TreeNode root) { 
        String lastWord = root.getWord(); 
        while (root.getLeft() != null) { 
            lastWord = root.getLeft().getWord(); 
            root = root.getLeft(); 
        } 
        return lastWord; 
    } 
}
