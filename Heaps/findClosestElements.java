// Level: Medium. 658: Find K Closest Elements

/*
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

    |a - x| < |b - x|, or
    |a - x| == |b - x| and a < b

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]

 */

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> 
        {
            if(Math.abs(n1 - x) == Math.abs(n2-x)) return n2 - n1;

            else return Math.abs(n2-x) - Math.abs(n1-x);
        });
        
        for(int num: arr)
        {
            maxHeap.add(num);

            if(maxHeap.size() > k)
            {
                maxHeap.remove();
            }
        }

        List<Integer> ans = new LinkedList<>();

        for(int i = 0; i < k; i++)
        {
            ans.add(maxHeap.remove());
        }

        Collections.sort(ans);

        return ans;
    }
}