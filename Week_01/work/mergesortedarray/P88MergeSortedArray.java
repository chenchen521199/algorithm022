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


package work.mergesortedarray;

//java:合并两个有序数组

/**
 * 题目分析:
 */
public class P88MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new P88MergeSortedArray().new Solution();
        //测试用例
        solution.merge(new int[]{1, 2, 3, 0, 0, 0}, 3,
                new int[]{2, 5, 6}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 方法一：合并后排序
     * 解题思路：
     * 1. 将原数组（ nums2）的全部元素，copy到目标数组（nums1）的 [m，n]位置区间上。
     * 2. 将目标数组（num1）进行排序
     * 复杂度分析
     * 时间复杂度 : O((n + m)\log(n + m))
     * 空间复杂度 : O(1)
     */
    /*class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            System.arraycopy(nums2, 0, nums1, m, n);
            Arrays.sort(nums1);
        }
    }*/

    /**
     * 方法二：双指针/从后往前
     * 解题思路：
     * https://leetcode-cn.com/problems/merge-sorted-array/solution/hua-jie-suan-fa-88-he-bing-liang-ge-you-xu-shu-zu-/
     * 1. 定义数组1(nums1)m-1位置的指针(len1),定义数组2(nums2)n-1位置的指针(len2),定义数组1(nums1)m+n-1位置(num1最后位置)的指针(len1)
     * 2. 定义while 当 len1和len2小于0停止循环 , 对比数组1(nums1)最后位置的元素和数组2(nums2)最后位置的元素,将最大的元素存放到到数组1(nums1)最后的位置
     * 3. copy
     * 复杂度分析
     * 时间复杂度 : O((n + m)\log(n + m))
     * 空间复杂度 : O(1)
     */
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int len1 = m - 1;
            int len2 = n - 1;
            int len = m + n - 1;
            while(len1 >= 0 && len2 >= 0) {
                // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
                nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
            }
            // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
            System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
}
    