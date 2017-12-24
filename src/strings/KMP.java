package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMP {
    String input;
    public KMP(String input)
    {
        this.input = input;
    }
    public List<Integer> searchPattern(String pattern) {
        int prefix[] = generatePrefix(pattern),i,j;
        ArrayList<Integer> listOfIndices = new ArrayList<Integer>();
        for(i=0;i<input.length();i++)
        {
            for(j=0;j<pattern.length();j++)
            {
                if(input.charAt(i+j) != pattern.charAt(j))
                {
                    if(j>0)
                    {
                        j = prefix[j-1];
                        i += j;
                    }
                    else
                    {
                        break;
                    }
                }
            }
            if(j == pattern.length())
            {
                listOfIndices.add(i);
                i += j-1;
            }
        }



        return listOfIndices;
    }
    private int[] generatePrefix(String pattern) {
        int i,j=0,prefixArray[] = new int[pattern.length()];
        prefixArray[0] = 0;
        for(i=1;i<pattern.length();i++)
        {
            if(j > 0 && pattern.charAt(i) != pattern.charAt(j))
            {
                j = prefixArray[j-1];
            }
            if(pattern.charAt(i) == pattern.charAt(j))
            {
                prefixArray[i] = ++j;
            }
            else
            {
                prefixArray[i] = j;
            }
        }
        return prefixArray;
    }
}
