class Solution {
    private void reverse(char[] s, int l, int r){
        if(l < r){
            char c = s[l];
            s[l] = s[r];
            s[r] = c;
            reverse(s, l+1, r-1);
        }
    }
    public void reverseString(char[] s) {
        reverse(s, 0, s.length-1);
    }
}


// class Solution {
//     public void reverseString(char[] s) {
//         int r=s.length-1, l=0;
//         while(l<r){
//             char c=s[r];
//             s[r]=s[l];
//             s[l]=c;
//             l++;
//             r--;
//         }
//     }
// }