int getMiddle(ListNode head)
{
    int length = 0;
    ListNode dummy = head;

    while(dummy != null)
    {
        length++;
        dummy = dummy.next;
    }

    for(int i = 0; i < length/2; i++)
    {
        head = head.next;
    }

    return head;
}

int getMiddleRec(ListNode head)
{
    ListNode slow = head;
    ListNode fast = head;

    while(fast != null && fast.next != null)
    {
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
}

boolean hasCycle(ListNode head)
{
    ListNode slow = head;
    ListNode fast = head;

    while(fast != null && fast.next != null)
    {
        slow = slow.next;
        fast = fast.next;

        if(fast == slow) return true;;
    }

    return false;

}

public boolean detectCycle(ListNode head)
{
    Set<ListNode> seen = new HashSet<ListNode>();

    while(head != null)
    {
        if(seen.contains(head)) return true;

        seen.add(head);
        head = head.next;
    }

    return false;
}

public ListNode findNode(ListNode head, int k)
{
    ListNode slow = head;
    ListNode fast = head;

    for(int i = 0; i < k; i++)
    {
        fast = fast.next;
    }

    while(fast != null)
    {
        slow = slow.next;
        fast = fast.next;
    }

    return slow;
}