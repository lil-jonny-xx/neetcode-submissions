class Solution 
{
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        int l = 0,r = 0;
        Deque<Integer> q = new LinkedList<>();
        int [] output = new int[nums.length-k+1];
        while(r<nums.length)
        {
            while(!q.isEmpty() && nums[q.getLast()]<nums[r])
                q.removeLast();
            q.addLast(r);
            if(l>q.getFirst())
                q.removeFirst();
            if((r+1)>=k)
            {
                output[l]=nums[q.getFirst()];
                l++;
            }
            r++;
        }
        return output;
    }
}
