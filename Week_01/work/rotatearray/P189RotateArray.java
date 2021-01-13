package work.rotatearray;//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
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
public class P189RotateArray {
    public static void main(String[] args) {
        Solution solution = new P189RotateArray().new Solution();
        //测试用例:
        solution.rotate(new int[]{1,2,3,4,5,6,7},3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 : 暴力法
     * 1.确定引入元素 previous,引入元素就是数组最后一个元素
     * 2.将数组当前元素num[j]存放到暂存区temp中, 数组当前元素j的位置就会被空下
     * 3.将引入的元素 previous存放到数组当前元素j的位置下
     * 4.将暂存区的元素temp作为引入元素previous,准备放入到第二暂存区中.
     * 时间复杂度:O(n*2)
     * 空间复杂度:O(1)
     */
    /*class Solution {
        public void rotate(int[] nums, int k) {
            int temp, previous;
            for (int i = 0; i < k; i++) {
                previous = nums[nums.length - 1];
                for (int j = 0; j < nums.length; j++) {
                    temp = nums[j];
                    nums[j] = previous;
                    previous = temp;
                }
            }
        }
    }*/

    /**
     * 方法二 : 使用额外数组
     * 1.创建一个长度为nums.length的数组a,用来存放数组nums中位移K位置的元素
     * 2.指定数组nums中元素存放在数组a中的位置 [数组nums元素位置i + 元素位移位置k % 数组nums长度]
     * 3.将数组a中元素赋值给原数组nums
     * <p>
     * 解题套路: 单调递增常数取余数,结果区间内的常数成周期性[0,余数-1] 例子: 0,1,2,3,4,5  取 5 的余数 结果 0,1,2,3,4,0
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    /*public class Solution {
        public void rotate(int[] nums, int k) {
            int[] a = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                a[(i + k) % nums.length] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = a[i];
            }
        }
    }*/

    /**
     * 方法二(2): 使用额外数组
     */
    /*public class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            int[] newArr = new int[n];
            for (int i = 0; i < n; ++i) {
                newArr[(i + k) % n] = nums[i];
            }
            System.arraycopy(newArr, 0, nums, 0, n);
        }
    }*/

    /**
     * 方法三: 环状替代法
     * 解题思路: https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-yuan-di-huan-wei-xiang-xi-tu-jie/
     * 1. k = k % len; 定义最大公约数
     * 2. int count = 0; 记录交换位置的次数, n个同学一共交换n次
     * 3. 定义for循环: 当前int count = nums.length时, 结束循环
     *  3.1 int cur = start; pre = nums[cur]; 声明初始位置的元素和位置
     *  3.2 定义do while循环 当start == cur时, 表示元素开始位置和元素替换移动后的位置相同,结束循环
     *      3.2.1 int next = (cur + k) % len; 声明初始元素需要移动到的位置
     *      3.2.2 int temp = nums[next]; 将next 位置上的元素 移动到临时位置中,
     *      3.2.3 nums[next] = pre; 将初始元素移动到需要移动到位置上;
     *      3.2.4 pre = temp; cur = next; 设置新移动位置的元素和位置
     *      3.2.5 count++; 记录交换位置的次数
     *
     * 时间复杂度：O(n)，其中 n 为数组的长度。每个元素只会被遍历一次。
     * 空间复杂度：O(1)。我们只需常数空间存放若干变量。
     */
    public class Solution {
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            k = k % len;
            int count = 0;
            //3.
            for (int start = 0; count < len; start++) {
                int cur = start;
                int pre = nums[cur];
                do {
                    int next = (cur + k) % len;
                    int temp = nums[next];
                    nums[next] = pre;
                    pre = temp;
                    cur = next;
                    count++;
                } while (start != cur);
            }
        }
    }

    /**
     * 方法四: 数组翻转
     * 原始数组	1 2 3 4 5 6 7
     * 1. 翻转所有元素	7 6 5 4 3 2 1
     * 2. 翻转 [0, k\bmod n - 1][0,kmodn−1] 区间的元素 5 6 7 4 3 2 1
     * 3. 翻转 [k\bmod n, n - 1][kmodn,n−1] 区间的元素	5 6 7 1 2 3 4
     *
     * 时间复杂度：O(n)，其中 n 为数组的长度。每个元素被翻转两次，一共 n 个元素，因此总时间复杂度为 O(2n)=O(n)。
     * 空间复杂度：O(1)。
     */
   /* public class Solution {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums,0,nums.length-1);
            reverse(nums,0,k-1);
            reverse(nums,k,nums.length-1);
        }

        public void reverse(int[] nums , int start, int end){
            while (start < end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start += 1;
                end -= 1;
            }
        }
    }*/

//leetcode submit region end(Prohibit modification and deletion)
}