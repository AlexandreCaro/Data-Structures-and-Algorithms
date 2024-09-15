class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {

        if(dist.length > Math.ceil(hour)) return -1;

        int left = 1;

        int right = (int) Math.pow(10, 7);

        while(left <= right)
        {
            int mid = left + (right - left) / 2;

            if(check(dist, mid, hour))
            {
                right = mid - 1;
            }
            else left = mid + 1;
        }

        return left;
        
    }

    public boolean check(int[] dist, int k, double hour)
    {
        double t = 0;

        for(double d: dist)
        {
            t = Math.ceil(t);
            t += d / k;
        }

        return t <= hour;
    }
}