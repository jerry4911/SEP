import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AVLtreetest {

	// isEmpty()
	@Test
	void determineEmpty_nullTree_false_byCoverage() {	
		// given: 給一個空樹
		/*-----------------------------------------------------
		 *  isEmpty()的path只有兩種: root =null或 root !=null
		 *  為了測試 root =null的branch coverage，所以給一個空樹
		-------------------------------------------------------*/
		AvlTree avlTree = new AvlTree();
	
		// when: 判斷樹是否為空的結果
		boolean result = avlTree.isEmpty();
		
		// then: 期望的結果為 true
		boolean expected = true;
		assertEquals(expected, result);
	}
	@Test
	void determineEmpty_notNullTree_true_byCoverage() {
		// given: 給一個非空樹
		/*-----------------------------------------------------
		 * 為了測試 root !=null的branch coverage，所以給一個非空樹
		-------------------------------------------------------*/
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		
		// when: 判斷樹是否為空的結果
		boolean result = avlTree.isEmpty();
		
		// then: 期望的結果為 false
		boolean expected = false;
		assertEquals(expected, result);
	}
	
	// makeEmpty()
	@Test
	void makeEmpty_notNullTree_treeIsEmpty_byCoverage() {
		// given: 給一個非空樹
		/*-----------------------------------------------------
		 *  為了測試 root =null的statement coverage，先給一個非空樹
		-------------------------------------------------------*/
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		
		// when: 執行makeEmpty()，再取得判斷樹是否為空的結果
		avlTree.makeEmpty();
		boolean result = avlTree.isEmpty();
		
		// then: 期望的結果為 true
		boolean expected = true;
		assertEquals(expected, result);
	}
	
	// insert()
	@Test
	void insertElement_nullTree_balanceIsZero_byCoverage() {
		// given: 給一個空樹
		/*-----------------------------------------------------
		 *  為了測試 root =null的path coverage，先給一個空樹
		-------------------------------------------------------*/
		AvlTree avlTree = new AvlTree();
		
		// when: insert一個元素，再取得判斷樹是否為空的結果以及節點數
		int balance = avlTree.insert(10);
		boolean result = avlTree.isEmpty();	 //樹是否為空
		int node_num = avlTree.countNodes(); //節點數
		
		// then: isEmpty()期望的結果為false，countNode期望的結果為 1
		int expected_balance = 0;
		boolean expected = false;
		int expected_node_num = 1;
		assertEquals(expected_balance, balance);
		assertEquals(expected, result);
		assertEquals(expected_node_num, node_num);
	}
	@Test
	void insertElement_nodeWithNoChild_balanceIsOne_byCoverageAndPartition() {
		// given: 給一個空樹
		/*-----------------------------------------------------
		 *  為了測試 x<root.data 的path coverage，先給一個空樹
		-------------------------------------------------------*/
		AvlTree avlTree = new AvlTree();
		
		// when: insert一個元素，再取得判斷樹是否為空的結果以及節點數
		avlTree.insert(10);
		int balance = avlTree.insert(4);
		boolean result = avlTree.isEmpty();	 //樹是否為空
		int node_num = avlTree.countNodes(); //節點數
		
		// then: isEmpty()期望的結果為false，countNode期望的結果為 1
		int expected_balance = 1;
		boolean expected = false;
		int expected_node_num = 2;
		assertEquals(expected_balance, balance);
		assertEquals(expected, result);
		assertEquals(expected_node_num, node_num);
	}
}
