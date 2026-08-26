class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans=null;
        int l=0, count=0;
        for(int r=0; r<s.length(); r++){
            if(s.charAt(r) == '1')
                count++;
            while(count > k){
                if(s.charAt(l) == '1')
                    count--;
                l++;
            }
            if(count == k){
                int templ=l;
                while(s.charAt(templ) == '0')
                    templ++;
                String candidate=s.substring(templ,r+1);
                if(ans == null || candidate.length() < ans.length() || (candidate.length() == ans.length() && candidate.compareTo(ans)<0))
                    ans=candidate;
            }
        }
        return ans==null?"":ans;
    }
}


/*class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int countOnes = 0;
        String answer = null;
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1')
                countOnes++;
            // Shrink window from the left when we have more than k '1's
            while (countOnes > k) {
                if (s.charAt(left) == '1')
                    countOnes--;
                left++;
            }
            // When exactly k '1's, try to shrink from the left to minimal length
            if (countOnes == k) {
                // Move left forward to remove zeros
                int tempLeft = left;
                while (tempLeft <= right && s.charAt(tempLeft) == '0')
                    tempLeft++;
                // Now, s[tempLeft..right] is minimal for this window
                String candidate = s.substring(tempLeft, right + 1);
                if (answer == null || candidate.length() < answer.length() ||
                        (candidate.length() == answer.length() && candidate.compareTo(answer) < 0))
                    answer = candidate;
                // To find new candidates, we can move left to shrink further
                if (s.charAt(left) == '1') {
                    // Move left forward to look for new windows
                    left++;
                    countOnes--;
                }
            }
        }
        return answer == null ? "" : answer;
    }
}*/

/*class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l=0, r=0, count=0;
        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(r<s.length()){
            if(s.charAt(r) == '1')
                count++;
            if(count == k){
                pq.offer(s.substring(l,r+1));
                if(s.charAt(l++) == '1')
                    count--;
                while(l<s.length() && s.charAt(l) == '0')
                    l++;
                if(count == k)
                    pq.offer(s.substring(l,r+1));
            }
            r++;
        }
        System.out.println(pq);
        return pq.isEmpty()?"":pq.poll();
    }
}*/