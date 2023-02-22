package validate.parentheses;

public class ValidateParentheses {
    public static void main(String[] args) {
        // SetUp
        String str1 = "(()";
        String str2 = ")()())";
        String str3 = ")(()())";
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
        String result = tmpResult.toString();
        for(int i = 0; open > 0 && i < result.length(); i++) {
            if(tmpResult.charAt(i) == '('){
                result = tmpResult.replace(i, i+1, "").toString();
            }
            open--;
        }
        return result;
    }
}
