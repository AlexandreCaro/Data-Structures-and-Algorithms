// Level: Medium. 198. House robber

//Dynamic Programming solution: top-down

class Solution {

    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int rob(int[] nums) {

        return dp(nums.length-1, nums);
    }

    public int dp(int i, int[] nums)
    {
        if(i == 0) return nums[0];

        if(i==1) return Math.max(nums[0], nums[i]);

        if(memo.containsKey(i)) return memo.get(i);

        memo.put(i, Math.max(dp(i-1, nums), dp(i-2, nums) + nums[i]));

        return memo.get(i);
    }

}

// Dynamic Programming solution: bottom-up

class Solution {


    public int rob(int[] nums) {

        if(nums.length == 1) return nums[0];

        int n = nums.length;

        int[] dp = new int[n];

        dp[0] = nums[0];

        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++)
        {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[n-1];
    }

}

// Dynamic Programming, bottom up approach with two variables instead of an array

class Solution {


    public int rob(int[] nums) {

        int n = nums.length;

        if(n == 1) return nums[0];

        int backTwo = nums[0];
        int backOne = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++)
        {
            int temp = backOne;
            backOne = Math.max(backOne, backTwo + nums[i]);
            backTwo = temp;
        }

        return backOne;
    }

}



// 43/70 test cases passed. Tried with maxHeap instead of DP

class Solution {
    public int rob(int[] nums) {

        boolean[] arr = new boolean[nums.length];
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(new PairComparator());

        for(int i = 0; i < nums.length; i++)
        {
            Pair newPair = new Pair(i, nums[i], true);

            maxHeap.offer(newPair);

            arr[i] = true;
        }

        int sum = 0;

        while(maxHeap.size() > 0)
        {
            Pair current = compareAndRemoveTop(maxHeap, arr);

            if(current == null) break;

            System.out.println(current.index + " " + current.value);

            sum += current.value;
        }

        return sum;
    }

    public static Pair compareAndRemoveTop(PriorityQueue<Pair> maxHeap, boolean[] arr)
    {
        if(maxHeap.size() < 1) return null;

        Pair pair1 = maxHeap.poll();

        if(arr[pair1.index] == false)
        {
            pair1 = compareAndRemoveTop(maxHeap, arr);
        }
        else
        {
            arr[Math.min(pair1.index+1, arr.length-1)] = false;
            arr[Math.max(pair1.index-1, 0)] = false;
        }
        
        return pair1;



        /*
        Pair pair2 = maxHeap.poll();

        if(Math.abs(pair2.index - pair1.index) <= 1)
        {
            maxHeap.offer(pair1);
            pair2.valid = false;
            arr[pair1.index] 
        }

        else
        {
            if(pair1.valid == true && pair2.valid == true)
            {
                maxHeap.offer(pair1);
                maxHeap.offer(pair2);
            }

            else if(pair1.valid == true) maxHeap.offer(pair1);

            else if(pair2.valid==true) maxHeap.offer(pair2);
            
        }
        */
    }

    class Pair
    {
        int index;
        int value;
        boolean valid;

        Pair(int index, int value, boolean valid)
        {
            this.index = index;
            this.value = value;
            this.valid = valid;
        }

    }

    class PairComparator implements Comparator<Pair>
    {
        @Override
        public int compare(Pair pair1, Pair pair2)
        {
            return Integer.compare(pair2.value, pair1.value);
        }
    }

}

