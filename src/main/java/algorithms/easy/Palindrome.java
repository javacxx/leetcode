package algorithms.easy;

/**
 * @author CXX
 * @date 2019/5/28 14:38
 */
public class Palindrome {
    /**
     * Time O(lg(x))
     * Space O(lg(x))
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        String str = Integer.toString(x);
        char[] chars = str.toCharArray();

        for (int i=0; i<chars.length; i++) {
            if(i >= chars.length-i-1){
                return true;
            }
            char a = chars[i];
            char b = chars[chars.length-1-i];
            if (a != b) {
                return false;
            }
        }
        return true;
    }
}
