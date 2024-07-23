// Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

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
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode current = head;
        ListNode prev = null;
        
        Set<Integer> seen = new HashSet<Integer>();
        
        while(current != null)
        {
            int currVal = current.val;
                       
            if(seen.contains(currVal))
            {
                prev.next = current.next;
            }
            else
            {
                seen.add(currVal);
                prev = current;
            }
            
            current = current.next;
        }
        
        return head;
    }
}