/* Level: Medium. 2126: Destroying asteoroids

 * You are given an integer mass, which represents the original mass of a planet. You are further given an integer array asteroids, where asteroids[i] is the mass of the ith asteroid.

You can arrange for the planet to collide with the asteroids in any arbitrary order. If the mass of the planet is greater than or equal to the mass of the asteroid, the asteroid is destroyed and the planet gains the mass of the asteroid. Otherwise, the planet is destroyed.

Return true if all asteroids can be destroyed. Otherwise, return false.

 

Example 1:

Input: mass = 10, asteroids = [3,9,19,5,21]
Output: true
Explanation: One way to order the asteroids is [9,19,5,3,21]:
- The planet collides with the asteroid with a mass of 9. New planet mass: 10 + 9 = 19
- The planet collides with the asteroid with a mass of 19. New planet mass: 19 + 19 = 38
- The planet collides with the asteroid with a mass of 5. New planet mass: 38 + 5 = 43
- The planet collides with the asteroid with a mass of 3. New planet mass: 43 + 3 = 46
- The planet collides with the asteroid with a mass of 21. New planet mass: 46 + 21 = 67
All asteroids are destroyed.

 */

 class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        
        Arrays.sort(asteroids);

        long currMass = mass;

        for(int asteroid: asteroids)
        {
            if(asteroid > currMass) return false;

            currMass += asteroid;
        }

        return true;

    }
}

 // Attemp 1: 45/74 solutions

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for(int asteroid: asteroids)
        {
            maxHeap.add(asteroid);
        }

        int maximum = maxHeap.poll();

        int currSum = mass + calculateSum(maxHeap);

        // System.out.println(maximum + " " + currSum);

        if(maximum > currSum) return false;

        while(maximum <= currSum)
        {
            if(maxHeap.peek() == null) break;

            maximum = maxHeap.poll();

            currSum = mass + calculateSum(maxHeap);

            if(maximum > currSum) return false;

        }

        return true;

    }

    public int calculateSum(PriorityQueue<Integer> maxHeap)
    {
        int sum = 0;

        for(int element: maxHeap)
        {
            sum += element;
        }

        return sum;
    }
}

// Attemps 2: 65/74 solutions

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for(int asteroid: asteroids)
        {
            maxHeap.add(asteroid);
        }

        int maximum = maxHeap.poll();

        int currSum = mass + calculateSum(maxHeap);

        // System.out.println(maximum + " " + currSum);

        if(maximum > currSum) return false;

        while(maximum <= currSum)
        {
            if(maxHeap.peek() == null) break;

            maximum = maxHeap.poll();

            currSum = currSum - maximum;

            if(maximum > currSum) return false;

        }

        return true;

    }

    public int calculateSum(PriorityQueue<Integer> maxHeap)
    {
        int sum = 0;

        for(int element: maxHeap)
        {
            sum += element;
        }

        return sum;
    }
}