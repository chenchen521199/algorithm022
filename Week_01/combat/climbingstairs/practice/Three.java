//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1422 👎 0


package combat.climbingstairs.practice;

//java:爬楼梯
public class Three {
    public static void main(String[] args) {
        Solution solution = new Three().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法一: f(n) = f(n-1) : 求Fibonacci
         * @param n
         * @return
         */
        public int climbStairs(int n) {
            if (n<=2) return n;
            int f1 = 0, f2 = 0,f3= 0;
            for (int i = 0; i<n ; i++){
                f3 = f1 +f2;
                f1 = f2;
                f2 = f3;
            }
            return f3;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
    