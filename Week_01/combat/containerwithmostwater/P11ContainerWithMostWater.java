//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 数组 双指针 
// 👍 2114 👎 0


package combat.containerwithmostwater;

//java:盛最多水的容器
public class P11ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new P11ContainerWithMostWater().new Solution();
        //测试用例
        solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法一: 暴力枚举
         * 解题思路
         * 1. 枚举两个边, 用数组中当前边和下一个边去做比较,用较小的边计算面积
         * 2. 每次得到的面积去做对比,返回最大的面积
         * 复杂度分析
         * 时间复杂度: O(n^2)
         * 空间复杂度: O(1)
         * 延伸:
         * for循环中++i 和 i++ 的区别
         * 根据上面的for循环的语法定义 ++i 和 i++的结果是一样的，都要等代码块执行完毕才能执行语句3，但是性能是不同的。
         * 在大量数据的时候++i的性能要比i++的性能好原因：
         * i++由于是在使用当前值之后再+1，所以需要一个临时的变量来转存。而++i则是在直接+1，省去了对内存的操作的环节，相对而言能够提高性能
         * @param height
         * @return
         */
        /*public int maxArea(int[] height) {
            int max = 0;
            // 注意: 外循环定义下标:长度为 height.length - 1 内循环定义长度:长度为 height.length. 内循环定义的长度-下标=计算后的长度
            for (int i = 0; i < height.length - 1; ++i) {
                for (int j = i + 1; j < height.length; ++j) {
                    int area = (j - i) * Math.min(height[i], height[j]);
                    max = Math.max(max, area);
                }
            }
            return max;
        }*/

        /**
         * 方法二: 双指针 左右夹逼
         * 解题思路:
         * 1. 枚举两个边,分别在数组两端.
         * 2. 首尾两个边进行比较,较小的边向数组中间移动
         * 3. 每次移动后,使用较小的边和下标差计算面积
         * 4. 对比后,选择最大的面积进行引用
         *
         * @param height
         * @return
         */
        public int maxArea(int[] height) {
            int max = 0;
            for (int i = 0, j = height.length - 1; i < j; ) {
                int minHeight = height[i] < height[j] ? height[i++] : height[j--];
                int area = (j - i+1) * minHeight; //注意: i 和 j 代表的都是下标. 最后 +1 表示长度.
                max = Math.max(max, area);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
    