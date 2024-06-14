package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {
    public static Integer multSafeOverflow(int left, int right) throws ArithmeticException {
        int result = left * right;
        if (result / right != left) {
            throw new ArithmeticException();
        }
        
        return result;
    }
  
    public static Integer powerRec(Integer base, Integer exponent) throws ArithmeticException {
        System.out.println(base + " " + exponent);
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1 || base == 0) {
            return base;
        }
        
        if (exponent % 2 == 0) {
            return powerRec(multSafeOverflow(base, base), exponent / 2);
        }
        
        return multSafeOverflow(powerRec(multSafeOverflow(base, base), exponent / 2), base);
    }

    /**
     * return i ^ n for positive Integer, None otherwise
     * return None in case of errors
     */
    public static Option<Integer> power(Integer i, Integer n) {
        if (i < 0 || n < 0) {
            return Option.none();
        }
        
        Integer res;
        
        try {
            res = powerRec(i, n);
        } catch (ArithmeticException e) {
            return Option.none();
        }
        
        return Option.of(res);
    }
}
