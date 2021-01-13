package work.rotatearray.practice;//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//
//
// 示例 2:
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
// 说明:
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的 原地 算法。
//
// Related Topics 数组
// 👍 753 👎 0


//java:旋转数组
public class Three {
    public static void main(String[] args) {
        Solution solution = new Three().new Solution();
        //测试用例:
        solution.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    // ----------------------------------五毒神掌 第三遍--------------------------------------------
    class Solution {
        /**
         * 暴力法
         *
         * @param nums
         * @param k
         */
       /* public void rotate(int[] nums, int k) {
            int temp, previous;
            for (int i = 0; i < k; i++) {
                previous = nums[nums.length - 1];
                for (int j = 0; j < nums.length; j++) {
                    temp = nums[j];
                    nums[j]= previous;
                    previous= temp;
                }
            }
        }*/

        /**
         * 额外数组法
         *
         * @param nums
         * @param k
         */
        /*public void rotate(int[] nums, int k) {
            int[] a = new int[nums.length];
            for (int i = 0; i<nums.length;i++ ){
                a[(i+k)%nums.length] = nums[i];
            }
            for (int i = 0; i<nums.length;i++ ){
                nums[i] = a[i];
            }
        }*/

        /**
         * 额外数组法2
         *
         * @param nums
         * @param k
         */
        /*public void rotate(int[] nums, int k) {
            int[] newArr = new int[nums.length];
            for (int i = 0; i<nums.length;i++ ){
                newArr[(i+k)%nums.length] = nums[i];
            }
            System.arraycopy(newArr,0,nums,0,nums.length);
        }*/

        /**
         * 环状替代法
         *
         * @param nums
         * @param k
         */
      /*  public void rotate(int[] nums, int k) {
            int len = nums.length;
            k %= len;
            int count = 0;
            for (int start = 0; count < nums.length; start++) {
                int cur = start;
                int pre = nums[start];
                do {
                    int next = (cur + k) % len;
                    int temp = nums[next];
                    nums[next] = pre;
                    pre = temp;
                    cur = next;
                    count++;
                } while (start != cur);
            }
        }*/

        /**
         * 数组翻转
         *
         * @param nums
         * @param k
         */
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);

        }

        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] =nums[end];
                nums[end] = temp;
                start +=1;
                end -=1;
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)
}