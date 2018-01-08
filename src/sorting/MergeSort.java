package sorting;

public class MergeSort {
    public void sort(int[] input,boolean isIncreasingOrder)
    {
        sortUtil(input,0, input.length-1,isIncreasingOrder);
    }
    private void sortUtil(int[] input,int start, int end, boolean isIncreasingOrder)
    {
        if(start < end)
        {
            int mid = (start + end)/2;
            sortUtil(input,start,mid,isIncreasingOrder);
            sortUtil(input,mid+1,end,isIncreasingOrder);

            //merge the sorted arrays now
            int i=start,j=mid+1,k = 0;
            int temp[] = new int[end-start+1];

            while(i<=mid && j<=end)
            {
                if(input[i] < input[j] ? isIncreasingOrder:!isIncreasingOrder)
                {
                    temp[k++] = input[i++];
                }
                else
                {
                    temp[k++] = input[j++];
                }
            }

            if(i>mid && j<=end)     // first array is exhausted
            {
                while(j<=end)
                    temp[k++] = input[j++];
            }

            if(j>end && i<=mid)
            {
                while(i<=mid)
                    temp[k++] = input[i++];
            }
            System.arraycopy(temp,0,input,start,end-start+1);
        }
    }
}
