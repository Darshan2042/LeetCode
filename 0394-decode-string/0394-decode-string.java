class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<StringBuilder> str = new Stack<>();

        StringBuilder curr = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            else if (ch == '[') {
                count.push(num);
                str.push(curr);
                num = 0;
                curr = new StringBuilder();
            }

            else if (Character.isLetter(ch)) {
                curr.append(ch);
            }
            else {
                int repeat = count.pop();
                StringBuilder prev = str.pop();

                while (repeat-- > 0) {
                    prev.append(curr);
                }

                curr = prev;
            }
        }

        return curr.toString();
    }
}