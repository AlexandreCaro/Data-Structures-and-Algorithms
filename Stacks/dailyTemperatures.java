class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> stack = new Stack<Integer>();

        int len = temperatures.length;

        int[] answer = new int[len];

        for(int i = 0; i < len; i++)
        {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i])
            {
                int j = stack.pop();
                answer[j] = i -j;
            }

            stack.push(i);
        }
        
        return answer;
    }
}