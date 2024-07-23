PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

heap.add(1);
heap.add(2);
heap.add(3);

heap.peek();

heap.remove();

heap.size();

PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());

public class Example
{
    public static void main(String[] args)
    {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        int[] nums = {67, 341, 234, -67, 12, -976};

        for(int num: nums) heap.add(num);

        heap.add(7451);
        heap.add(-5352);

        while(!heap.isEmpty())
        {
            System.out.println(heap.remove());
        }
    }
}