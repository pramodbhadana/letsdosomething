package DynamicProgramming;

import strings.Utils;

public class LongestCommonSubstring {
    public String first;
    public String second;

    int LCS[][];

    public LongestCommonSubstring(String first, String second) {
        this.first = first;
        this.second = second;

        int lengthOfFirst = first != null ? first.length() : 0;
        int lengthOfSecond = second != null ? second.length() : 0;

        LCS = new int[lengthOfFirst][lengthOfSecond];
    }

    /**
     * Method to find longest Common Substring between two string(already passed in constructor)
     * @return Longest Common Substring (continuous sub-sequence), empty string if no such LCS exist
     */
    public String findLCS() {
        if(first == null || second == null)
        {
            return new String();
        }
        int maxLength = Integer.MIN_VALUE,maxIndex = -1;
        for(int i=0;i<first.length();i++)
        {
            for(int j=0;j<second.length();j++)
            {
                if(first.charAt(i) == second.charAt(j))
                {
                    if((i == 0) || (j == 0))
                    {
                        LCS[i][j] = 1;
                    }
                    else
                    {
                        LCS[i][j] = LCS[i-1][j-1] + 1; //value at last place along diagonal
                    }
                }
                else
                {
                    LCS[i][j] = 0;
                }
                if(LCS[i][j] > maxLength)
                {
                    maxLength = LCS[i][j];
                    maxIndex = i;
                }
            }
        }
        String LCSSequence = new String();
        if(maxIndex != -1)
        {
            while(maxLength != 0)
            {
                LCSSequence += first.charAt(maxIndex);
                maxIndex = maxIndex - 1;
                maxLength--;
            }
        }
        return Utils.reverse(LCSSequence);
    }
}
