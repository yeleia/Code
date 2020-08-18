package august;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：yl
 * @description：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * @date ：2020/8/18 22:42
 */
public class TwoSum {
    public static int[] findIndex(int[] nums,int target){
        int i = 1;
        int n = 0;
        int temp = nums[n];
            while (i < nums.length){
                if (target - temp == nums[i]){
                    return new int[]{n,i};
                }
                if (i == nums.length - 1){
                    temp = nums[++n];
                    i = n;
                }
                i++;
            }
        return null;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{3,2,4};
       int nums1[] = findIndex(nums,6);

    }
    /**
     * @author: yl
     * @description: hash法，空间换时间
     * @date: 2020/8/18 23:44
     * @param：nums[] nums，int target
     * @return int[]
     */
    public int[] twoSum(int nums[],int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)&&map.get(complement)!=i){
                return new int[]{i,map.get(complement)};
            }
        }
        throw null;
    }
}
