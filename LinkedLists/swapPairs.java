// Level: Medium. 24. Swap Nodes in Pairs.

/*
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:

Input: head = [1,2,3,4]
Output: [2,1,4,3]

 */

// My solution.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        if(head == null) return head;

        ListNode curr = head;
        ListNode nextCurr = head.next;

        if(nextCurr == null) return head;

        while(nextCurr != null)
        {
            int temp = curr.val;
            curr.val = nextCurr.val;
            nextCurr.val = temp;

            curr = curr.next.next;
            nextCurr = nextCurr.next.next;

            if(curr.next == null) break;

            if(nextCurr.next == null) break;
        }

        return head;
        
    }
}

// Solution:

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode dummy = head.next;
        ListNode prev = null;

        while(head != null && head.next != null)
        {
            if(prev != null) prev.next = head.next;

            prev = head;

            ListNode nextNode = head.next.next;
            head.next.next = head;

            head.next = nextNode;
            head = nextNode;
        }

        return dummy;
        
    }
}