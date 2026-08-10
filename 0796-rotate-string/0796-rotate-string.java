class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        
        String doubledS = s + s;
        // Check if the goal is a substring of the concatenated string
        return doubledS.contains(goal);
    }
}