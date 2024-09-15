// Level: Medium. 92. Reverse LinkedList 2.

// My Solution: 39/44 test cases pased

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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode curr = head;
        ListNode prev = null;

        int index = 1;

        if(left == right) return head;

        if(left == 1)
        {
            ListNode nextNode = null;
            
            while(curr != null && index <= right)
            {
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                index++;
            }

            if(curr == null) return prev;
            else
            {
                prev.next = nextNode;
                return prev;
            }
        }

        while(curr != null)
        {
            prev = curr;
            curr = curr.next;
            index++;

            if(index == left)
            {
                ListNode beforeBegin = prev;
                ListNode begin = curr;

                ListNode nextNode = null;
                // ListNode nextNode;
                
                while(curr != null && index <= right)
                {
                    nextNode = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = nextNode;
                    index++;

                    System.out.println(index);
                }
                beforeBegin.next = prev;
                begin.next = nextNode;
            }
        }

        return head;
    }
}

// 2nd attempt:

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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for(int i = 0; i < left - 1; i++)
        {
            prev = prev.next;
        }

        ListNode start = prev.next;
        ListNode then = start.next;

        for(int i = 0; i < right - left; i++)
        {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}