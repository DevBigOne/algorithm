class Solution {
    public int solution(String number) {
        int mod = 0; 
        for (int i = 0; i < number.length(); i++) {
            mod = (mod + (number.charAt(i) - '0')) % 9;
        }
        return mod; 
    }
}
