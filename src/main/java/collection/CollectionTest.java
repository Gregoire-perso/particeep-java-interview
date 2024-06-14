package collection;

import java.util.List;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {

    /**
     * operation : x -> ((x * 2) + 3) ^ 5
     */
    public static List<Double> compute1(List<Integer> input) {
        return input.stream().map(integer -> Math.pow((integer * 2) + 3, 5)).toList();
    }
    
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /**
     * operation : abc -> AbcAbc
     */
    public static List<String> compute2(List<String> input) {
        return input.stream().map(string -> String.format("%s", capitalize(string)).repeat(2)).toList();
    }
}