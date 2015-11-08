/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
    	ListNode result = new ListNode(0);
    	ListNode current = result;
        while (l1 != null && l2 != null) {
        	int sum = l1.val + l2.val + carry;
        	int digit = sum % 10;
        	carry = sum / 10;
        	ListNode temp = current;
        	current = new ListNode(digit);
        	temp.next = current;
        	l1 = l1.next;
        	l2 = l2.next;
        }
        while (l1 != null) {
        	int sum = l1.val + carry;
        	int digit = sum % 10;
        	carry = sum / 10;
        	ListNode temp = current;
        	current = new ListNode(digit);
        	temp.next = current;
        	l1 = l1.next;
        }

        while (l2 != null) {
        	int sum = l2.val + carry;
        	int digit = sum % 10;
        	carry = sum / 10;
        	ListNode temp = current;
        	current = new ListNode(digit);
        	temp.next = current;
        	l2 = l2.next;
        }
        
        if (carry != 0) {
        	ListNode temp = current;
        	current = new ListNode(1);
        	temp.next = current;
        }
        return result.next;
    }
}