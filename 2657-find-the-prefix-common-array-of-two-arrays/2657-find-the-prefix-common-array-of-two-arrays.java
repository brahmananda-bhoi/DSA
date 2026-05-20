class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length, count=0;
        int[] ans = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            if(!set.add(A[i]))
                count++;
            if(!set.add(B[i]))
                count++;
            ans[i] = count;
        }
        return ans;
    }
}