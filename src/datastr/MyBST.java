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

}
