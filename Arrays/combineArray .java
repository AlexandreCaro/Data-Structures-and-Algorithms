public List<Integer> combineArray(int[] arr1, int[] arr2)
{
    List<Integer> ans = new ArrayList<Integer>();

    int i = j = 0;

    while(i < arr1.length && j < arr2.length)
    {
        if(arr1[i] < arr2[j])
        {
            ans.add(arr1[i]);
            i++;
        } else {
            ans.add(arr2[j]);
            j++;
        }
    }

    while(i < arr1.length)
    {
        ans.add(arr1[i]);
        i++;
    }

    while(j < arr2.length)
    {
        ans.add(arr2[j]);
        j++;
    }

    return ans;
}