// Level: medium. 841: Keys and rooms

/*
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.

 

Example 1:

Input: rooms = [[1],[2],[3],[]]
Output: true
Explanation: 
We visit room 0 and pick up key 1.
We then visit room 1 and pick up key 2.
We then visit room 2 and pick up key 3.
We then visit room 3.
Since we were able to visit every room, we return true.

 */

class Solution {

    Set<Integer> seen = new HashSet<Integer>();

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        seen.add(0);

        dfs(0, rooms);

        return seen.size() == rooms.size();
    }

    public void dfs(int node, List<List<Integer>> rooms)
    {
        for(int neighbor: rooms.get(node))
        {
            if(!seen.contains(neighbor))
            {
                seen.add(neighbor);
                dfs(neighbor, rooms);
            }
        }
    }

    public boolean canVisitAllRoomsIterative(List<List<Integer>> rooms) {
        
        seen.add(0);

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(0);

        while(!stack.empty())
        {
            int node = stack.pop();

            for(int neighbor: rooms.get(node))
            {
                if(!seen.contains(neighbor))
                {
                    seen.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }

        return seen.size() == rooms.size();
    }
}