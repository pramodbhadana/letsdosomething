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
}
