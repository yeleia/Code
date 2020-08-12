package august;

/**
 * @author ：yl
 * @description：26. 删除排序数组中的重复项
 * @date ：2020/8/12 21:20
 */
public class RemoveDup {
    /**
     * @author: yl
     * @description: 双指针法，快慢指针
     * @date: 2020/8/12 22:17
     * @param nums
     * @return int
     */
    public static int removeDuplicates(int[] nums){
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] == nums[j]){
                continue;
            }
            nums[++i] = nums[j];
        }
        return i + 1;
    }
    public static int removeDuplicate02(int nums[]){
        int count = 0;
        for (int i = 1;i < nums.length; i++){
            if (nums[i] == nums[i-1]){
                ++count;
            }else {
                nums[i-count] = nums[i];
            }
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicate02(nums));
    }
}
