class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> ls = new ArrayList<>();
        int carry = 0;
        for(int i = num.length-1; i>=0 || k > 0; i--){
            int sum = carry;
            if(i >= 0) sum += num[i];
            if(k > 0){
                sum += k%10;
                k = k/10;
            }
            ls.add(sum%10);
            carry = sum/10;
        }
        if(carry > 0) ls.add(carry);
        Collections.reverse(ls);
        return ls;
    }
}