package com.jsj.leetcode.important;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jsj
 * @since 2018-11-20
 * 题目描述：给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int z, high = nums.length-1, x = 0; x < nums.length - 1; x++) {
            if (x > 0 && nums[x] == nums[x - 1]) continue;
            for (int y = x + 1; y < high; y++) {
                if (y > x + 1 && nums[y] == nums[y - 1]) continue;
                z = binarySearch(nums, y + 1, nums.length, -1 * (nums[x] + nums[y]));
                if (z > -1) {
                    res.add(Arrays.asList(nums[x], nums[y], nums[z]));
                    high = z;
                }
            }
        }
        return res;
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        high--;
        int val =-1;
        for (int mid; low <= high; ) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                val=mid;
                break;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return val>-1?val:-1;
    }

    public static void main(String[] args) {
        List<List<Integer>>lists = new Solution15().threeSum(new int[]{-1,0,1,2,-1,-4});
        for (List<Integer> list:lists){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
