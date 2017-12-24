package sorting;

public class QuickSort {
    public void sort(int[] input,boolean isIncreasingOrder)
    {
        sortUtil(input,0,input.length-1,isIncreasingOrder);
    }
    private void sortUtil(int[] input,int start, int end,boolean isIncreasingOrder)
    {
        if(start<end)
        {
            int pivot = partition(input,start,end,isIncreasingOrder);

            sortUtil(input,start,pivot-1,isIncreasingOrder);
            sortUtil(input,pivot+1,end,isIncreasingOrder);
        }
    }
    private int partition(int[] input,int start, int end,boolean isIncreasingOrder)
    {
        int pivotIndex = end,i=start,j=end-1;
        while(true)
        {
            while(i<=end && (isIncreasingOrder ? input[i] < input[pivotIndex] : input[i] > input[pivotIndex]))
            //while(i<=end && compare(input[i],input[pivotIndex],isIncreasingOrder))
                i++;
            while(j>=start && (isIncreasingOrder ? input[j] > input[pivotIndex] : input[j] < input[pivotIndex]))
            //while(j>=start && compare(input[j],input[pivotIndex],!isIncreasingOrder))
                j--;
            if(i>j)
                break;
            swap(input,i,j);
        }
        swap(input,i,pivotIndex);
        return i;
    }
    void swap(int[] input, int i,int j)
    {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    /**
     *
     * @param first
     * @param second
     * @param isIncreasingOrder
     * @return true if first and second are in increasing order provided isIncreasingOrder is true, false otherwise
     */
    public static boolean compare(int first, int second,boolean isIncreasingOrder)
    {
        return second > first ? isIncreasingOrder : !isIncreasingOrder;
    }

}
