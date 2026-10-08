class Solution {
    public int countValidWords(String sentence) {
        String[] arr = sentence.trim().split("\\s+");
        int count = 0;
        for (String curr : arr) {
            boolean valid = true;
            int hyphenCount = 0;
            for (int i = 0; i < curr.length(); i++) {
                char ch = curr.charAt(i);
                if (Character.isDigit(ch)) {
                    valid = false;
                    break;
                }

                if (ch == '.' || ch == '!' || ch == ',') {
                    if (i != curr.length() - 1) {
                        valid = false;
                        break;
                    }
                }

                if (ch == '-') {
                    hyphenCount++;

                    if (hyphenCount > 1) {
                        valid = false;
                        break;
                    }
                    if (i == 0 || i == curr.length() - 1) {
                        valid = false;
                        break;
                    }
                    if (!Character.isLowerCase(curr.charAt(i - 1)) ||
                        !Character.isLowerCase(curr.charAt(i + 1))) {
                        valid = false;
                        break;
                    }
                }
            }
            if (valid) {
                count++;
            }
        }
        return count;
    }
}