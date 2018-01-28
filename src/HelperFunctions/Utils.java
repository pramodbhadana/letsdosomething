package HelperFunctions;

public class Utils {
    public static void reverseArray(int[] src, int[] dest)
    {
        if(src.length != dest.length)
        {
            //avoid any exceptions
            return;
        }
        int length = src.length;
        for(int i = 0;i<length;i++)
        {
            dest[length-i-1] = src[i];
        }
    }

    public static void reverseArray(Integer[] src, int start, int end)
    {
        int i = start,j = end;
        while(i <= (start+end)/2)
        {
            int temp = src[i];
            src[i] = src[j];
            src[j] = temp;
            j--;
            i++;
        }
    }
}
