// Level: Medium. 2260. Minimum Consecutive Cards to Pickup

/*
 * You are given an integer array cards where cards[i] represents the value of the ith card. A pair of cards are matching if the cards have the same value.

Return the minimum number of consecutive cards you have to pick up to have a pair of matching cards among the picked cards. If it is impossible to have matching cards, return -1.

Example 1:

Input: cards = [3,4,2,3,4,7]
Output: 4
Explanation: We can pick up the cards [3,4,2,3] which contain a matching pair of cards with value 3. Note that picking up the cards [4,2,3,4] is also optimal.

Example 2:

Input: cards = [1,0,5,3]
Output: -1
Explanation: There is no way to pick up a set of consecutive cards that contain a pair of matching cards.

 

Constraints:

    1 <= cards.length <= 105
    0 <= cards[i] <= 106


 */

import java.util.Collection;

class Solution {

    HashMap<Integer, List<Integer>> map = new HashMap<>();

    public int minimumCardPickup(int[] cards) {
        
        for(int i = 0; i < cards.length; i++)
        {
            if(!map.containsKey(cards[i]))
            {
                map.put(cards[i], new ArrayList<>());
            }

            map.get(cards[i]).add(i);
        }

        int minimum = Integer.MAX_VALUE;

        Collection<List<Integer>> values = map.values();

        for(List<Integer> value: values)
        {
            for(int i = 1; i < value.size(); i++)
            {
                Integer previous = value.get(i-1);
                Integer element = value.get(i);

                Integer difference = element - previous;

                System.out.println(difference);

                if(minimum > difference) minimum = difference;

            }
        }

        if(minimum == Integer.MAX_VALUE) return -1;

        return minimum + 1;
        }
    }
