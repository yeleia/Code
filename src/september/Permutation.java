package september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：yl
 * @description：全排列，回溯算法
 * @date ：2020/9/14 21:26
 */
public class Permutation {
    private static List<String> result = new ArrayList<>();
    private static List<Integer> nums = Arrays.asList(1,2,3);
    public static void permutation(List<Integer> selectedNums,List<Integer> selectableNyms){
        //满足条件，加入结果集
        if (selectedNums.size()==nums.size()){
            result.add(Arrays.toString(selectedNums.toArray()));
            return;
        }
        for (int i = 0; i < selectableNyms.size() ; i++) {
            Integer num = selectableNyms.get(i);
            //去掉不符合条件的解，减枝
            if (selectedNums.contains(num)){
                continue;
            }
            //选择当前阶段其中的一个解
            selectedNums.add(num);
            //选完之后再进入下个阶段遍历
            permutation(selectedNums,selectableNyms);
            //回溯，换一个解继续遍历
            selectedNums.remove(num);
        }
    }

    public static void main(String[] args) {
        List<Integer> selectNums = new ArrayList<>();
        permutation(selectNums,nums);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
