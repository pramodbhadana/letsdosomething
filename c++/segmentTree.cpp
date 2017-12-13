//Segment tree for minimum in a range..
//functions for creation and updation of the segment tree and for query
#include<iostream>
#include<stdio.h>
#include<math.h>
#define MAX 99999999
#define DEBUG 0
using namespace std;

int* createSegmentTree(int arr[], int size);
void createSegmentTreeUtil(int arr[],int start, int end, int segmentTree[], int segmentTreeIndex);
void printArray(int * arr,int size);
int querySegmentTree(int queryLow,int queryHigh,int start,int end,int segmentTree);
int minimumInt(int first,int second);
void updateSegmentTree(int indexToBeUpdated,int updatedValue,int start, int end,int* segmentTree,int segmentTreeIndex);
void updateSegmentTreeLazy(int delta,int indexToBeUpdatedLow,int indexToBeUpdatedHigh,int start,int end,int lazyIndexTree[],int* segmentTree, int segmentTreeIndex);

void updateSegmentTreeLazy(int delta,int indexToBeUpdatedLow,int indexToBeUpdatedHigh,int start,int end,int lazyIndexTree[],int* segmentTree, int segmentTreeIndex)
{
    if(DEBUG)
        cout<<start<<" "<<end<<endl;
    if(end < start)
        return ;
    
    if(lazyIndexTree[segmentTreeIndex] != 0)        // need to propogate to children
    {
        segmentTree[segmentTreeIndex] += lazyIndexTree[segmentTreeIndex];
        if(start != end)        //not leaf node
        {
            lazyIndexTree[2*segmentTreeIndex+1] += lazyIndexTree[segmentTreeIndex];
            lazyIndexTree[2*segmentTreeIndex+2] += lazyIndexTree[segmentTreeIndex];
        }
        lazyIndexTree[segmentTreeIndex] = 0;
    }

    //no overlap 
    if(indexToBeUpdatedLow > end  || indexToBeUpdatedHigh < start)
    {
        return ;
    }

    //total overlap
    if(indexToBeUpdatedLow <= start && indexToBeUpdatedHigh >= end)
    {
        segmentTree[segmentTreeIndex] += delta;
        if(start != end)
        {
            lazyIndexTree[2*segmentTreeIndex+1] += delta;
            lazyIndexTree[2*segmentTreeIndex+2] += delta;
        }
        return ;
    }

    //partial overlap
    int mid = (start+end)/2;
    updateSegmentTreeLazy(delta,indexToBeUpdatedLow,indexToBeUpdatedHigh,start,mid,lazyIndexTree,segmentTree,2*segmentTreeIndex+1);
    updateSegmentTreeLazy(delta,indexToBeUpdatedLow,indexToBeUpdatedHigh,mid+1,end,lazyIndexTree,segmentTree,2*segmentTreeIndex+2);

    segmentTree[segmentTreeIndex] = minimumInt(segmentTree[2*segmentTreeIndex+1],segmentTree[2*segmentTreeIndex+2]);

}

void updateSegmentTree(int indexToBeUpdated,int updatedValue,int start, int end,int* segmentTree,int segmentTreeIndex)
{
    if(start == end)
    {
        if(indexToBeUpdated == start)
            segmentTree[segmentTreeIndex] = updatedValue;
        return;
    }
    int mid = (start+end)/2;
    updateSegmentTree(indexToBeUpdated,updatedValue,start,mid,segmentTree,2*segmentTreeIndex+1);
    updateSegmentTree(indexToBeUpdated,updatedValue,mid+1,end,segmentTree,2*segmentTreeIndex+2);

    if(segmentTree[2*segmentTreeIndex+1] < segmentTree[2*segmentTreeIndex+2])
        segmentTree[segmentTreeIndex] = segmentTree[2*segmentTreeIndex+1];
    else
        segmentTree[segmentTreeIndex] = segmentTree[2*segmentTreeIndex+2];

}

int minimumInt(int first, int second)
{
    return first < second ? first : second;
}

int querySegmentTree(int queryLow,int queryHigh,int start,int end,int* segmentTree,int segmentTreeIndex)
{
    if(DEBUG)
        cout<<start<<" "<<end<<endl;
    //no overlap
    if((queryLow < start && queryHigh < start) || (queryLow > end && queryHigh > end))
    {
        if(DEBUG)
            cout<<"1 here "<<endl;
        return MAX;
    }
    //complete overlap
    if(start >= queryLow && queryHigh >= end)
    {
        if(DEBUG)
            cout<<"2 here "<<endl;
        return segmentTree[segmentTreeIndex];
    }
    //partial overlap
    int mid = (start+end)/2;
    return minimumInt(querySegmentTree(queryLow,queryHigh,start,mid,segmentTree,2*segmentTreeIndex+1),
                    querySegmentTree(queryLow,queryHigh,mid+1,end,segmentTree,2*segmentTreeIndex+2));

}

void createSegmentTreeUtil(int arr[],int start, int end, int segmentTree[], int segmentTreeIndex)
{
    if(start == end)
    {
        segmentTree[segmentTreeIndex] = arr[start];
        return ;
    }
    int mid = (start+end)/2;
    createSegmentTreeUtil(arr,start,mid,segmentTree,2*segmentTreeIndex+1);
    createSegmentTreeUtil(arr,mid+1,end,segmentTree,2*segmentTreeIndex+2);

    //criteria for the segment tree based on the type of range query (e.g. minimum among a range , sum from i to j)
    if(segmentTree[2*segmentTreeIndex+1] < segmentTree[2*segmentTreeIndex+2])
        segmentTree[segmentTreeIndex] = segmentTree[2*segmentTreeIndex+1];
    else
        segmentTree[segmentTreeIndex] = segmentTree[2*segmentTreeIndex+2];
}

int* createSegmentTree(int arr[], int size)
{
    //need to allocate memory for the segment tree
    int noOfNodes = (int)ceil(log2(size));
    int totalSpaceNeeded = 2*(int)pow(2,noOfNodes) - 1;

    int *segmentTree = new int[totalSpaceNeeded];
    createSegmentTreeUtil(arr,0,size,segmentTree,0);
    return segmentTree;
}

void printArray(int * arr,int size)
{
    int sizeOfArr = sizeof(arr)/sizeof(int);
    for (int iterator = 0; iterator < size; iterator++)
    {
        cout<<arr[iterator]<<"  ";
    }
}
void init(int* arr, int size, int value)
{
    for (int i=0;i<size;i++)
    {
        arr[i] = value;
    }
}
int main()
{
    int arr[] = {7,2,4,1,9,11,-1};
    int size = sizeof(arr)/sizeof(int);
    int *segmentTree = createSegmentTree(arr,size);
    int *lazyIndexTree = new int[16];
    init(lazyIndexTree,size,0);
    //cout<<querySegmentTree(5,6,0,size-1,segmentTree,0)<<endl;
    updateSegmentTree(3,3,0,size-1,segmentTree,0);
    //pdateSegmentTreeLazy(2,3,3,0,size-1,lazyIndexTree,segmentTree,0);
    printArray(segmentTree,16);
    delete []segmentTree;
    delete []lazyIndexTree;
}