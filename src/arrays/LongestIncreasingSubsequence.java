package arrays;

import HelperFunctions.Utils;

public class LongestIncreasingSubsequence {
    int priv[];
    int biggest;
    public int findLIS(int[] input)
    {
        int max = 1,LIS[] = new int[input.length];
        priv = new int[input.length];
        LIS[0] = 1;
        priv[0] = -1;

        for(int i = 1;i<input.length;i++)
        {
            LIS[i] = 1;
            for(int j=i-0;j>=0;j--)
            {
                if(input[i] > input[j] && LIS[j]+1 > LIS[i])
                {
                    LIS[i] = LIS[j]+1;
                    priv[i] = j;
                }
            }

            if(LIS[i] > max)
            {
                max = LIS[i];
                biggest = i;
            }
        }
        return max;
    }
    public int[] generateLISArray(int[] input)
    {
        int lisLength = findLIS(input);
        int i = biggest,k=0;
        int lisArray[] = new int[lisLength];
        int temp[] = new int[lisLength];
        do
        {
            temp[k++] = input[i];
            i = priv[i];
        }while(i != -1);
        Utils.reverseArray(temp,lisArray);
        return lisArray;
    }
}
