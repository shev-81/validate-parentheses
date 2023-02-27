package validate.parentheses;

public class ValidateParentheses {
    public static void main(String[] args) {
        // SetUp
        String str1 = "(()(";
        String str2 = ")()())";
        String str3 = ")(())())";
        String str4 = ")(";

        // Run
        String result1 = validate(str1);
        String result2 = validate(str2);
        String result3 = validate(str3);
        String result4 = validate(str4);
        System.out.println(result1.length() + " - " + result1);
        System.out.println(result2.length() + " - " + result2);
        System.out.println(result3.length() + " - " + result3);
        System.out.println(result4.length() + " - " + result4);
    }
    private static String validate(String str) {
        int open = 0;
        StringBuilder tmpResult = new StringBuilder();
        for (int i = 0; i < str.length(); i ++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                open++;
                tmpResult.append(ch);
            }
            if (ch == ')' && open > 0) {
                open--;
                tmpResult.append(ch);
            }
        }
        System.out.println(tmpResult);
        if(open == 0){
            return tmpResult.toString();
        }

        int wordLength = tmpResult.length();
        StringBuilder result = new StringBuilder();
        int close = 0;
        for (int i = wordLength-1; i > 0; i--) {
            char ch = tmpResult.charAt(i);
            if (ch == ')' ) {
                close++;
                result.append(ch);
            }
            if (ch == '(' && close > 0) {
                close--;
                result.append(ch);
            }
        }
        return result.reverse().toString();
    }
}
