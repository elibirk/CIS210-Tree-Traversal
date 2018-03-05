import java.io.FileNotFoundException;
import java.io.IOException;

public class TreeTest {

	public static void main(String[]args) throws IOException, FileNotFoundException{
		Tree root = new Tree(0);
		Tree temp = new Tree(1);
		
		fillTree(root);
		System.out.println("An example where root is 0, and trees are numbered by depth and a 1 for left children "
				+ "or 2 for right children: ");
		System.out.println("PreOrder traversal: ");
		preOrder(root);

		System.out.println("InOrder traversal: ");
		inOrder(root);

		System.out.println("PostOrder traversal: ");
		postOrder(root);
		
		System.out.println("\nA more simple version, with the tree: \n\t\t0\n\t1\t\t2\n3\t\t\t\t4\n\t5"
				+ "\n(Where 1 and 2 are root's children, 3 is the child of 1, 5 is the right child of 3, and 4 is"
				+ " the child of 2):");
		root = new Tree(0);
		root.setLeft(temp);
		temp = new Tree(2);
		root.setRight(temp);
		temp = new Tree(3);
		root.getLeft().setLeft(temp);
		temp = new Tree(5);
		root.getLeft().getLeft().setRight(temp);
		temp = new Tree(4);
		root.getRight().setRight(temp);
		System.out.println("PreOrder traversal: ");
		preOrder(root);

		System.out.println("InOrder traversal: ");
		inOrder(root);

		System.out.println("PostOrder traversal: ");
		postOrder(root);
	}//end main
	
	public static void preOrder(Tree tr){
		System.out.println(tr.getContent());
		if(tr.getLeft() != null){
			preOrder(tr.getLeft());
		}//end if
		if(tr.getRight() != null){
			preOrder(tr.getRight());
		}
		return;
	}
	
	public static void inOrder(Tree tr){
		//If left, go there, if none, state, then go right, return if no right
		if(tr.getLeft() != null){
			inOrder(tr.getLeft());
		}//end if
		System.out.println(tr.getContent());
		if(tr.getRight() != null){
			inOrder(tr.getRight());
		}//end if
		return;
	}
	
	public static void postOrder(Tree tr){
		//If left, traverse, if no left state, then move to right, if no right, return
		if(tr.getLeft() != null){
			postOrder(tr.getLeft());
		}//end if
		if(tr.getRight() != null){
			postOrder(tr.getRight());
		}//end if
		System.out.println(tr.getContent());
		return;

	}
	
	public static void fillTree(Tree parent){
		if(parent.getDepth() > 2){
			return;
		}
		int num = parent.getContent()/10 * 10 + 10;
		Tree l = new Tree (num + 1);
		parent.setLeft(l);
		Tree r = new Tree (num + 2);
		parent.setRight(r);
		fillTree(l);
		fillTree(r);
	}
}//end treeTest
