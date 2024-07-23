// Level: Medium. 881. Boats to save people

/*
 * You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)

Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)

 */

class Solution {
    public int numRescueBoats(int[] people, int limit) {

        int i = 0;

        int j = people.length-1;

        int count = 0;

        Arrays.sort(people);

        while(i <= j)
        {
            int x = people[i];

            int y = people[j];

            if(x + y <= limit)
            {
                count++;
                i++;
                j--;
            }

            if(x + y > limit)
            {
                count++;
                j--;
            }
        }

        return count;
        
    }
}