package september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @author ：yl
 * @description：组合总数和
 * @date ：2020/9/13 20:26
 */

public class CombinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> selectable = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> selected = new ArrayList<>();
        back(selected,selectable,k,n,result);
        return result;
    }
    public static void back(List<Integer> selected,List<Integer> selectable,int k,int n,List<List<Integer>> result){
        int sum = selected.stream().mapToInt(Integer::intValue).sum();
        if (selected.size() == k && sum == n ) {
            result.add(new ArrayList<Integer>(selected));
            return;
        }
        if (selected.size() == k){
            return;
        }
        for (int i = 0; i < selectable.size() ; i++) {
            if (selected.contains(selectable.get(i))){
                continue;
            }
            if (selected.size() > 0 && selected.get(selected.size()-1) > selectable.get(i)){
                continue;
            }
            selected.add(selectable.get(i));
            back(selected,selectable,k,n,result);
            selected.remove(selectable.get(i));
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        result = combinationSum3(0,0);
        System.out.println(result.toArray());
    }
}
