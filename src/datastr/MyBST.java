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
	
	
	public void add (Ttype node) throws Exception{
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
	
	public boolean searchElement(Ttype element) throws Exception{
		if(isEmpty()) {
			throw new Exception("Tree is empty!");
		}
		if(element == null) {
			throw new Exception("Element cannot be null");
		}
		
		boolean result = searchHelper(element, root);
		return result;
		
		
	}
	private boolean searchHelper(Ttype element, MyBSTNode<Ttype> currentNode) {
		
		if(element.equals(currentNode.getElement())) {
			return true;
		} else{
			if(((Comparable)element).compareTo(currentNode.getElement()) == 1) {
				if(currentNode.getRightCh() == null) {
					return false;
				}
				else {
					return searchHelper(element, currentNode.getRightCh());
				}
			} else if(((Comparable)element).compareTo(currentNode.getElement()) == -1) {
				if(currentNode.getLeftCh() == null)
				{
					return false;
				}
				else
				{
					return searchHelper(element, currentNode.getLeftCh());
				}
			}
		}
		return false;
	}
	
	public void print() throws Exception{
		if(isEmpty()) {
			throw new Exception("BST is empty and it is not possible to print elements");
		}
		
		printHelper(root);
	}
	
	private void printHelper(MyBSTNode<Ttype> currentNode) {
		System.out.println("R -> " + currentNode.getElement());
		
		if(currentNode.getLeftCh() != null) {
			System.out.println("Left ch -> " + currentNode.getLeftCh().getElement() + " (" + currentNode.getElement() + ")");
			printHelper(currentNode.getLeftCh());
			
		}
		
		if(currentNode.getRightCh() != null) {
			System.out.println("Right ch -> " + currentNode.getRightCh().getElement() + " (" + currentNode.getElement() + ")");
			printHelper(currentNode.getRightCh());
			
		}
	}
	
	private void makeEmpty() {
		if(!isEmpty()) {
			root = null;
			lastLeaf = null;
			counter = 0;
			System.gc();
		}
	}
	
	public void delete(Ttype element) throws Exception {
		if(isEmpty()) {
			throw new Exception("BST is empty and it is not possible to print elements");
		}
		if(!searchElement(element)) {
			throw new Exception("Element does not exist!");
		}
		
		deleteHelper(element, root);
	}
	
	private void deleteHelper(Ttype element, MyBSTNode<Ttype> currentNode) {
		if(element.equals(currentNode.getElement())) {
			if(currentNode.getLeftCh() == null && currentNode.getRightCh() == null)
			{
				MyBSTNode<Ttype> parentOfCurrentNode = currentNode.getParent();
				if(parentOfCurrentNode.getLeftCh().getElement().equals(element)) {
					parentOfCurrentNode.setLeftCh(null);
				} else if(parentOfCurrentNode.getRightCh().getElement().equals(element)) {
					parentOfCurrentNode.setRightCh(null);
				}
			}
			
			else if(currentNode.getLeftCh() == null && currentNode.getRightCh() != null){
				MyBSTNode<Ttype> parentOfCurrentNode = currentNode.getParent();
				MyBSTNode<Ttype> rightChildOfCurrentNode = currentNode.getRightCh();
				
				parentOfCurrentNode.setRightCh(rightChildOfCurrentNode);
				rightChildOfCurrentNode.setParent(parentOfCurrentNode);	
				
				//kreisais
			} else if(currentNode.getLeftCh() !=null && currentNode.getRightCh() != null) {
				
			}
			
			
			
			
		}else {
			if(((Comparable)element).compareTo(currentNode.getElement()) == 1) {
				if(currentNode.getRightCh() != null) {
					deleteHelper(element, currentNode.getRightCh());
				}
			} else if(((Comparable)element).compareTo(currentNode.getElement()) == -1){
				if(currentNode.getLeftCh() != null) {
					deleteHelper(element, currentNode.getLeftCh());
				}
			}
		}
	}
	
	
	

}
