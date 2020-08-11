package august;

/**
 * @author ：yl
 * @description：将0挪到数组后面
 * @date ：2020/8/11 22:03
 */
public class MoveZeroes {
    /**
     * @author: yl
     * @description: TODO
     * @date: 2020/8/11 22:14
     * @param nums
     * @return
     */
    public static void move1(int nums[]) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
    /**
     * @author: yl
     * @description: change
     * @date: 2020/8/11 22:18
     * @param nums
     * @return
     */
    public static void move2(int nums[]){
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,0,2,0,0,1};
        move1(nums);
    }
}
