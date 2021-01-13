//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明： 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6] 
//
// 
//
// 提示： 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics 数组 双指针 
// 👍 718 👎 0


package work.mergesortedarray.practice;

//java:合并两个有序数组

/**
 * 题目分析:
 */
public class Four {
    public static void main(String[] args) {
        Solution solution = new Four().new Solution();
        //测试用例
        solution.merge(new int[]{1, 2, 3, 0, 0, 0}, 3,
                new int[]{2, 5, 6}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 方法一：合并后排序
     */
    /*class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            System.arraycopy(nums2,0,nums1,m,n);
            Arrays.sort(nums1);
        }
    }*/

    /**
     * 方法二：双指针/从后往前
     */
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int len1 = m - 1;
            int len2 = n - 1;
            int len = m + n - 1;
            while (len1 >= 0 && len2 >= 0) {
                nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
            }
            System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
}
    