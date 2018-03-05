
public class Tree {

	private Tree parent;
	private Tree leftChild;
	private Tree rightChild;
	private int content;
	private boolean isRoot;
	
	public Tree(int num){//root constructor
		content = num;
		parent = null;
		leftChild = null;
		rightChild = null;
		isRoot = true;
	}//end root constructor
	
	
	public Tree getLeft(){
		return leftChild;
	}
	public Tree getRight(){
		return rightChild;
	}
	public Tree getParent(){
		return parent;
	}
	public int getContent(){
		return content;
	}
	public int getHeight(){
		if(this.isExternal()){
			return 0;
		}
		int h1 = 1 + this.leftChild.getHeight();
		int h2 = 1 + this.rightChild.getHeight();
		if (h1 >= h2){
			return h1;
		}//end if
		return h2;
	}
	public int getDepth(){
		if(this.isRoot){
			return 0;
		}
		return  1 + this.getParent().getDepth();
	}
	public void setLeft(Tree ch){
		leftChild = ch;
		ch.parent = this;
		ch.isRoot = false;
	}
	public void setRight(Tree ch){
		rightChild = ch;
		ch.parent = this;
		ch.isRoot = false;
	}
	public void setContent(int num){
		content = num;
	}
	public boolean isRoot(){
		return isRoot;
	}
	public boolean isInternal(){
		if(this.leftChild != null || this.rightChild != null){
			return true;
		}
		return false;
	}
	public boolean isExternal(){
		if(this.leftChild == null && this.rightChild == null){
			return true;
		}
		return false;
	}
	public Tree getRoot(){
		Tree tr = this;
		while (tr.getParent() != null){
			tr = tr.getParent();
		}//end while
		return tr;
	}
	
}//end Tree
