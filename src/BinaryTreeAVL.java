

public class BinaryTreeAVL implements iBinarySearch {
	Node root;
	
	class Node {
		int val;
		Node left, right;
		int height;
		
		public Node (int val) {
			this.val = val;
			height = 1;
		}
	}

	public void init(int[] ini) {
		clear();
		if (ini == null) ini = new int[0];
		for (int i: ini) {
			add(i);
		}
	}

	public void clear() {
		root = null;
		
	}
	
	private int getHeight (Node p) {
		int h = 0;
		if (p != null) h = p.height;
		return h;
	}
	
	private int getBalancedFactor (Node p) {
		return getHeight(p.right) - getHeight(p.left);
	}
	
	private void setHeight (Node p) {
		p.height = 1 + Math.max(getHeight(p.right), getHeight(p.left));
	}
	
	private Node rotateRight(Node p) {
		Node tmp = p.left;
		p.left = tmp.right;
		tmp.right = p;
		balance(p);
		balance(tmp);
		return tmp;
	}
	
	private Node rotateLeft(Node p) {
		Node tmp = p.right;
		p.right = tmp.left;
		tmp.left = p;
		balance(p);
		balance(tmp);
		return tmp;
	}
	
	private Node balance (Node p) {
		setHeight(p);
		int balFact = getBalancedFactor (p);
		if (balFact == 2) {
			if (getBalancedFactor(p.right) < 0) {
				p.right = rotateRight(p.right);	
			}
			return rotateLeft(p);
		}
		if (balFact == -2) {
			if (getBalancedFactor(p.left) > 0) {
				p.left = rotateLeft(p.left);
				}
			return rotateRight(p);
			}
		return p;
		}
	

	public void add(int val) {
		root = addNode(root, val);
		
	}
	

	private Node addNode(Node p, int val) {
		if (p == null) return new Node(val);
		if (val < p.val)p.left= addNode(p.left, val);
		else p.right = addNode(p.right, val);
		return balance(p);
	}

	public int size() {
		
		return sizeNode(root);
	}
	
	public int sizeNode(Node p) {
		 if (p == null) return 0;
		 
		 int count = 0;
		 count += sizeNode(p.left);
		 
		 count++;
		 
		 count += sizeNode(p.right);
		 return count;

	}
	

	public int leaves() {
		Counter leavecount = new Counter();
 		
		toNodeLeaves(root, leavecount);
		return leavecount.index;
	}
	
	private void toNodeLeaves(Node p, Counter i) {
		if (p == null) return; 
		toNodeLeaves(p.left, i);
		 if (p.left==null && p.right == null) i.index++; 
		 toNodeLeaves(p.right, i);
	}

	public int nodes() {
		
		return size() - leaves() ;
	}

	public int height() {
		return heightNode(root);
	}
	
	public int heightNode(Node p)
    {
    if (p == null)
      return 0;
    else
      return (1 + Math.max(heightNode(p.left), heightNode(p.right)));
    }

	public int width() {
		
		return getMaxWidth(root);
	}
	
	private int getMaxWidth (Node p) {
		int maxWidth = 0;
		int h = height();
		int [] ar = new int [h];
			getWidth(p, ar, 0);
			for (int I: ar) {
			if (maxWidth < I) maxWidth = I; }
		
		return maxWidth;
	}

	
	private void getWidth(Node p, int []ar, int level) {
		if (p == null) return;
		getWidth(p.left, ar, level+1);
		ar[level]++;
		getWidth(p.right, ar, level+1);
	}

	public void reverse() {
		root = reverseNode(root);
	}
	
	private Node reverseNode(Node n) {
		
		if (n == null) return n;
		
		Node leftSide = reverseNode(n.left);
		Node rightSide = reverseNode(n.right);
		
		n.left = rightSide;
		n.right = leftSide;
		
		return n;
	}

	public void del(int val) {
		root = delNode(root, val);
	}

	private Node searchMin(Node p) {
		return (p.left != null)? searchMin(p.left) : p;
	}
	
	private Node removeMin(Node p) {
		if (p.left == null) return p.right;
		p.left = removeMin(p.left);
		return balance(p);
	}
	private Node delNode(Node p, int val) {
		if (p == null) return null;
		if (val < p.val) p.left = delNode(p.left, val);
		else if (val > p.val) p.right = delNode(p.right, val);
		else {
			 Node l= p.left;
			 Node r = p.right;
			 if (r == null) return l;
			 Node min = searchMin(r);
			 min.right = removeMin(r);
			 min.left = l;
			 
			 return balance(min);
		}
		return balance(p);
		
	}
	
	

	public void del2(int val) {
		// TODO Auto-generated method stub
		
	}
	private class Counter {
		int index = 0;
	}
	
	public int[] toArray() {
		
		int [] bsArr = new int [size ()];
		
		toArrayNode(root, bsArr, new Counter());

		
		return bsArr;
	}
	
	private void toArrayNode(Node p, int [] bsArr, Counter i) {
		if (p == null) return; 
		 toArrayNode(p.left, bsArr, i);
		 bsArr[i.index++] = p.val; 
		 toArrayNode(p.right, bsArr, i);
	}

//	@Override
//	public void del3(int i) {
//		// TODO Auto-generated method stub
//		
//	}

}
