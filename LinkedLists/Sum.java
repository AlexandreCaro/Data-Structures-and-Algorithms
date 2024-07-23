public static class ListNode
    {
        int val;
        ListNode next;
        ListNode(int val)
        {
            this.val = val;
        }
    }

int getSum(ListNode head)
{
    int ans = 0;

    while(head != null)
    {
        ans += head.val;
        head = head.next;
    }

    return ans;
}

int getSumRec(ListNode head)
{
    if(head == null) return 0;

    return head.val + getSumRec(head.next);
}

void addNode(ListNode prevNode, ListNode nodeToAdd)
{
    nodeToAdd.next = prevNode.next;
    prevNode.next = nodeToAdd;
}

void deleteNode(ListNode prevNode)
{
    prevNode.next = prevNode.next.next;
}