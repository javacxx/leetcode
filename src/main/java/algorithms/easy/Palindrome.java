package algorithms.easy;

/**
 * @author CXX
 * @date 2019/5/28 14:38
 */
public class Palindrome {
    /**
     * Time O(lg(x))
     * Space O(1)
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        int n = 0;
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        while (x > n) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return n == x || x == n / 10;
    }
}
