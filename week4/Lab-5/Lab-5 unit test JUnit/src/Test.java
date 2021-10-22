import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class Test {
	@org.junit.jupiter.api.Test
	void test() {
		AvlTree avlTree = new AvlTree();
		int[] testcase_1= {10, 5, 4, 11, 15, 16, 17, 3, 2, 9, 8, 7};
		int[] testcase_2= {2, 5, 9, 14, 13, 17, 6};
		test(testcase_1, avlTree); avlTree.makeEmpty();
		test(testcase_2, avlTree); avlTree.makeEmpty();
	}
	
	@DisplayName("�ǤJ�}�C�Ѽ�")
	void test(int[] testcase, AvlTree t) {
		assertEquals(true, t.isEmpty());	//�ˬd�O�_����
		assertEquals(0, t.countNodes());	//�ˬd node �ƶq
		assertEquals("", t.inorder());	//�ˬd in-order
		
		for (int i=0; i<testcase.length; i++) {
			t.insert(testcase[i]);
			assertEquals(i+1, t.countNodes());	//�ˬd node �ƶq
			assertEquals(false, t.isEmpty());	//�ˬd�O�_����
			//�ˬd in-order
			int[] tmp = new int[i+1];
			System.arraycopy(testcase, 0, tmp, 0, i+1);
			Arrays.sort(tmp);
			String[] sorted_testcase = new String[i+1];
			for (int j=0; j<=i; j++) {
				sorted_testcase[j] = Integer.toString(tmp[j]);
			}
			String inorder_str = String.join(" ", sorted_testcase);
			assertEquals(inorder_str, t.inorder());	
			//�ˬdsearch
			for (int j=0; j<testcase.length; j++) {
				if(j<=i) {
					assertEquals(true, t.search(testcase[j]));
				}
				else {
					assertEquals(false, t.search(testcase[j]));
				}
			}
		}
	}
	
	
}
