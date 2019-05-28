package algorithms.easy;

/**
 * @author CXX
 * @date 2019/5/27 17:23
 */
public class ReverseInterger {

    public static int reverse(int x) {
        int rv = 0;
        while (x !=0) {
            // 取余 最后一位
            int pop = x % 10;
            // 取整 保留前面的值
            x = x/10;
            // 溢出校验  2147483647
            if (rv > Integer.MAX_VALUE/10 || (rv == Integer.MAX_VALUE/10 && pop > 7)) {
                return 0;
            }
            // -2147483648
            if (rv < Integer.MIN_VALUE/10 || (rv == Integer.MIN_VALUE/10 && pop <-8)) {
                return 0;
            }
            rv = rv*10 + pop;
        }
        return rv;
    }
}
