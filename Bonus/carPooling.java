// Level: Medium. 1094: Car Pooling

/*
 * There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.

Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false

Example 2:

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true


 */

// My solution:

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int farthest = 0;

        for(int i = 0; i < trips.length; i++)
        {
            farthest += trips[i][2];
        }

        int[] arr = new int[farthest+1];

        int prev = 0;

        int curr = 0;

        int numPassengers = 0;

        for(int i = 0; i < trips.length; i++)
        {
            int from = trips[i][1];

            int to = trips[i][2];

            numPassengers = trips[i][0];

            for(int index = from; index < to; index++)
            {
                arr[index] += numPassengers;
            }

        }

        for(int i = 0; i < farthest + 1; i++)
        {
            // System.out.println(arr[i]);
            if(arr[i] > capacity) return false;
        }

        return true;
    }
}

// Other solution: Difference array

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int farthest = 0;

        for(int i = 0; i < trips.length; i++)
        {
            farthest = Math.max(farthest, trips[i][2]);
        }

        int[] arr = new int[farthest+1];

        for(int i = 0; i < trips.length; i++)
        {
            int value = trips[i][0], left = trips[i][1], right = trips[i][2];
            arr[left] += value;
            arr[right] -= value;
        }

        int curr = 0;

        for(int i = 0; i < farthest+1; i++)
        {
            curr += arr[i];
            if(curr > capacity) return false;
        }

        return true;
    }
}

