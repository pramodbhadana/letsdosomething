package strings.problems;

public class DeleteSubstringRepeatedly {
    static int[] generateSuffixArray(String pattern) {
        int[] array = new int[pattern.length()];
        array[0] = 0;
        int j = 0;
        for(int i = 1;i<pattern.length();i++)
        {
            if(j>0  && (pattern.charAt(i) != pattern.charAt(j)))
            {
                j = array[j-1];
            }
            if(pattern.charAt(j) == pattern.charAt(i))
            {
                array[i] = ++j;
            }
            else
            {
                array[i] = j;
            }
        }

        return array;
    }

    static String deleteSubstring(String input, int indexOfSubstring, int lengthOfSubstring)
    {
        StringBuilder output = new StringBuilder(input.substring(0,indexOfSubstring));

        output.append(input.substring(indexOfSubstring+lengthOfSubstring,input.length()));

        return output.toString();
    }

    public static int moves(String input, String pattern) {
        if(input == null || pattern == null || input.isEmpty() ||pattern.isEmpty())
            return 0;
        int array[] = generateSuffixArray(pattern), moves = 0, j = 0,i = 0 ;
        while(i<=input.length()-pattern.length())
        {
            j = 0;
            while(j < pattern.length())
            {
                if(input.charAt(i+j) == pattern.charAt(j))
                {
                    j++;
                }
                else
                {
                    if(j>0 && array[j] > 0)
                        j = array[j];
                    else
                        break;
                }
            }
            if(j == pattern.length()) {
                input = deleteSubstring(input, i, pattern.length());
                i = 0;
                moves++;
            }
            else {
                i++;
            }
        }
        return moves;
    }
}
