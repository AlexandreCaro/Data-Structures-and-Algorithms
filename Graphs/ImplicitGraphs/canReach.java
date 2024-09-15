// Level: Medium. 1306: Jump Game III

// 55/56 test cases passed

class Solution {

    Queue<Pair> queue = new LinkedList<>();

    boolean[] seen;
    int n;

    public boolean canReach(int[] arr, int start) {

        queue.add(new Pair(start, arr[start]));

        n = arr.length;

        int count = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            if(count > n) return false;

            for(int i = 0; i < size; i++)
            {
                Pair current = queue.remove();

                if(current.value == 0) return true;

                if(isValid(current.index, current.value))
                {
                    int newIndex = current.index + current.value;
                    queue.add(new Pair(newIndex, arr[newIndex]));
                }

                if(isValid(current.index, -1*current.value))
                {
                    int newIndex = current.index - current.value;
                    queue.add(new Pair(newIndex, arr[newIndex]));
                }
            }

            count++;
        }

        return false;

    }

    public boolean isValid(int index, int increment)
    {
        int nouveau = index + increment;

        return 0 <= nouveau && nouveau < n;
    }
}

class Pair
{
    int index;
    int value;

    Pair(int index, int value)
    {
        this.index = index;
        this.value = value;
    }
}

// My solution:

/*
 * Runtime
9ms
Beats40.07%
 */

class Solution {

    Queue<Pair> queue = new LinkedList<>();

    boolean[] seen;
    int n;

    public boolean canReach(int[] arr, int start) {

        queue.add(new Pair(start, arr[start]));

        n = arr.length;

        seen = new boolean[n];

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i = 0; i < size; i++)
            {
                Pair current = queue.remove();

                if(current.value == 0) return true;

                seen[current.index] = true;

                if(isValid(current.index, current.value) && !seen[current.index+current.value])
                {
                    int newIndex = current.index + current.value;
                    queue.add(new Pair(newIndex, arr[newIndex]));
                }

                if(isValid(current.index, -1*current.value) && !seen[current.index-current.value])
                {
                    int newIndex = current.index - current.value;
                    queue.add(new Pair(newIndex, arr[newIndex]));
                }

                
            }

        }

        return false;

    }

    public boolean isValid(int index, int increment)
    {
        int nouveau = index + increment;

        return 0 <= nouveau && nouveau < n;
    }
}

class Pair
{
    int index;
    int value;

    Pair(int index, int value)
    {
        this.index = index;
        this.value = value;
    }
}

/*
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.

Notice that you can not jump outside of the array at any time.

Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation: 
All possible ways to reach at index 3 with value 0 are: 
index 5 -> index 4 -> index 1 -> index 3 
index 5 -> index 6 -> index 4 -> index 1 -> index 3 

Example 2:

Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true 
Explanation: 
One possible way to reach at index 3 with value 0 is: 
index 0 -> index 4 -> index 1 -> index 3

Example 3:

Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.

 Constraints:

    1 <= arr.length <= 5 * 104
    0 <= arr[i] < arr.length
    0 <= start < arr.length


 */