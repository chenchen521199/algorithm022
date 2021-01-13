//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9821 👎 0


package work.twosum;

import java.util.HashMap;

//java:两数之和
public class P1TwoSum {
    public static void main(String[] args) {
        Solution solution = new P1TwoSum().new Solution();
        //测试用例
        int[] ints = solution.twoSum(new int[]{2, 11, 15, 9}, 13);
        for (int i :ints) System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一: 哈希表
     * 思路: 目标数 - 数组中第一个数(记录下标) = 数组中第二个数(取出记录下标);
     * 时间复杂度分析: O(n)
     * 空间复杂度分析: O(n)
     */
/*    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    return new int[]{map.get(nums[i]), i};
                }
                map.put(target - nums[i], i);
            }
            return null;
        }
    }*/

    /**
     * 方法一:暴力枚举
     * 思路 :
     *  1. 枚举数组里面的第一个数字 x, 寻找数组中是否存在target-x = y的数字
     *  2. 在寻找y的过程中, 每一个位于x之前的元素,都已经和当前x的元素匹配过,所以只需要拿当前x元素与下一个x进行匹配即可
     *  3. 满足 x+y=target 返回下标集合
     * 时间复杂度分析: O(n^2)
     * 空间复杂度分析: O(1)
     */
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[0];
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
    