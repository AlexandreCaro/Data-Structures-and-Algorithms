public int binarySearch(int[] arr, int target)
{
    int left = 0;

    int right = arr.length - 1;

    while(left <= right)
    {
        int mid = left + (right - left) / 2;

        if(arr[mid] == target)
        {
            return mid;
        }
        else if(arr[mid] < target)
        {
            mid = right-1;
        }
        else if(arr[mid] > target)
        {
            mid = left + 1;
        }
    }

    return left;
}