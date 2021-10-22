import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AVLtreetest {

	// isEmpty()
	@Test
	void determineEmpty_nullTree_false_byCoverage() {	
		// given: ���@�Ӫž�
		/*-----------------------------------------------------
		 *  isEmpty()��path�u�����: root =null�� root !=null
		 *  ���F���� root =null��branch coverage�A�ҥH���@�Ӫž�
		-------------------------------------------------------*/
		AvlTree avlTree = new AvlTree();
	
		// when: �P�_��O�_���Ū����G
		boolean result = avlTree.isEmpty();
		
		// then: ���檺���G�� true
		boolean expected = true;
		assertEquals(expected, result);
	}
	@Test
	void determineEmpty_notNullTree_true_byCoverage() {
		// given: ���@�ӫD�ž�
		/*-----------------------------------------------------
		 * ���F���� root !=null��branch coverage�A�ҥH���@�ӫD�ž�
		-------------------------------------------------------*/
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		
		// when: �P�_��O�_���Ū����G
		boolean result = avlTree.isEmpty();
		
		// then: ���檺���G�� false
		boolean expected = false;
		assertEquals(expected, result);
	}
	
	// makeEmpty()
	@Test
	void makeEmpty_notNullTree_treeIsEmpty_byCoverage() {
		// given: ���@�ӫD�ž�
		/*-----------------------------------------------------
		 *  ���F���� root =null��statement coverage�A�����@�ӫD�ž�
		-------------------------------------------------------*/
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		
		// when: ����makeEmpty()�A�A���o�P�_��O�_���Ū����G
		avlTree.makeEmpty();
		boolean result = avlTree.isEmpty();
		
		// then: ���檺���G�� true
		boolean expected = true;
		assertEquals(expected, result);
	}
	
	// insert()
	@Test
	void insertElement_nullTree_balanceIsZero_byCoverage() {
		// given: ���@�Ӫž�
		/*-----------------------------------------------------
		 *  ���F���� root =null��path coverage�A�����@�Ӫž�
		-------------------------------------------------------*/
		AvlTree avlTree = new AvlTree();
		
		// when: insert�@�Ӥ����A�A���o�P�_��O�_���Ū����G�H�θ`�I��
		int balance = avlTree.insert(10);
		boolean result = avlTree.isEmpty();	 //��O�_����
		int node_num = avlTree.countNodes(); //�`�I��
		
		// then: isEmpty()���檺���G��false�AcountNode���檺���G�� 1
		int expected_balance = 0;
		boolean expected = false;
		int expected_node_num = 1;
		assertEquals(expected_balance, balance);
		assertEquals(expected, result);
		assertEquals(expected_node_num, node_num);
	}
	@Test
	void insertElement_nodeWithNoChild_balanceIsOne_byCoverageAndPartition() {
		// given: ���@�Ӫž�
		/*-----------------------------------------------------
		 *  ���F���� x<root.data ��path coverage�A�����@�Ӫž�
		-------------------------------------------------------*/
		AvlTree avlTree = new AvlTree();
		
		// when: insert�@�Ӥ����A�A���o�P�_��O�_���Ū����G�H�θ`�I��
		avlTree.insert(10);
		int balance = avlTree.insert(4);
		boolean result = avlTree.isEmpty();	 //��O�_����
		int node_num = avlTree.countNodes(); //�`�I��
		
		// then: isEmpty()���檺���G��false�AcountNode���檺���G�� 1
		int expected_balance = 1;
		boolean expected = false;
		int expected_node_num = 2;
		assertEquals(expected_balance, balance);
		assertEquals(expected, result);
		assertEquals(expected_node_num, node_num);
	}
}
