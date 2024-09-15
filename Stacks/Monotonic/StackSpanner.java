// Level: Medium. 901. Online Stock Span

// Solution:

/*
 * Runtime
28ms
Beats91.26%
 */

class StockSpanner {

    Stack<Stock> stack;
    int index;

    public StockSpanner() {

        stack = new Stack<>();
        index = 0;

    }
    
    public int next(int price) {

        Stock stock = new Stock(price, 1);

        while(!stack.isEmpty() && stack.peek().getPrice() <= price)
        {
            Stock element = stack.pop();
            stock.span += element.span;
        }

        stack.push(stock);

        return stock.getSpan();
    }


}

class Stock
{
    int price;
    int span;

    Stock(int price, int span)
    {
        this.price = price;
        this.span = span;
    }

    public int getPrice()
    {
        return this.price;
    }

    public int getSpan()
    {
        return this.span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

// Test cases 86/99 passed

class StockSpanner {

    Stack<Integer> stack;
    Stack<Integer> previous;
    int index;

    public StockSpanner() {

        stack = new Stack<>();
        previous = new Stack<>();
        index = 0;

    }
    
    public int next(int price) {
        
        stack.push(price);

        int count = 1;

        // System.out.println(index);

        boolean change = false;

        while(!previous.isEmpty() && previous.peek() <= price)
        {
            change = true;
            previous.pop();
            count++;
        }


        if(!change)
        {
            previous.push(price);
        }
        else previous = copyStackManually(stack);
        

        //printStack(stack);

        //System.out.println("AFTER");

        //printStack(previous);
     
        index++;

        return count;
    }

    public Stack<Integer> copyStackManually(Stack<Integer> originalStack)
    {
        Stack<Integer> tempStack = new Stack<>();
        Stack<Integer> copyStack = new Stack<>();

        while(!originalStack.isEmpty())
        {
            tempStack.push(originalStack.pop());
        }

        while(!tempStack.isEmpty())
        {
            Integer element = tempStack.pop();
            originalStack.push(element);
            copyStack.push(element);
        }

        return copyStack;
    }

    public void printStack(Stack<Integer> original)
    {
        Stack<Integer> temp = copyStackManually(original);

        while(!temp.isEmpty())
        {
            System.out.println(temp.pop());
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

/*
 * Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.

    For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
    Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.

Implement the StockSpanner class:

    StockSpanner() Initializes the object of the class.
    int next(int price) Returns the span of the stock's price given that today's price is price.

Example 1:

Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6

Constraints:

    1 <= price <= 105
    At most 104 calls will be made to next.


 */