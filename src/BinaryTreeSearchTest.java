import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)

public class BinaryTreeSearchTest {
	
	private iBinarySearch btsearch;
	
	public BinaryTreeSearchTest(iBinarySearch btsearch) {
	this.btsearch = btsearch;
	}
	
	@Parameters 
	 public static Collection<Object[]> setUp(){ 
		
			 return Arrays.asList(new Object[][] {
				// {new BinaryTreeSearch()},
				 {new BinaryTreeAVL()}
			 });
	 }	
	
	
	
	@Test
	public void testIniOne() {
		int []ini = {50};
		btsearch.init(ini);
		int [] expected = {50};
		int [] actual = btsearch.toArray();
		
		
		assertArrayEquals(expected, actual);
		
	}
	
	@Test
	public void testIniTwo() {
		int []ini = {50, 60};
		btsearch.init(ini);
		int [] expected = {50, 60};
		int [] actual = btsearch.toArray();
		
		assertArrayEquals(expected, actual);
		
	}

	@Test
	public void testIniMany() {
		int []ini = {50, 60, 30, 20, 70, 25, 65, 75};
		btsearch.init(ini);
		int [] expected = {20, 25, 30, 50, 60, 65, 70, 75};
		int [] actual = btsearch.toArray();
		
		assertArrayEquals(expected, actual);
		
	}
	@Test
	public void testIniNull() {
		int []ini = null;
		btsearch.init(ini);
		int [] expected = null;
		int [] actual = btsearch.toArray();
		
		assertArrayEquals(expected, actual);
		
	}
	
	
	@Test
	public void testLeavesMany() {
		int []ini = {50, 60, 30, 20, 70, 25, 65, 75};
		btsearch.init(ini);

		int actual = btsearch.leaves();

		int expected = 3;

		assertEquals(expected, actual);

	}
	
	@Test
	public void testLeavesOne() {
		int []ini = {50};
		btsearch.init(ini);

		int actual = btsearch.leaves();

		int expected = 1;

		assertEquals(expected, actual);
	}
	@Test
	public void testLeavesTwo() {
		int []ini = {50, 60, 30};
		btsearch.init(ini);

		int actual = btsearch.leaves();

		int expected = 2;

		assertEquals(expected, actual);

	}
	
	
	@Test
	public void testNodes01() {
		int []ini = {50, 60, 30, 20, 70, 25, 65, 75};
		btsearch.init(ini);

		int actual = btsearch.nodes();

		int expected = 5;

		assertEquals(expected, actual);

	}
	
	@Test
	public void testNodes02() {
		int []ini = {50, 60, 30, 25, 35, 55, 65};
		btsearch.init(ini);

		int actual = btsearch.nodes();

		int expected = 3;

		assertEquals(expected, actual);

	}
	
	
	@Test
	public void testNeightNodeMany() {
		int []ini = {50, 60, 30, 20, 70, 25, 65, 75};
		btsearch.init(ini);

		int actual = btsearch.height();

		int expected = 4;

		assertEquals(expected, actual);

	}
	
	@Test
	public void testNeightNodeOne() {
		int []ini = {50, 60};
		btsearch.init(ini);

		int actual = btsearch.height();

		int expected = 2;

		assertEquals(expected, actual);
	}
	
	@Test
	public void testNeightNodeTwo() {
		int []ini = {50, 60, 70};
		btsearch.init(ini);

		int actual = btsearch.height();

		int expected = 3;

		assertEquals(expected, actual);
	}
	
	@Test
	public void testNeightNode02() {
		int []ini = {50, 60, 30};
		btsearch.init(ini);

		int actual = btsearch.height();

	

		int expected = 2;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testNeightNode03() {
		int []ini = {50, 60, 30, 25, 35, 55, 65};
		btsearch.init(ini);

		int actual = btsearch.height();

		

		int expected = 3;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testWidth01() {
		btsearch.add(20);
		btsearch.add(40);
		btsearch.add(10);
		btsearch.add(30);
		int expected = 2;
		int actual =  btsearch.width();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testWidth02() {
		int []ini = {50, 60, 30, 20, 70, 65};
		btsearch.init(ini);
		int expected = 3;
		int actual =  btsearch.width();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testWidthtNode01() {
		int []ini = {50, 60, 30, 20, 70, 25, 65, 75};
		btsearch.init(ini);

		int actual = btsearch.width();

		int expected = 3;

		assertEquals(expected, actual);

	}
	
	@Test
	public void testReverseNode01() {
		int []ini = {50, 60, 30, 20, 70, 25, 65, 75};
		btsearch.init(ini);
		
		int [] expected = {75, 70, 65, 60, 50, 30, 25, 20};  
		btsearch.reverse();
		int [] actual = btsearch.toArray();

		assertArrayEquals(expected, actual);

	}
	
	@Test
	public void toArray01() {
		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
		btsearch.init(ini);
		
		int actual [] =  btsearch.toArray();
		

		int expected[] = {15, 20, 22, 24, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 73, 75, 80};
		
		for (int I: actual) {
			System.out.print(I + " ");
		}

		assertArrayEquals(expected, actual);

	}
	
	
	@Test
	public void delNoChild01() {
		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
		btsearch.init(ini);

		btsearch.del(80);
		int actual [] =  btsearch.toArray();
		

		int expected[] = {15, 20, 22, 24, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 73, 75};

		assertArrayEquals(expected, actual);

	}
	
	@Test
	public void delNoChild011() {
		int []ini = {50, 60, 30, 65, 75, 73, 55, 64, 61, 62, 80};
		btsearch.init(ini);

		btsearch.del(30);
		int actual [] =  btsearch.toArray();

		int expected[] = {50, 55, 60, 61, 62, 64, 65, 73, 75, 80};

		assertArrayEquals(expected, actual);

	}
	
	@Test
	public void delNoChild012() {
		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24,};
		btsearch.init(ini);

		btsearch.del(60);
		int actual [] =  btsearch.toArray();

		int expected[] = {15, 20, 22, 24, 25, 26, 28, 30, 50};

		assertArrayEquals(expected, actual);

	}
	
	@Test
	public void delNoChild02() {
		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
		btsearch.init(ini);

		btsearch.del(15);
		int actual [] =  btsearch.toArray();
		

		int expected[] = {20, 22, 24, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 73, 75, 80};

		assertArrayEquals(expected, actual);

	}
	
	@Test
	public void delNoChild022() {
		int []ini = {50, 60, 30, 20};
		btsearch.init(ini);

		btsearch.del(20);
		int actual [] =  btsearch.toArray();
		

		int expected[] = {30, 50, 60};

		assertArrayEquals(expected, actual);

	}
	
	@Test
	public void delNoChild03() {
		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
		btsearch.init(ini);

		btsearch.del(55);
		int actual [] =  btsearch.toArray();
		

		int expected[] = {15, 20, 22, 24, 25, 26, 28, 30, 50, 60, 61, 62, 64, 65, 73, 75, 80};

		assertArrayEquals(expected, actual);

	}
	
	@Test
	public void delNoChild04() {
		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
		btsearch.init(ini);

		btsearch.del(62);
		int actual [] =  btsearch.toArray();
		

		int expected[] = {15, 20, 22, 24, 25, 26, 28, 30, 50, 55, 60, 61, 64, 65, 73, 75, 80};

		assertArrayEquals(expected, actual);

	}
	
	@Test
	public void delNoChild05() {
		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
		btsearch.init(ini);

		btsearch.del(24);
		int actual [] =  btsearch.toArray();

		int expected[] = {15, 20, 22, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 73, 75, 80};

		assertArrayEquals(expected, actual);

	}
	
	@Test
	public void delChilOnRightd01() {
		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
		btsearch.init(ini);

		btsearch.del(22);
		int actual [] =  btsearch.toArray();
		

		int expected[] ={15, 20, 24, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 73, 75, 80};

		assertArrayEquals(expected, actual);

	}
	
	@Test
	public void delChilOnRightd02() {
		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
		btsearch.init(ini);

		btsearch.del(28);
		int actual [] =  btsearch.toArray();

		int expected[] ={15, 20, 22, 24, 25, 26, 30, 50, 55, 60, 61, 62, 64, 65, 73, 75, 80};

		assertArrayEquals(expected, actual);

	}
	
	@Test
	public void delChilOnRightd03() {
		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
		btsearch.init(ini);

		btsearch.del(62);
		int actual [] =  btsearch.toArray();
		
		int expected[] ={15, 20, 22, 24, 25, 26, 28, 30, 50, 55, 60, 61, 64, 65, 73, 75, 80};

		assertArrayEquals(expected, actual);
	}
	
	
	@Test
	public void delChilOnLeftd01() {
		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
		btsearch.init(ini);

		btsearch.del(24);
		int actual [] =  btsearch.toArray();
		
		int expected[] ={15, 20, 22, 23, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 72, 73, 75, 79, 80};

		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void delChilOnLeftd02() {
		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
		btsearch.init(ini);

		btsearch.del(73);
		int actual [] =  btsearch.toArray();
		
		int expected[] ={15, 20, 22, 23, 24, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 72, 75, 79, 80};

		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void delChilOnLeftd03() {
		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
		btsearch.init(ini);

		btsearch.del(79);
		int actual [] =  btsearch.toArray();
		
		int expected[] ={15, 20, 22, 23, 24, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 72, 73, 75, 80};

		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void delTwoChildren01() {
		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
		btsearch.init(ini);
		

		btsearch.del(30);
		int actual [] =  btsearch.toArray();
		
		int expected[] ={15, 20, 22, 23, 24, 25, 26, 28, 50, 55, 60, 61, 62, 64, 65, 72, 73, 75, 79, 80};

		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void delTwoChildren02() {
		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
		btsearch.init(ini);

		btsearch.del(65);
		int actual [] =  btsearch.toArray();
		
		int expected[] ={15, 20, 22, 23, 24, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 72, 73, 75, 79, 80};

		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void delTwoChildren03() {
		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
		btsearch.init(ini);
	

		btsearch.del(75);
		int actual [] =  btsearch.toArray();
		
		int expected[] ={15, 20, 22, 23, 24, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 72, 73, 79, 80};

		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void delTwoChildren04() {
		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
		btsearch.init(ini);

		btsearch.del(25);
		int actual [] =  btsearch.toArray();
		
		
		int expected[] ={15, 20, 22, 23, 24, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 72, 73, 75, 79, 80};

		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void delTwoChildren05() {
		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
		btsearch.init(ini);

		btsearch.del(20);
		int actual [] =  btsearch.toArray();
		
		int expected[] ={15, 22, 23, 24, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 72, 73, 75, 79, 80};

		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void delTwoChildrenRoot01() {
		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
		btsearch.init(ini);
		

		btsearch.del(50);
		int actual [] =  btsearch.toArray();
		
		int expected[] ={15, 20, 22, 23, 24, 25, 26, 28, 30, 55, 60, 61, 62, 64, 65, 72, 73, 75, 79, 80};

		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void delTwoChildrenRoot02() {
		int []ini = {50, 60, 30,};
		btsearch.init(ini);

		btsearch.del(50);
		int actual [] =  btsearch.toArray();
		
		int expected[] ={30,60};

		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void delTwoChildrenRoot03() {
		int []ini = {50, 60, 30, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
		btsearch.init(ini);

		btsearch.del(50);
		int actual [] =  btsearch.toArray();
		
		int expected[] ={30, 55, 60, 61, 62, 64, 65, 72, 73, 75, 79, 80};

		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void delTwoChildrenRootLeftNull() {
		int []ini = {50, 60, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
		btsearch.init(ini);

		btsearch.del(50);
		int actual [] =  btsearch.toArray();
		
		
		int expected[] ={55, 60, 61, 62, 64, 65, 72, 73, 75, 79, 80};

		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void delTwoChildrenRootRightNull() {
		int []ini = {50, 30, 20, 25, 26, 15, 22, 23, 28, 24,};
		btsearch.init(ini);

		btsearch.del(50);
		int actual [] =  btsearch.toArray();
		
		
		int expected[] ={15, 20, 22, 23, 24, 25, 26, 28, 30};

		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void delTwoChildrenRootOneNode() {
		int []ini = {50};
		btsearch.init(ini);

		btsearch.del(50);
		int actual [] =  btsearch.toArray();
		
		
		int expected[] ={};

		assertArrayEquals(expected, actual);
	}
	
	
	
	
	
//	@Test
//	public void del02NoChild011() {
//		int []ini = {50, 60, 30, 65, 75, 73, 55, 64, 61, 62, 80};
//		btsearch.init(ini);
//
//		btsearch.del2(30);
//		int actual [] =  btsearch.toArray();
//
//		int expected[] = {50, 55, 60, 61, 62, 64, 65, 73, 75, 80};
//
//		assertArrayEquals(expected, actual);
//
//	}
//	
//	@Test
//	public void del02NoChild012() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24,};
//		btsearch.init(ini);
//
//		btsearch.del2(60);
//		int actual [] =  btsearch.toArray();
//
//		int expected[] = {15, 20, 22, 24, 25, 26, 28, 30, 50};
//
//		assertArrayEquals(expected, actual);
//
//	}
//	
//	@Test
//	public void del02NoChild02() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
//		btsearch.init(ini);
//
//		btsearch.del2(15);
//		int actual [] =  btsearch.toArray();
//		
//
//		int expected[] = {20, 22, 24, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 73, 75, 80};
//
//		assertArrayEquals(expected, actual);
//
//	}
//	
//	@Test
//	public void del02NoChild022() {
//		int []ini = {50, 60, 30, 20};
//		btsearch.init(ini);
//
//		btsearch.del2(20);
//		int actual [] =  btsearch.toArray();
//		
//
//		int expected[] = {30, 50, 60};
//
//		assertArrayEquals(expected, actual);
//
//	}
//	
//	@Test
//	public void del02NoChild03() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
//		btsearch.init(ini);
//
//		btsearch.del2(55);
//		int actual [] =  btsearch.toArray();
//		
//
//		int expected[] = {15, 20, 22, 24, 25, 26, 28, 30, 50, 60, 61, 62, 64, 65, 73, 75, 80};
//
//		assertArrayEquals(expected, actual);
//
//	}
//	
//	@Test
//	public void del02NoChild04() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
//		btsearch.init(ini);
//
//		btsearch.del2(62);
//		int actual [] =  btsearch.toArray();
//		
//
//		int expected[] = {15, 20, 22, 24, 25, 26, 28, 30, 50, 55, 60, 61, 64, 65, 73, 75, 80};
//
//		assertArrayEquals(expected, actual);
//
//	}
//	
//	@Test
//	public void del02NoChild05() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
//		btsearch.init(ini);
//
//		btsearch.del2(24);
//		int actual [] =  btsearch.toArray();
//
//		int expected[] = {15, 20, 22, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 73, 75, 80};
//
//		assertArrayEquals(expected, actual);
//
//	}
//	
//	@Test
//	public void del02ChilOnRightd01() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
//		btsearch.init(ini);
//
//		btsearch.del2(22);
//		int actual [] =  btsearch.toArray();
//		
//
//		int expected[] ={15, 20, 24, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 73, 75, 80};
//
//		assertArrayEquals(expected, actual);
//
//	}
//	
//	@Test
//	public void del02ChilOnRightd02() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
//		btsearch.init(ini);
//
//		btsearch.del2(28);
//		int actual [] =  btsearch.toArray();
//
//		int expected[] ={15, 20, 22, 24, 25, 26, 30, 50, 55, 60, 61, 62, 64, 65, 73, 75, 80};
//
//		assertArrayEquals(expected, actual);
//
//	}
//	
//	@Test
//	public void del02ChilOnRightd03() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
//		btsearch.init(ini);
//
//		btsearch.del2(62);
//		int actual [] =  btsearch.toArray();
//		
//		int expected[] ={15, 20, 22, 24, 25, 26, 28, 30, 50, 55, 60, 61, 64, 65, 73, 75, 80};
//
//		assertArrayEquals(expected, actual);
//	}
//	
//	
//	@Test
//	public void del02ChilOnLeftd01() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
//		btsearch.init(ini);
//
//		btsearch.del2(24);
//		int actual [] =  btsearch.toArray();
//		
//		int expected[] ={15, 20, 22, 23, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 72, 73, 75, 79, 80};
//
//		assertArrayEquals(expected, actual);
//	}
//	
//	@Test
//	public void del02ChilOnLeftd02() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
//		btsearch.init(ini);
//
//		btsearch.del2(73);
//		int actual [] =  btsearch.toArray();
//		
//		int expected[] ={15, 20, 22, 23, 24, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 72, 75, 79, 80};
//
//		assertArrayEquals(expected, actual);
//	}
//	
//	@Test
//	public void del02ChilOnLeftd03() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
//		btsearch.init(ini);
//
//		btsearch.del2(79);
//		int actual [] =  btsearch.toArray();
//		
//		int expected[] ={15, 20, 22, 23, 24, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 72, 73, 75, 80};
//
//		assertArrayEquals(expected, actual);
//	}
//	
//	@Test
//	public void del02TwoChildren01() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
//		btsearch.init(ini);
//
//		btsearch.del2(30);
//		int actual [] =  btsearch.toArray();
//		
//		int expected[] ={15, 20, 22, 23, 24, 25, 26, 28, 50, 55, 60, 61, 62, 64, 65, 72, 73, 75, 79, 80};
//
//		assertArrayEquals(expected, actual);
//	}
//	
//	@Test
//	public void del02TwoChildren02() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
//		btsearch.init(ini);
//
//		btsearch.del2(65);
//		int actual [] =  btsearch.toArray();
//		
//		int expected[] ={15, 20, 22, 23, 24, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 72, 73, 75, 79, 80};
//
//		assertArrayEquals(expected, actual);
//	}
//	
//	@Test
//	public void del02TwoChildren03() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
//		btsearch.init(ini);
//
//		btsearch.del2(75);
//		int actual [] =  btsearch.toArray();
//		
//		int expected[] ={15, 20, 22, 23, 24, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 72, 73, 79, 80};
//
//		assertArrayEquals(expected, actual);
//	}
//	
//	@Test
//	public void del02TwoChildren04() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
//		btsearch.init(ini);
//
//		btsearch.del2(25);
//		int actual [] =  btsearch.toArray();
//		
//		
//		int expected[] ={15, 20, 22, 23, 24, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 72, 73, 75, 79, 80};
//
//		assertArrayEquals(expected, actual);
//	}
//	
//	@Test
//	public void del02TwoChildren05() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
//		btsearch.init(ini);
//
//		btsearch.del2(20);
//		int actual [] =  btsearch.toArray();
//		
//		int expected[] ={15, 22, 23, 24, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 72, 73, 75, 79, 80};
//
//		assertArrayEquals(expected, actual);
//	}
//	
//	@Test
//	public void del02TwoChildrenRoot01() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
//		btsearch.init(ini);
//
//		btsearch.del2(50);
//		int actual [] =  btsearch.toArray();
//		
//		int expected[] ={15, 20, 22, 23, 24, 25, 26, 28, 30, 55, 60, 61, 62, 64, 65, 72, 73, 75, 79, 80};
//
//		assertArrayEquals(expected, actual);
//	}
//	
//	@Test
//	public void del02TwoChildrenRoot02() {
//		int []ini = {50, 60, 30,};
//		btsearch.init(ini);
//
//		btsearch.del2(50);
//		int actual [] =  btsearch.toArray();
//		
//		int expected[] ={30,60};
//
//		assertArrayEquals(expected, actual);
//	}
//	
//	@Test
//	public void del02TwoChildrenRoot03() {
//		int []ini = {50, 60, 30, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
//		btsearch.init(ini);
//
//		btsearch.del2(50);
//		int actual [] =  btsearch.toArray();
//		
//		int expected[] ={30, 55, 60, 61, 62, 64, 65, 72, 73, 75, 79, 80};
//
//		assertArrayEquals(expected, actual);
//	}
//	
//	@Test
//	public void del02TwoChildrenRootLeftNull() {
//		int []ini = {50, 60, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
//		btsearch.init(ini);
//
//		btsearch.del2(50);
//		int actual [] =  btsearch.toArray();
//		
//		int expected[] ={55, 60, 61, 62, 64, 65, 72, 73, 75, 79, 80};
//
//		assertArrayEquals(expected, actual);
//	}
//	
//	@Test
//	public void del02TwoChildrenRootRightNull() {
//		int []ini = {50, 30, 20, 25, 26, 15, 22, 23, 28, 24,};
//		btsearch.init(ini);
//
//		btsearch.del2(50);
//		int actual [] =  btsearch.toArray();
//		
//		
//		int expected[] ={15, 20, 22, 23, 24, 25, 26, 28, 30};
//
//		assertArrayEquals(expected, actual);
//	}
//	
//	@Test
//	public void del02TwoChildrenRootOneNode() {
//		int []ini = {50};
//		btsearch.init(ini);
//
//		btsearch.del2(50);
//		int actual [] =  btsearch.toArray();
//		
//		
//		int expected[] ={};
//
//		assertArrayEquals(expected, actual);
//	}
//	
//	@Test
//	public void del03NoChild05() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
//		btsearch.init(ini);
//
//		btsearch.del3(24);
//		int actual [] =  btsearch.toArray();
//
//		int expected[] = {15, 20, 22, 25, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 73, 75, 80};
//
//		assertArrayEquals(expected, actual);
//
//	}
//	
//	@Test
//	public void delNo03Child03() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
//		btsearch.init(ini);
//
//		btsearch.del3(55);
//		int actual [] =  btsearch.toArray();
//		
//
//		int expected[] = {15, 20, 22, 24, 25, 26, 28, 30, 50, 60, 61, 62, 64, 65, 73, 75, 80};
//
//		assertArrayEquals(expected, actual);
//
//	}
//	
//	@Test
//	public void delChil03OnRightd03() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
//		btsearch.init(ini);
//
//		btsearch.del3(62);
//		int actual [] =  btsearch.toArray();
//		
//		int expected[] ={15, 20, 22, 24, 25, 26, 28, 30, 50, 55, 60, 61, 64, 65, 73, 75, 80};
//
//		assertArrayEquals(expected, actual);
//	}
//	
//	@Test
//	public void del03TwoChildren04() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
//		btsearch.init(ini);
//
//		btsearch.del3(25);
//		int actual [] =  btsearch.toArray();
//		
//		
//		int expected[] ={15, 20, 22, 23, 24, 26, 28, 30, 50, 55, 60, 61, 62, 64, 65, 72, 73, 75, 79, 80};
//
//		assertArrayEquals(expected, actual);
//	}
//	@Test
//	public void del03TwoChildren01() {
//		int []ini = {50, 60, 30, 20, 25, 26, 15, 22, 23, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80, 79, 72};
//		btsearch.init(ini);
//
//		btsearch.del3(30);
//		int actual [] =  btsearch.toArray();
//		
//		int expected[] ={15, 20, 22, 23, 24, 25, 26, 28, 50, 55, 60, 61, 62, 64, 65, 72, 73, 75, 79, 80};
//
//		assertArrayEquals(expected, actual);
//	}
	
	
	

}
