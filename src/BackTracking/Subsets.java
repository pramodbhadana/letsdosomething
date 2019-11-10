class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> globalList = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(0,nums,new ArrayList<>(),globalList);
        return globalList;
    }
    
    void generateSubsets(int start,int[] nums, ArrayList<Integer> localList, List<List<Integer>> globalList) {
        globalList.add(new ArrayList<>(localList));
        for(int i = start;i<nums.length;i++) {
            localList.add(nums[i]);
            generateSubsets(i+1,nums,localList,globalList);
            localList.remove(localList.size()-1);
        }
    }
}