package datastr;

public class MyBSTNode <Ttype>{
	private Ttype element;
	private MyBSTNode<Ttype> leftCh = null;
	private MyBSTNode<Ttype> rightCh = null;
	private MyBSTNode<Ttype> parent = null;
	
	public MyBSTNode(Ttype inputElement) {
		if(inputElement != null) {
			element = inputElement;
		} else {
			element = (Ttype) new Object();
		}
		
	}

	public Ttype getElement() {
		return element;
	}

	public MyBSTNode<Ttype> getLeftCh() {
		return leftCh;
	}

	public MyBSTNode<Ttype> getRightCh() {
		return rightCh;
	}

	public MyBSTNode<Ttype> getParent() {
		return parent;
	}

	public void setElement(Ttype inputElement) {
		if(inputElement != null) {
			element = inputElement;
		}
	}

	public void setLeftCh(MyBSTNode<Ttype> inputLeftCh) {
		if(inputLeftCh != null) {
			leftCh = inputLeftCh;
		}
	}

	public void setRightCh(MyBSTNode<Ttype> inputRightCh) {
		if(inputRightCh != null) {
			rightCh = inputRightCh;
		}
	}

	public void setParent(MyBSTNode<Ttype> inputParent) {
		if(inputParent != null) {
			parent = inputParent;
		}
	}
	
	public String toString() {
		return "" + element;
	}
	
	
	
	
}
