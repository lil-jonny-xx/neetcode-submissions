public class Solution 
{
    public int carFleet(int target, int[] position, int[] speed) 
    {

        int n = position.length;

        int[][] pair = new int[n][2];

        for (int i = 0; i < n; i++) 
        {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        // Sort by position in descending order
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        int fleets = 0;
        double lastFleetTime = 0;

        for (int i = 0; i < n; i++) 
        {

            double currentTime = (double) (target - pair[i][0]) / pair[i][1];

            // Can't catch the fleet ahead
            if (currentTime > lastFleetTime) 
            {
                fleets++;
                lastFleetTime = currentTime;
            }
        }

        return fleets;
    }
}