public class Solution {
    public static int findDuplicate(int[] nums) {
        //using Tortoise & Hair algorithm by Donald Knuth to find cycle in a sequence.
        //This algorithm also called Floyd's cycele detection algorithm
        int n = nums.length;
        int tortoise = n;
        int hair = n;

       do{
            tortoise = nums[tortoise-1];
            hair = nums[nums[hair-1]-1];
        } while(hair != tortoise);

        //find the starting point of the cycle
        //int mu = 0;
        tortoise = n;
        while(hair != tortoise){
            tortoise = nums[tortoise-1];
            hair = nums[hair-1];
            //mu++;
        }

        return tortoise;
    }
}