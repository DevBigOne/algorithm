class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        for(int i = 1; i < numLog.length; i++) {
            if(numLog[i - 1] + 1 == numLog[i] ) {
                answer += "w";
                
            } 
            if(numLog[i - 1] - 1 == numLog[i]) {
                answer += "s";
                
            }
            if(numLog[i - 1] + 10 == numLog[i]) {
                answer += "d";
                
            }
            if(numLog[i - 1] - 10 == numLog[i]) {
                answer += "a";
            }
        }
        return answer;
    }
}