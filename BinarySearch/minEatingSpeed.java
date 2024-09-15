// Level: Medium. 875. Koko eating bananas

/*
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23


 */

// Leetcode solution

class Solution {

    int limit;

    public int minEatingSpeed(int[] piles, int h) {

        limit = h;

        int left = 1;

        int right = 0;

        for(int banana: piles)
        {
            right = Math.max(right, banana);
        }

        while(left <= right)
        {
            int mid = left + (right - left)/2;

            if(check(piles, mid))
            {
                right = mid-1;
            }
            else
            {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean check(int[] piles, double speed)
    {
        double hours = 0;

        for(int pile: piles)
        {
            hours += Math.ceil(pile/speed);
        }

        return hours <= limit;
    }
}

// My solution

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;

        int max = Arrays.stream(piles).max().getAsInt();

        int n = piles.length;

        int right = max;

        while(left < right)
        {
            int mid = left + (right - left)/2;

            if(canEatAll(piles, mid, h))
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean canEatAll(int[] piles, int speed, int h)
    {
        int time = 0;

        for(int pile: piles)
        {

            // System.out.println(piles[i] + " " + rate);

            time += (pile - 1)/speed + 1;

            if(time > h) return false;
        }

        return true;
    }
}