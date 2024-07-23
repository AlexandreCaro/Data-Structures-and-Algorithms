// Level: medium. 1481: Least Number of Unique Integers after k removals

/*
 * Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.

Example 1:

Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.

Example 2:

Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2
Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.


 */

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();

        for(int num: arr)
        {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        List<Integer> ordered = new ArrayList<Integer>();

        for(int val: counts.values())
        {
            ordered.add(val);
        }

        Collections.sort(ordered, Comparator.reverseOrder());

        while(k > 0)
        {
            int val = ordered.get(ordered.size() - 1);

            if(val <= k)
            {
                k -= val;
                ordered.remove(ordered.size() - 1);
            } else
            {
                break;
            }

        }

        return ordered.size();
        
    }
}