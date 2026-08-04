class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n-3; i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1; j<n-2; j++){
                if(j>i+1 && nums[j]==nums[j-1])
                    continue;
                long t=(long)nums[i]+nums[j];
                int l=j+1, r=n-1;
                while(l<r){
                    if(l!=j+1 && nums[l]==nums[l-1]){
                        l++;
                        continue;
                    }
                    long sum = (long)nums[l]+nums[r];
                    if(sum + t == target){
                        List<Integer> li = new ArrayList<>();
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[l]);
                        li.add(nums[r]);
                        ans.add(li);
                        l++;
                        r--;
                        while(nums[l]==nums[l-1] && l<r)
                            l++;
                    }
                    else if(sum + t > target)
                        r--;
                    else
                        l++;
                }
            }
        }
        return ans;
    }
}



/*
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        if(nums.length==4){
            if(nums[0]+nums[1]+nums[2]+nums[3]!=target)
                return ans;
        }
        for(int i=0;i<nums.length-3;i++){
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1;j<nums.length-2;j++){
                if(j!=i+1 && nums[j]==nums[j-1])
                    continue;
                int left=j+1;
                int right=nums.length-1;
                long t=(nums[i]+nums[j]);
                while(left<right){
                    if(left!=j+1 && nums[left]==nums[left-1]){
                        left++;
                        continue;
                    }
                    if((t+((long)nums[left]+nums[right]))==target){
                        List<Integer> l=new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[left]);
                        l.add(nums[right]);
                        ans.add(l);
                        left++;
                        right--;
                    }
                    else if((t+((long)nums[left]+nums[right]))<target)
                        left++;
                    else
                        right--;
                }
            }
        }
        return ans;
    }
}
*/