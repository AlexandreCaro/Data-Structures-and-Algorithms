// Level: Medium. 2342: Max Sum of a Pair with Equal Sum of Digits

/*
 * You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.

Example 1:

Input: nums = [18,43,36,13,7]
Output: 54
Explanation: The pairs (i, j) that satisfy the conditions are:
- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
So the maximum sum that we can obtain is 54.

Example 2:

Input: nums = [10,12,19,14]
Output: -1
Explanation: There are no two numbers that satisfy the conditions, so we return -1.

 

Constraints:

    1 <= nums.length <= 105
    1 <= nums[i] <= 109


 */

class Solution {

    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    public int maximumSum(int[] nums) {

        for(int i = 0; i < nums.length; i++)
        {
            int num = nums[i];

            int digit_sum = digitSum(num);

            if(!map.containsKey(digit_sum)) map.put(digit_sum, new ArrayList<>());

            map.get(digit_sum).add(num);

            // System.out.println(num + " " + digit_sum);
        }

        for(int digit_sum: map.keySet())
        {
            Collections.sort(map.get(digit_sum));
        }
        
        int maximum = 0;

        for(int digit_sum: map.keySet())
        {
            // System.out.println("ss " + digit_sum);

            ArrayList<Integer> current = map.get(digit_sum);

            if(current.size() >= 2)
            {
                int last = current.get(current.size()-1);
                int antepenutieme = current.get(current.size()-2);

                // System.out.println(last + " " + antepenutieme);

                if(maximum < last + antepenutieme) maximum = last + antepenutieme;
            }
        }

        if(maximum == 0) return -1;

        return maximum;

    }

    public int digitSum(int number)
    {
        int sum = 0;

        while(number > 0)
        {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}

// Better space complexity:

class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int maximumSum(int[] nums) {

        int ans = -1;

        for(int num: nums)
        {
            int digitSum = digitSum(num);

            if(map.containsKey(digitSum))
            {
                ans = Math.max(ans, num + map.get(digitSum));
            }

            map.put(digitSum, Math.max(map.getOrDefault(digitSum, 0), num));
        }

        return ans;

    }

    public int digitSum(int number)
    {
        int sum = 0;

        while(number > 0)
        {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}