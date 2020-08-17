package august;

/**
 * @author ：yl
 * @description：TODO
 * @date ：2020/8/13 21:23
 */
public class MaxArea {
    public static int maxArea(int[] nums){
        int i = 0;
        int j = nums.length - 1;
        int maxAre = 0;
        while (i < j){
            int tempArea = (j - i) * Math.min(nums[i],nums[j]);
            maxAre = Math.max(tempArea,maxAre);
            if (nums[i] < nums[j]){
                i++;
            }else {
                j--;
            }
        }
       return maxAre;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }
}
