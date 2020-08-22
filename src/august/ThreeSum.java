package august;

import java.util.*;

/**
 * @author ：yl
 * @description：TODO
 * @date ：2020/8/18 23:54
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> tripletSums=new ArrayList<>();
        if (nums.length == 0 ){
            return tripletSums;
        }
        if (nums.length >0 && nums[0] >0){
            return tripletSums;
        }
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i] ;
            if (i > 0 && cur == nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = nums.length -1;
            while (j < k){
                if (cur + nums[j] + nums[k] == 0){
                    List result = new ArrayList();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(nums[k]);
                    tripletSums.add(result);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                    while (k > j && nums[k] == nums[k+1]){
                        k--;
                    }
                }
               else if (nums[j] + nums[k] > -cur){
                   k--;
                }else {
                   j++;
                }

            }
        }
        return tripletSums;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }
}
