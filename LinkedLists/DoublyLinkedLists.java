class ListNode
{
    int val;
    ListNode prev;
    List next;
    ListNode(int val)
    {
        this.val = val;
    }
}

void addNode(ListNode node, ListNode nodeToAdd)
{
    ListNode prevNode = node.prev;
    nodeToAdd.next = node;

    nodeToAdd.prev = prevNode;
    prevNode.next = nodeToAdd;

    node.prev = nodeToAdd;
}

void deleteNode(ListNode node)
{
    ListNode prevNode = node.prev;
    ListNode nextNode = node.next;
    prevNode.next = nextNode;
    nextNode.prev= prevNode;
}
