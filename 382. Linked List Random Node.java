/**
 * 382. Linked List Random Node
 * 随机数
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    private ListNode head;
	private long length;
	public Solution(ListNode head) {
		this.head = head;
		this.length = getLength();
	}

	/** Returns a random node's value. */
	public int getRandom() {
		Random r = new Random();
		long x = Math.abs(r.nextLong() % length);
		ListNode node = head;
		while(x!=0){
			node = node.next;
			x--;
		}
		return node.val;
	}
	
	private long getLength(){
		ListNode node = head;
		long len = 1;
		while (node.next != null) {
			len++;
			node = node.next;
		}
		return len;		
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */