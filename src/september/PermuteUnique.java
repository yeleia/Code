package september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：yl
 * @description：全排列2
 * @date ：2020/9/18 22:02
 */
public class PermuteUnique {
    private static List<List<Integer>> result = new ArrayList<>();
    private static Integer len ;
    private static Integer tempIndex = null;
    private static boolean mark = true;
    private static boolean[] isVisit;
    public static List<List<Integer>> permuteUnique(int[] nums) {
        /*len = nums.length;
        List<Integer> selected = new ArrayList<>();
        backTrack(selected,nums);*/
        isVisit = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,new ArrayList<>());
        return result;
    }
    public static void backTrack(List<Integer> selected, int[] selectable){
        if (selected.size() == len){
            if (!result.contains(selected)){
                result.add(selected);
            }
            tempIndex = null;
            mark = false;
            return;
        }
        for (int i = 0; i < selectable.length; i++) {
            if (tempIndex!= null && i <= tempIndex && mark){
               continue;
            }
            selected.add(selectable[i]);
            tempIndex = i;
            backTrack(selected,selectable);
            selected.remove(selectable[i]);
            mark = true;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        List<List<Integer>> ret = permuteUnique(nums);
        System.out.println(ret);

    }
    public static void dfs(int nums[],List<Integer> curList){
        if (curList.size() == nums.length){
            result.add(new ArrayList<>(curList));
            return;
        }
        for (int i = 0; i < nums.length ; i++) {
            if (!isVisit[i]){
                curList.add(nums[i]);
                isVisit[i] = true;
                dfs(nums,curList);
                isVisit[i] = false;
                curList.remove(curList.size() -1);
                while (i + 1 < nums.length &&nums[i+1] == nums[i]){
                    i++;
                }
                }
        }
    }
}
