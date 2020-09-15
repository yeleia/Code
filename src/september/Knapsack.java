package september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：yl
 * @description：背包问题
 * @date ：2020/9/14 21:28
 */
public class Knapsack {
    //结果集
    private static Integer RESULT = 0;
    //背包的最大承载质量
    private static Integer KNAPSACK_MAX_WEIGHT = 10;
    //现有背包
    private static List<Integer> WEIGHTS = Arrays.asList(3,4,6,8);
    //遍历当前阶段的解
    public static void knapsack(List<Integer> selectedWeight,List<Integer> selectableWeight){
        //已选总重量
        int sumOfWeights = selectedWeight.stream().mapToInt(Integer::intValue).sum();
        if (sumOfWeights == KNAPSACK_MAX_WEIGHT){
            RESULT = Math.max(RESULT,sumOfWeights);
            return;
        }else if (sumOfWeights > KNAPSACK_MAX_WEIGHT){
            //如果已选物品的总重量超过背包的最大承受质量，则把最后一个选择的物品移除，再求质量和
            selectedWeight.remove(selectedWeight.size() - 1);
            sumOfWeights = selectedWeight.stream().mapToInt(Integer::intValue).sum();
            RESULT = Math.max(RESULT,sumOfWeights);
            }else {
            RESULT = Math.max(RESULT,sumOfWeights);
        }
        //遍历每个阶段的可选解集合
        for (int i = 0; i <selectableWeight.size() ; i++) {
            Integer num = selectableWeight.get(i);
            //去除不符合条件的解，减枝
            if (selectedWeight.contains(num)){
                continue;
            }
            //选择子节点的其中一个解
            selectedWeight.add(num);
            //选完之后进行dfs
            knapsack(selectedWeight,selectableWeight);
            //回溯，换个解再遍历
            selectedWeight.remove(num);
        }
    }

    public static void main(String[] args) {
        List<Integer> seletedNums = new ArrayList<>();
        knapsack(seletedNums,WEIGHTS);
        System.out.println("result:"+ RESULT);
    }
}
