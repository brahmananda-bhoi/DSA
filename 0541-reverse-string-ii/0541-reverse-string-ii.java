class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);
            reverse(arr, left, right);
        }
        return new String(arr);
    }
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}









// class Solution {
//     public String reverseStr(String s, int k) {
//         StringBuilder sb = new StringBuilder();
//         int l = 0, n = s.length();
//         boolean flag = true;
//         while(l < n){
//             int r = l + k - 1 < n ? l + k - 1 : n-1;
//             if(flag){
//                 while(r >= l)
//                     sb.append(s.charAt(r--)+"");
//                 l += k;
//             }
//             else{
//                 while(l <= r)
//                     sb.append(s.charAt(l++)+"");
//             }
//             flag = !flag;
//         }
//         return sb.toString();
//     }
// }