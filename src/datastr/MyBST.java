package datastr;

public class MyBST <Ttype>{
	private MyBSTNode<Ttype> root = null;
	private MyBSTNode<Ttype> lastLeaf = null;
	private int counter = 0;
	
	private boolean isEmpty() {
		return (counter == 0);
	}
	
	public boolean isFull() {
		try {
			new MyBSTNode<Integer>(45);
			return false;
		}
		catch (OutOfMemoryError e) {
			return true;
		}
	}
	
	public int length() {
		return counter;
	}
	
	public void add(Ttype element) throws Exception{
		if(element == null) {
			throw new Exception("Element can not be null");
		}
	}
	
	public void newNode (Ttype node) throws Exception{
		if(node == null) {
			throw new Exception("Element cannot be null");
		}
		if(isEmpty()) {
			MyBSTNode<Ttype> newNode = new MyBSTNode<Ttype>(node);
			root = newNode;
			counter ++;
		} else {
			if(isFull()) {
				throw new Exception("BST is full");
			}
			
			addHelper(node, root);
		}
	}
	
	private void addHelper(Ttype element, MyBSTNode<Ttype> currentNode) {
		if(((Comparable)element).compareTo(currentNode.getElement()) == 1) {
			if(currentNode.getRightCh() == null) {
				MyBSTNode<Ttype> newNode = new MyBSTNode<>(element);
				currentNode.setRightCh(newNode);
				newNode.setParent(currentNode);
				counter++;
			}
			else {
				addHelper(element, currentNode.getRightCh());
			}
		} else if(((Comparable)element).compareTo(currentNode.getElement()) == -1) {
			if(currentNode.getLeftCh() == null) {
				MyBSTNode<Ttype> newNode = new MyBSTNode<>(element);
				currentNode.setLeftCh(newNode);
				newNode.setParent(currentNode);
				counter++;
			}else {
				addHelper(element, currentNode.getLeftCh());
			}
		
		}
	
	}

}
