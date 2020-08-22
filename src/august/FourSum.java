package august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：yl
 * @description：四数相加
 * @date ：2020/8/22 20:57
 */
public class  FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        /*Arrays.sort(nums);
        List<List<Integer>> tripletSums=new ArrayList<>();
        if (nums.length < 4){
            return tripletSums;
        }
        if (nums.length == 4 && nums[0] + nums [1] + nums[2] + nums[3] ==target){
            List result = new ArrayList();
            result.add(nums[0]);
            result.add(nums[1]);
            result.add(nums[2]);
            result.add(nums[3]);
            tripletSums.add(result);
            return tripletSums;
        }else if (nums.length == 4){
            return tripletSums;
        }
        for (int i = 0; i < nums.length; i++) {
            int cur = target - nums[i];
            if (i > 0 && cur == target-nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length ; j++) {
                int cur2 = cur - nums[j];
                if (j > i+1 && cur2==cur - nums[j-1]){
                    continue;
                }
                int k = j+1;
                int l = nums.length - 1;
                while (k<l){
                    if (nums[j]+nums[k]+nums[i]+nums[l]== target){
                        List result = new ArrayList();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        result.add(nums[l]);
                        tripletSums.add(result);
                        k++;
                        l--;
                        while (k<l && nums[k] == nums[k-1]){
                            k++;
                        }
                        while (l > k && nums[l] == nums [l+1]){
                            l--;
                        }
                    }else if (nums[k] + nums[l] > cur2){
                        l--;
                    }else {
                        k++;
                    }
                }
            }
        }
        return tripletSums;*/
        //
        /*定义一个返回值*/
        List<List<Integer>> result=new ArrayList<>();
        /*当数组为null或元素小于4个时，直接返回*/
        if(nums==null||nums.length<4){
            return result;
        }
        /*对数组进行从小到大排序*/
        Arrays.sort(nums);
        /*数组长度*/
        int length=nums.length;
        /*定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值*/
        for(int k=0;k<length-3;k++){
            /*当k的值与前面的值相等时忽略*/
            if(k>0&&nums[k]==nums[k-1]){
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1=nums[k]+nums[k+1]+nums[k+2]+nums[k+3];
            if(min1>target){
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1=nums[k]+nums[length-1]+nums[length-2]+nums[length-3];
            if(max1<target){
                continue;
            }
            /*第二层循环i，初始值指向k+1*/
            for(int i=k+1;i<length-2;i++){
                /*当i的值与前面的值相等时忽略*/
                if(i>k+1&&nums[i]==nums[i-1]){
                    continue;
                }
                /*定义指针j指向i+1*/
                int j=i+1;
                /*定义指针h指向数组末尾*/
                int h=length-1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略*/
                int min=nums[k]+nums[i]+nums[j]+nums[j+1];
                if(min>target){
                    continue;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max=nums[k]+nums[i]+nums[h]+nums[h-1];
                if(max<target){
                    continue;
                }
                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
                while (j<h){
                    int curr=nums[k]+nums[i]+nums[j]+nums[h];
                    if(curr==target){
                        result.add(Arrays.asList(nums[k],nums[i],nums[j],nums[h]));
                        j++;
                        while(j<h&&nums[j]==nums[j-1]){
                            j++;
                        }
                        h--;
                        while(j<h&&i<h&&nums[h]==nums[h+1]){
                            h--;
                        }
                    }else if(curr>target){
                        h--;
                    }else {
                        j++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{-3,-2,-1,0,0,1,2,3};
        fourSum(nums,0);
    }
}
