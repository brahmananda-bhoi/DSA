class Solution {
    public String longestPrefix(String s) {
        int pos=0, base=31;
        long fhash=0, rhash=0, pow=1;
        HashMap<Integer, Long> map=new HashMap<>();
        for(int i=s.length()-1;i>0;i--){
            int val=s.charAt(i);
            rhash=rhash+val*pow;
            map.put(s.length()-i, rhash);
            pow*=base;
        }
        for(int i=0;i<s.length()-1;i++){
            int val=s.charAt(i);
            fhash=fhash*base+val;
            if(fhash==map.get(i+1))
                pos=i+1;
        }
        return s.substring(0,pos);
    }
}