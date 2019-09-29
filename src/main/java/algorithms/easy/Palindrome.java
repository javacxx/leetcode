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
     * @param source
     * @return
     */
    public boolean isPalindrome(int source) {
        int tmpValue = 0;
        if (source < 0 || (source % 10 == 0 && source != 0)) {
            return false;
        }
        while (source > tmpValue) {
            tmpValue = tmpValue * 10 + source % 10;
            source /= 10;
        }
        return tmpValue == source || source == tmpValue / 10;
    }
}
