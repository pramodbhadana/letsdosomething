package arrays;

public class MinimumArrayLengthToSort {
    public int start;
    public int end;
    public int sizeOfUnsortedArray;
    public MinimumArrayLengthToSort(int[] arr)
    {
        start = -1;
        end = -1;
        sizeOfUnsortedArray = findMinimumArray(arr);
    }
    public int findMinimumArray(int[] arr)
    {
        if(arr.length == 0)
            return 0;

        //find the candidate sub array
        int i = 0, j =arr.length-1;
        while(i<arr.length-1)
        {
            if(arr[i] > arr[i+1])
            {
                break;
            }
            else
            {
                i++;
            }
        }

        while(j>0)
        {
            if(arr[j]<arr[j-1])
            {
                break;
            }
            else
            {
                j--;
            }
        }

        int smallest = findSmallest(arr,i,j);
        int greatest = findGreatest(arr,i,j);

        // check if the smallest element of the candidate sub array is greater than the last
        //element of left sub array(part of array which is not part of this candidate sub array)
        //and the greatest element of the candidate sib array is smaller than the
        // right sub array's first element. Expand the candidate array in any direction required.
        while((i!=0 && smallest<arr[i-1]) || (j!=arr.length-1 && greatest>arr[j+1])) {
            while (i > 0 && smallest < arr[i - 1]) {
                i--;
                smallest = findSmallest(arr, i, j);
            }
            while (j < arr.length - 1 && greatest > arr[j + 1]) {
                j++;
                greatest = findGreatest(arr, i, j);
            }
        }
        int sizeOfUnsortedArray = 0;
        if(j>i) {
            start = i;
            end = j;
            sizeOfUnsortedArray = j-i+1;
        }
        else
        {
            sizeOfUnsortedArray = 0;
        }
        return sizeOfUnsortedArray;
    }

    private int findSmallest(int[] arr, int i, int j) {
        int smallest = arr[i];
        for(int k = i+1;k <= j;k++)
        {
            if(arr[k]<smallest)
                smallest = arr[k];
        }
        return smallest;
    }

    private int findGreatest(int[] arr,int i, int j) {
        int greatest = arr[i];
        for(int k = i+1;k <= j;k++)
        {
            if(arr[k]>greatest)
                greatest = arr[k];
        }
        return greatest;
    }
}
