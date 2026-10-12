class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.toUpperCase().equals(word)){
            return true;
        }

        if(word.toLowerCase().equals(word)){
            return true;
        }

        if (Character.isUpperCase(word.charAt(0)) &&
            word.substring(1).toLowerCase().equals(word.substring(1))) {
            return true;
        }
        return false;
    }
}