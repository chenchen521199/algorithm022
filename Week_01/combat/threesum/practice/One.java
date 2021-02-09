//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 2904 👎 0


package combat.threesum.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//java:三数之和
public class One {
    public static void main(String[] args) {
        Solution solution = new One().new Solution();
    }


//================================第一遍=================================
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法一：暴力
         * 枚举3个指针
         *
         * @param nums
         * @return
         */
        /*public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length <= 2) {
                return Collections.emptyList();
            }
            Arrays.sort(nums);
            Set<List<Integer>> result = new LinkedHashSet<>();
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; i++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> value = Arrays.asList(nums[i], nums[j], nums[k]);
                            result.add(value);
                        }
                    }
                }
            }
            return new ArrayList<>(result);
        }*/

        /**
         * 方法二:动态规划
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length <= 2) {
                return Collections.emptyList();
            }
            List<List<Integer>> res = new ArrayList<>();
            for (int k = 0; k < nums.length - 2; k++) {
                if (nums[k] > 0) break;
                if (k > 0 && nums[k] == nums[k - 1]) continue;
                int i = k + 1, j = nums.length - 1;
                while (i < j) {
                    int sum = nums[k] + nums[i] + nums[j];
                    if (sum < 0) {
                        while (i < j && nums[i] == nums[++i]) ;
                    } else if (sum > 0) {
                        while (i < j && nums[j] == nums[--j]) ;
                    } else {
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[k])));
                        while (i < j && nums[i] == nums[++i]) ;
                        while (i < j && nums[j] == nums[--j]) ;
                    }
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
    