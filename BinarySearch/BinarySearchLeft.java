public int binarySearchLeft(int[] arr, int target)
{
    int left = 0;

    int right = arr.length - 1;

    while(left < right)
    {
        int mid = left + (right - left) / 2;

        if(arr[mid] >= target) right = mid;

        else left = mid+1;
    }

    return left;
}

public int binarySearchRight(int[] arr, int target)
{
    int left = 0;

    int right = arr.length - 1;

    while(left < right)
    {
        int mid = left + (right - left) / 2;

        if(arr[mid] > target) right = mid;

        else left = mid + 1;
    }

    return left;
}
// To find the leftmost index of insertion point:

public int binarySearchIndex(int[] arr, int target)
{
    int left = 0;

    int right = arr.length - 1;

    while(left <= right)
    {
        int mid = left + (right - left) / 2;

        if(arr[mid] < target) left = mid + 1;

        else right = mid - 1;
    }

    return left;
}