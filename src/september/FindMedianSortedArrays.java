package september;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：yl
 * @description：寻找两个正序数组的中位数
 * @date ：2020/9/10 20:23
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int nums1[] = new int[]{1,3,5};
        int nums2[] = new int[]{};
        System.out.println(findMedianSortedArrays1(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Map<Integer,Integer> indexMap = new HashMap<>();
        int index1 = 0;
        int index2 = 0;
        int tempIndex = 0;
        int len  = nums1.length + nums2.length;
        if (len == 0){
            return 0;
        }
        while (tempIndex < len){
            if (index1 == nums1.length){
                while (index2 < nums2.length){
                    indexMap.put(tempIndex,nums2[index2]);
                    tempIndex++;
                    index2 ++;
                }
                break;
            }
            if (index2 == nums2.length){
                while (index1 < nums1.length){
                    indexMap.put(tempIndex,nums1[index1]);
                    tempIndex ++;
                    index1 ++;
                }
                break;
            }
            if (nums1[index1] >= nums2[index2]){
                indexMap.put(tempIndex,nums2[index2]);
                tempIndex ++;
                index2 ++;
            }else {
                indexMap.put(tempIndex,nums1[index1]);
                tempIndex ++;
                index1 ++;
            }
        }
        if (len % 2 == 0){
            int num1 = indexMap.get(len / 2 - 1);
            int num2 = indexMap.get(len / 2);
            return (num1 + num2) / 2.0;
        }else {
            return indexMap.get(len/2);
        }
    }
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] newnums = new int[length];

        int index1 = 0;
        int index2 = 0;
        int currrent = 0;

        while (index1 < nums1.length || index2 < nums2.length) {
            if (index2 >= nums2.length) {
                newnums[currrent++] = nums1[index1++];
                continue;
            }

            if (index1 >= nums1.length ) {
                newnums[currrent++] = nums2[index2++];
                continue;
            }

            if (nums1[index1] <= nums2[index2]  ) {
                newnums[currrent++] = nums1[index1++];
            } else if (nums1[index1] > nums2[index2]) {
                newnums[currrent++] = nums2[index2++];
            }
        }

        if (newnums.length % 2 == 0) {
            return ((double)(newnums[length /2] + newnums[length / 2 - 1])) / 2;
        } else {
            return ((double)newnums[length / 2]);
        }


    }


}
