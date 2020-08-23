package august;

import java.util.*;

/**
 * @author ：yl
 * @description： 前 K 个高频元素
 * @date ：2020/8/22 23:08
 */
public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        int length = nums.length - 1;
        Arrays.sort(nums);
        Map temp = new HashMap();
        int count = 1;
        for (int i = 0; i <= length ; i++) {
            if (i>  0&& i < length && nums[i] == nums[i+1]){
                count++;
                continue;
            }else {
                temp.put(nums[i],count++);
                count = 1;
            }

        }
        List<HashMap.Entry<Integer, Integer>> list = new ArrayList(temp.entrySet());
        Collections.sort(list, (o1, o2) -> {
            return o2.getValue() - o1.getValue(); //这里是从大到小进行排序，如果需从小到大进行排序则将o1和o2互换即可
        });
        int result[] = new int[k];
        for (int i = 0; i < k ; i++) {
            result[i] = list.get(i).getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0};
        topKFrequent(nums,1);
    }
}
