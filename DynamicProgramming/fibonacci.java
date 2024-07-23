// Recursive version

public int fibonacci(int n)
{
    if(n==0) return 0;

    if(n==1) return 1;

    return fibonacci(n-1) + fibonacci(n-2);
}

// Dynamic Programming: memoization with hashmap. Bottom-up approach

HashMap<Integer, Integer> memo = new HashMap<>();

public int MemoFibonacci(int n)
{
    if(n==0) return 0;

    if(n==1) return 1;

    if(memo.containsKey(n)) return memo.get(n);

    memo.put(n, fibonacci(n-1) + fibonacci(n-2));

    return memo.get(n);
}

// Bottom-up: iterative

public int bottomFibonacci(int n)
{
    int[] arr = new int[n]

    arr[1] = 1;

    for(int i = 2; i <= n; i++)
    {
        arr[i] = arr[i-1] + arr[i-2];
    }

    return arr;
}