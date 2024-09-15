// Level: Medium. 347: Top K Frequent Elements

/*
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]

 */

 
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();

        PriorityQueue<Frequency> minHeap = new PriorityQueue<Frequency>(new FrequencyComparator());

        for(int num: nums)
        {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: counts.entrySet())
        {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            minHeap.add(new Frequency(value, key));

            if(minHeap.size() > k)
            {
                minHeap.remove();
            }
        }

        int[] ans = new int[k];

        int i = 0;

        for(Frequency item: minHeap)
        {
            // System.out.println(item.number);

            ans[i] = item.number;
            i++;
        }

        return ans;
    }

}

class Frequency
{
    int frequency;
    int number;

    Frequency(int frequency, int number)
    {
        this.frequency = frequency;
        this.number = number;
    }
}

class FrequencyComparator implements Comparator<Frequency>
{
    @Override
    public int compare(Frequency f1, Frequency f2)
    {
        return Integer.compare(f1.frequency, f2.frequency);
    }
}

// Leetcode solution

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2)-> counts.get(n1) - counts.get(n2));

        for(int num: nums)
        {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: counts.entrySet())
        {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            minHeap.add(key);

            if(minHeap.size() > k)
            {
                minHeap.remove();
            }
        }

        int[] ans = new int[k];

        int i = 0;

        for(Integer item: minHeap)
        {
            // System.out.println(item.number);

            ans[i] = item;
            i++;
        }

        return ans;
    }

}