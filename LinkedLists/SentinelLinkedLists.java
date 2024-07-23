class ListNode
{
    int val;
    ListNode prev;
    ListNode next;

    ListNode(int val)
    {
        this.val = val;
    }
}

void addToEnd(ListNode nodeToAdd)
{
    nodeToAdd.next = tail;
    nodeToAdd.prev = tail.prev;
    tail.prev.next = nodeToAdd;
    tail.prev = nodeToAdd;
}

void removeFromEnd()
{
    if(head.next == tail) return;

    ListNode nodeToRemove = tail.prev;
    nodeToRemove.prev.next = tail;
    tail.prev = nodeToRemove.prev;
}

void addToStart(ListNode nodeToAdd)
{
    nodeToAdd.prev = head;
    nodeToAdd.next = head.next;
    head.next.prev = nodeToAdd;
    head.next = nodeToAdd;
}

void removeFromStart()
{

    if(head.next == tail) return;

    ListNode nodeToRemove = head.next;
    nodeToRemove.next.prev = head;
    head.next = nodeToRemove.next;

}

int getSum(ListNode head)
{
    int ans = 0;
    ListNode dummy = head;

    while(dummy != null)
    {
        ans += dummy.val;
        dummy = dummy.next;
    }

    return ans;
}

ListNode head = new ListNode(-1);
ListNode tail = new ListNode(-1);
head.next = tail;
tail.prev = head;