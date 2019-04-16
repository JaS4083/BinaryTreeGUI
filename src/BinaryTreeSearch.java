import java.util.Arrays;


public class BinaryTreeSearch implements iBinarySearch {
	Node root;
	
	class Node {
		int val;
		Node left;
		Node right;
		public Node(int val) {
			super();
			this.val = val;
		}
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
	

	public void add(int val) {
		
		if (root ==null) root = new Node(val);
		
		else
		 addNode(root, val);
		
	}
	
	public void addNode(Node n, int val) {
	 
				if (val < n.val) {
					if (n.left == null) {
					n.left = new Node(val);
					return; }
					addNode(n.left, val);
				}
				else {
					if (n.right == null) {
						n.right = new Node (val);
						return; }
						addNode(n.right, val);
					}
				}

	public void add2(int val) {
		
	}
	
	private Node addNode2(int val, Node p) {
		if (p == null) return new Node (val);
		
		if (val < p.val) p.left=  addNode2(val, p.left);
		else if (val < p.val) p.right = addNode2(val, p.right);
		return p;
		
		
	}
	
	private class Counter {
		int index = 0;
	}
	
	@Override
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
	
	@Override
	public void init(int[] ini) {
		if (ini == null) ini = new int[0];
		for (int i: ini) {
			add(i);
		}
		
	}

	@Override
	public void clear() {
		root = null;
	}
  
	@Override
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

	@Override
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
	@Override
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
		delNode(root, val, root);
	}

	
	private void delNode(Node n, int val, Node par) {
		if (n == null) throw new IllegalArgumentException();
	
		if (val < n.val) delNode(n.left, val, n);
		else if (val > n.val) delNode(n.right, val, n);
		else {	
		if (n.left == null && n.right == null) {
			if(n == root) { root = null; return;}
			if (par.left == n) {par.left = null;}
			else { par.right = null;}
		
		} else if (n.left == null) {
			if (n == root) { root = root.right; return;}
			if(par.left == n) {
				par.left = n.right;
			} else {
				par.right = n.right;
			}
		} else if (n.right == null) {
			if (n == root) { root = root.left; return;}
			if(par.right == n) {
			par.right = n.left;
			} else {
				par.left = n.left;
			}
		} else {
			Node success = findSuccess(n);
			if (n == root) root = success;
			else if(par.left == n) {
				par.left =  success;
			} else {
				par.right = success;
			}
			success.right = n.right;
			
		}
	}
	}
	
	
	private Node findSuccess (Node n) {
		Node suc = n;
		Node sucPar = n;
		Node cur = n.left;
		
		while (cur !=null) {
			
			sucPar = suc;
			suc = cur;
			cur = cur.right;
		}

		
		Node tmp = suc;
		if (suc != n.left) {
		sucPar.right = suc.left;
		suc.left = n.left; 
		}
		
		
		return tmp;
	}
	
	public void del2(int val) {
		delNode2(root, val, root);
	}
	
	private void delNode2(Node n, int val, Node par) {
		if (n == null) throw new IllegalArgumentException();
		
		if (val < n.val) delNode(n.left, val, n);
		else if (val > n.val) delNode(n.right, val, n);
		else {	
		if (n.left == null && n.right == null) {
			if(n == root) { root = null; return;}
			if (par.left == n) {par.left = null;}
			else { par.right = null;}
		
		} else if (n.left == null) {
			if (n == root) { root = root.right; return;}
			if(par.left == n) {
				par.left = n.right;
			} else {
				par.right = n.right;
			}
		} else if (n.right == null) {
			if (n == root) { root = root.left; return;}
			if(par.right == n) {
			par.right = n.left;
			} else {
				par.left = n.left;
			}
		} else {
			Node success = findSuccess2(n);
			if (n == root) root = success;
			
			else if(par.left == n) {
				par.left =  success;
			} else {
				par.right = success;
			}
			success.left = n.left;
			
		}
		}
		
	}
	
	private Node findSuccess2 (Node n) {
		Node suc = n;
		Node sucPar = n;
		Node cur = n.right;
		
while (cur !=null) {
			
			sucPar = suc;
			suc = cur;
			cur = cur.left;
		}
	Node tmp = suc;
	if (suc != n.right) {
	sucPar.left = suc.right;	
	suc.right = n.right;
	
	}
		return suc;
	}
	

	
//public static void main(String [] args) {
//	BinaryTreeSearch bts = new BinaryTreeSearch();
//	int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
//	bts.init(ini);
//	//bts.del(80);
//	
//	System.out.println(Arrays.toString(bts.toArray()));
//	
//}

		}
