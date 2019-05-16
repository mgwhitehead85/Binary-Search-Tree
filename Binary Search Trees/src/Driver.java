/**
 * Name: Matt Whitehead
 * Title: Binary Search Trees
 * Due Date: 11/29/18
 * Description: Read-in text file, separate words, and add them to a binary search tree.
 * Print the tree inOrder, preOrder, and postOrder. Find common words that is used over 3%
 * of the total words. Delete the common words and print the tree again.
 */

import java.io.*;
import java.util.Scanner;

public class Driver {
	public static java.io.File inFile;
	public static Scanner inputFile;
	public static Scanner input;
	static final int percent = 3;
	private static int max;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		input = new Scanner(System.in);

				// Read in cards.txt file
		inFile = new java.io.File("BST text file1.txt");

				// If not found then close system
		if(!inFile.exists() ) {
			System.out.println("file not found");
			System.exit(-1);
		}
		
		BinarySearchTree binaryTree = new BinarySearchTree();
		
		inputFile = new Scanner(inFile);
		int count = 0;
		
				// Separate words, remove numbers and punctuation and add to tree
        while (inputFile.hasNext()) {
            String word = inputFile.next();
            word = word.replaceAll("[0-9]","");
            word = word.replaceAll("\\p{Punct}","");
            
            if (word.isEmpty()) {
            }
            else {
            		binaryTree.add(word);
            		count++;
            }
         }
   
        inputFile.close();
        
        		// Print out tree in-, pre-, and post-Order
        System.out.println("Binary Search Tree inOrder:");
        binaryTree.printInorder();
		System.out.println("\n");
		System.out.println("Binary Search Tree preOrder:");
		binaryTree.printPreOrder();
		System.out.println("\n");
		System.out.println("Binary Search Tree postOrder:");
		binaryTree.printPostOrder();
		System.out.println("\n");

				// Find words above max and delete from tree
		setMax(percent, count);
		System.out.println("Word count must exceed " + getMax() + " for deletion");
		binaryTree.showCommons();
		System.out.println("\nBinary Search Tree inOrder without common words:");
        binaryTree.printInorder();
        System.out.println("\n");
        binaryTree.deleteTree();
	}
	
			// Finds max amount of words. If word count exceeds max then it will be deleted
	public static void setMax(int percent, int count) {
		max = count / 100 * percent;
	}
	
	public static int getMax() {
		return max;
	}
	
}
