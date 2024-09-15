/*
 * 

    Example 2: You are on a street with street lights, represented by an array lights. Each light is given as [position, radius], which means that the light is located at position, and shines to the left and right at a distance of radius. Let's say the brightest spot on the street is the spot where the most lights are shining. Return any such position.

    Note that the street is extremely long - position <= 10^18.

 */

// It's a difference array approach adapted to the case where the data is potentially very large(we use a list to report all the changes that happen)

public int findBrightestPosition(int[][] lights)
{
    List<int[]> change = new ArrayList<>();

    for(int i = 0; i < lights.length, i++)
    {
        int position = lights[i][0], radius = lights[i][1];
        change.add(new int[]{position - radius, +1});
        change.add(new int[]{position + radius + 1, -1});
    }

    Collections.sort(change, (a,b)-> Integer.compare(a[0], b[0]));

    int ans = 0;
    int curr = 0;
    int brightest = 0;

    for(int i = 0; i < change.size(); i++)
    {
        int position = change.get(i)[0], value = change.get(i)[1];

        curr+= value;

        if(curr > brightest)
        {
            brightest = curr;
            ans = position;
        }
    }

    return ans;
}