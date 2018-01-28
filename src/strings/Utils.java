package strings;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Utils {
    public static String reverse(String input)
    {
        return new StringBuilder(input).reverse().toString();
    }
    public static String reverse(String input, int start, int end)
    {
        StringBuilder output = new StringBuilder(input.substring(0,start));

        String reversedPart = reverse(input.substring(start,end+1));
        output.append(reversedPart);

        if(end < input.length())
            output.append(input.substring(end+1,input.length()));

        return output.toString();
    }
    public static Boolean isPalindrome(String input)
    {
        String reverse = reverse(input);
        return input.compareTo(reverse) == 0 ? true : false;
    }
}
