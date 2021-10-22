import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AVLtreetest {
	
	AvlNode avlNode = new AvlNode();
	/*-------------------------------------------------
	 * 
	 * 測試 insert() function
	 * 
	 -------------------------------------------------*/
	@Test
	void Insert_ToNullTree_BalanceIs0_byCoverage() {
		/*------------------------------------------
		 *  測試插入一個data到空樹的情況，插入後root的Balance應為0
		 *  given:給一個空樹
		 *  when: 取得插入10後的Balance
		 *  then: 預期結果為0
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		
		// when
		int balance = avlTree.insert(10);
		
		// then
		int expected = 0;
		assertEquals(expected, balance);
	}
	
	@Test
	void Insert_DuplicatedData_BalanceIs0_byCoverageAndNegative() {
		/*------------------------------------------
		 *  測試插入重複data的情況，插入後root的Balance應該和原本一樣是0
		 *  given:給一個已存在10的樹
		 *  when: 取得重複插入10後的Balance
		 *  then: 預期結果為0
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		
		// when
		int balance = avlTree.insert(10);
		
		// then
		int expected = 0;
		assertEquals(expected, balance);
	}
	
	@Test
	void Insert_LLrotation_BalanceIs0_byCoverageAndPartition() {
		/*------------------------------------------
		 *  測試插入3個數字，造成LL的情況，如下圖:
		 *     10
		 *     /
		 *    4
		 *   /
		 *  2
		 *  given: 10 4 2 => LL
		 *  when: 取得root的Balance
		 *  then: 預期結果為0
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		avlTree.insert(4);
		
		// when
		int balance = avlTree.insert(2);
		
		// then
		int expected = 0;
		assertEquals(expected, balance);
	}
	
	@Test
	void Insert_LRrotation_BalanceIs0_byCoverageAndPartition() {
		/*------------------------------------------
		 *  測試插入3個數字，造成LR的情況，如下圖:
		 *     10
		 *     /
		 *    2
		 *     \
		 *      4
		 *  given: 10 2 4 => LR
		 *  when: 取得root的Balance
		 *  then: 預期結果為0
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		avlTree.insert(2);
		
		// when
		int balance = avlTree.insert(4);
		
		// then
		int expected = 0;
		assertEquals(expected, balance);
	}
	
	@Test
	void Insert_RLrotation_BalanceIs0_byCoverageAndPartition() {
		/*------------------------------------------
		 *  測試插入3個數字，造成RL的情況，如下圖:
		 *     10
		 *      \
		 *      15
		 *      /
		 *     4
		 *  given: 10 15 4 => RL
		 *  when: 取得root的Balance
		 *  then: 預期結果為0
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		avlTree.insert(15);
		
		// when
		int balance = avlTree.insert(14);
		
		// then
		int expected = 0;
		assertEquals(expected, balance);
	}
	
	@Test
	void Insert_RRrotation_BalanceIs0_byCoverageAndPartition() {
		/*------------------------------------------
		 *  測試插入3個數字，造成RR的情況，如下圖:
		 *     10
		 *      \
		 *      15
		 *        \
		 *        16
		 *  given: 10 15 16 => RR
		 *  when: 取得root的Balance
		 *  then: 預期結果為0
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		avlTree.insert(15);
		
		// when
		int balance = avlTree.insert(16);
		
		// then
		int expected = 0;
		assertEquals(expected, balance);
	}
	
	/*-------------------------------------------------
	 * 
	 * 測試 inorder() function
	 * 
	 -------------------------------------------------*/
	@Test
	void Inorder_NullTree_Null_byCoverageAndNegative() {
		/*------------------------------------------
		 *  測試空樹的inorder，結果應該為空字串
		 *  given:給一個空樹
		 *  when: 取得inorder字串
		 *  then: 預期結果為""
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		
		// when
		String inorder = avlTree.inorder();
		
		// then
		String expected = "";
		assertEquals(expected, inorder);
	}
	
	@Test
	void Inorder_NotNullTree_Inorder_byCoverage() {
		/*------------------------------------------
		 *  測試有3個元素的樹的inorder，結果應該為由小->中->大
		 *     10
		 *    /  \
		 *   2    4
		 *  given: 10 2 4
		 *  when: 取得inorder字串
		 *  then: 預期結果為"2 4 10"
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		avlTree.insert(2);
		avlTree.insert(4);
		
		// when
		String inorder = avlTree.inorder();
		
		// then
		String expected = "2 4 10";
		assertEquals(expected, inorder);
	}
	
	/*-------------------------------------------------
	 * 
	 * 測試 preorder() function
	 * 
	 -------------------------------------------------*/
	@Test
	void Preorder_NullTree_Null_byCoverageAndNegative() {
		/*------------------------------------------
		 *  測試空樹的preorder，結果應該為空字串
		 *  given:給一個空樹
		 *  when: 取得preorder字串
		 *  then: 預期結果為""
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		
		// when
		String preorder = avlTree.preorder();
		
		// then
		String expected = "";
		assertEquals(expected, preorder);
	}
	
	@Test
	void Preorder_NotNullTree_Preorder_byCoverage() {
		/*------------------------------------------
		 *  測試有3個元素的樹的preorder，結果應該為中->小->大
		 *     10
		 *    /  \
		 *   2    4
		 *  given: 10 2 4
		 *  when: 取得preorder字串
		 *  then: 預期結果為"4 2 10"
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		avlTree.insert(2);
		avlTree.insert(4);
		
		// when
		String preorder = avlTree.preorder();
		
		// then
		String expected = "4 2 10";
		assertEquals(expected, preorder);
	}
	
	/*-------------------------------------------------
	 * 
	 * 測試 postorder() function
	 * 
	 -------------------------------------------------*/
	@Test
	void Postorder_NullTree_Null_byCoverageAndNegative() {
		/*------------------------------------------
		 *  測試空樹的postorder，結果應該為空字串
		 *  given:給一個空樹
		 *  when: 取得postorder字串
		 *  then: 預期結果為""
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		
		// when
		String postorder = avlTree.postorder();
		
		// then
		String expected = "";
		assertEquals(expected, postorder);
	}
	
	@Test
	void Postorder_NotNullTree_Postorder_byCoverage() {
		/*------------------------------------------
		 *  測試有3個元素的樹的postorder，結果應該為小->大->中
		 *     10
		 *    /  \
		 *   2    4
		 *  given: 10 2 4
		 *  when: 取得postorder字串
		 *  then: 預期結果為"2 10 4"
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		avlTree.insert(2);
		avlTree.insert(4);
		
		// when
		String postorder = avlTree.postorder();
		
		// then
		String expected = "2 10 4";
		assertEquals(expected, postorder);
	}
	
	/*-------------------------------------------------
	 * 
	 * 測試 search() function
	 * 
	 -------------------------------------------------*/
	@Test
	void Search_FromNullTree_False_byCoverageAndNegative() {
		/*------------------------------------------
		 *  測試在空樹中搜尋data，結果應該為false
		 *  given:給一個空樹，搜尋10
		 *  when: 取得搜尋10的結果
		 *  then: 預期結果為false
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		
		// when
		boolean find = avlTree.search(10);
		
		// then
		boolean expected = false;
		assertEquals(expected, find);
	}
	
	@Test
	void Search_ExistedDataEqual_True_byCoverage() {
		/*------------------------------------------
		 *  測試在非空樹中搜尋已存在data，結果應該為true
		 *  given:給一個樹，包含10、2、4
		 *  when: 取得搜尋10、2、4的結果
		 *  then: 預期結果為true
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		avlTree.insert(2);
		avlTree.insert(4);
		
		// when
		boolean find = avlTree.search(10) & avlTree.search(2) & avlTree.search(4);
		
		// then
		boolean expected = true;
		assertEquals(expected, find);
	}
	
	@Test
	void Search_NotExistedData_False_byCoverage() {
		/*------------------------------------------
		 *  測試在非空樹中搜尋不存在的data，結果應該為false
		 *  不存在的data值在樹的最大data值和最小data值範圍內(2~10)
		 *  given:給一個樹，包含10、2、4
		 *  when: 取得搜尋3的結果
		 *  then: 預期結果為false
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		avlTree.insert(4);
		avlTree.insert(2);
		
		// when
		boolean find = avlTree.search(3);
		
		// then
		boolean expected = false;
		assertEquals(expected, find);
	}
	
	@Test
	void Search_NotExistedDataSmaller_False_byBoundary() {
		/*------------------------------------------
		 *  測試在非空樹中搜尋不存在的data，結果應該為false
		 *  不存在的data值比樹的最小的data更小
		 *  given:給一個樹，包含10、2、4
		 *  when: 取得搜尋-1的結果
		 *  then: 預期結果為false
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		avlTree.insert(4);
		avlTree.insert(2);
		
		// when
		boolean find = avlTree.search(-1);
		
		// then
		boolean expected = false;
		assertEquals(expected, find);
	}
	
	@Test
	void Search_NotExistedDataLarger_False_byBoundary() {
		/*------------------------------------------
		 *  測試在非空樹中搜尋不存在的data，結果應該為false
		 *  不存在的data值比樹的最大的data更大
		 *  given:給一個樹，包含10、2、4
		 *  when: 取得搜尋11的結果
		 *  then: 預期結果為false
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		avlTree.insert(4);
		avlTree.insert(2);
		
		// when
		boolean find = avlTree.search(11);
		
		// then
		boolean expected = false;
		assertEquals(expected, find);
	}
	
	/*-------------------------------------------------
	 * 
	 * 測試 countNodes() function
	 * 
	 -------------------------------------------------*/
	@Test
	void CountNodes_NullTree_0_byCoverage() {
		/*------------------------------------------
		 *  測試空樹的節點樹，結果應該為0
		 *  given:給一個空樹
		 *  when: 取得節點樹
		 *  then: 預期結果為0
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		
		// when
		int node_num = avlTree.countNodes();
		
		// then
		int expected = 0;
		assertEquals(expected, node_num);
	}
	
	@Test
	void CountNodes_NotNullTree_BigThan0_byCoverage() {
		/*------------------------------------------
		 *  測試非空樹的節點樹，結果應該大於0
		 *  given:給一個有3個data的空樹
		 *  when: 取得節點樹
		 *  then: 預期結果為3
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		avlTree.insert(2);
		avlTree.insert(4);
		
		// when
		int node_num = avlTree.countNodes();
		
		// then
		int expected = 3;
		assertEquals(expected, node_num);
	}
	
	/*-------------------------------------------------
	 * 
	 * 測試 isEmpty() function
	 * 
	 -------------------------------------------------*/
	@Test
	void IsEmpty_NullTree_True_byCoverage() {
		/*------------------------------------------
		 *  測試判斷空樹是否為空，結果應該為true
		 *  given:給一個空樹
		 *  when: 取得判斷樹是否為空的結果
		 *  then: 預期結果為true
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		
		// when
		boolean isEmpty = avlTree.isEmpty();
		
		// then
		boolean expected = true;
		assertEquals(expected, isEmpty);
	}
	
	@Test
	void IsEmpty_NotNullTree_False_byCoverage() {
		/*------------------------------------------
		 *  測試判斷非空樹是否為空，結果應該為false
		 *  given:給一個非空樹
		 *  when: 取得判斷樹是否為空的結果
		 *  then: 預期結果為false
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		
		// when
		boolean isEmpty = avlTree.isEmpty();
		
		// then
		boolean expected = false;
		assertEquals(expected, isEmpty);
	}
	
	/*-------------------------------------------------
	 * 
	 * 測試 makeEmpty() function
	 * 
	 -------------------------------------------------*/
	@Test
	void MakeEmpty_NullTree_True_byCoverage() {
		/*------------------------------------------
		 *  測試清空空樹，再判斷樹是否為空，結果應該為true
		 *  given:給一個空樹，再清空
		 *  when: 取得判斷樹是否為空的結果
		 *  then: 預期結果為true
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		avlTree.makeEmpty();
		
		// when
		boolean isEmpty = avlTree.isEmpty();
		
		// then
		boolean expected = true;
		assertEquals(expected, isEmpty);
	}
	
	@Test
	void MakeEmpty_NotNullTree_True_byCoverage() {
		/*------------------------------------------
		 *  測試清空非空樹，再判斷樹是否為空，結果應該為true
		 *  given:給一個非空樹，再清空
		 *  when: 取得判斷樹是否為空的結果
		 *  then: 預期結果為true
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		avlTree.makeEmpty();
		
		// when
		boolean isEmpty = avlTree.isEmpty();
		
		// then
		boolean expected = true;
		assertEquals(expected, isEmpty);
	}
	
	/*-------------------------------------------------
	 * 
	 * Performance tests
	 * 
	 -------------------------------------------------*/
	@Test
	void Insert_WorstCase_logN_byPerformance() {
		/*------------------------------------------
		 *  測試額外插入10^6個data到原本就有2*10^6個data的樹，worstcase是否符合O(logn)
		 *  	c_1*logn < T(n) < c_2*logn
		 *  	假設 n = 10^6，則插入2*10^6個data的執行秒數應為插入10^6的1.05017166594倍以內
		 *  	lg(2*10^6)/lg(10^6) = 1.05017166594
		 *  
		 *  given:先給一個有10^6個data的樹計算額外插入10^6個data的秒數
		 *  when: 再計算額外插入10^6個data的秒數，看是否有符合O(logn)
		 *  then: 預期結果為true
		 -------------------------------------------*/
		// given
		AvlTree avlTree = new AvlTree();
		for (int i=1; i<=1000000; i++) {
			avlTree.insert(i);
		}
		double startTime = System.nanoTime();
		for (int i=1000001; i<=2000000; i++) {
			avlTree.insert(i);
		}
		double endTime = System.nanoTime();
		double duration_base = (endTime - startTime)/1000000000; //seconds
		
		// when
		startTime = System.nanoTime();
		for (int i=2000001; i<=3000000; i++) {
			avlTree.insert(i);
		}
		endTime = System.nanoTime();
		double duration = (endTime - startTime)/1000000000; //seconds
		boolean in_range = duration <= (duration_base*1.05017166594)? true:false;
		
		// then
		boolean expected = true;
		assertEquals(expected, in_range);
	}

}
