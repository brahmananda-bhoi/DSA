class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for(int num : arr1){
            while(num > 0){
                set.add(num);
                num /= 10;
            }
        }
        int maxLen = 0;
        for(int num : arr2){
            while(num > 0){
                if(set.contains(num)){
                    maxLen = Math.max(maxLen, (int)(Math.log10(num)+1));
                    break;
                }
                num /= 10;
            }
        }
        return maxLen;
    }
}




/**
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixes = new HashSet<>();
        // Store all prefixes of arr1
        for (int num : arr1) {
            while (num > 0) {
                prefixes.add(num);
                num /= 10;
            }
        }
        int maxLen = 0;
        // Check all prefixes of arr2
        for (int num : arr2) {
            while (num > 0) {
                if (prefixes.contains(num)) {
                    maxLen = Math.max(maxLen, String.valueOf(num).length());
                    break;
                }
                num /= 10;
            }
        }
        return maxLen;
    }
}
 */