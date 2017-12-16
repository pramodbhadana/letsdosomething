package strings;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Utils {
    public static String reverse(String input)
    {
        return new StringBuilder(input).reverse().toString();
    }
    public static Boolean isPalindrome(String input)
    {
        String reverse = reverse(input);
        return input.compareTo(reverse) == 0 ? true : false;
    }
}
