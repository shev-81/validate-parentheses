package validate.parentheses;

public class ValidateParentheses {
    public static void main(String[] args) {
        // SetUp
        String str1 = "(()(";
        String str2 = ")()())";
        String str3 = ")(())())";
        String str4 = "()(()(((())";

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

    static String validate(String input){
        StringBuilder str = new StringBuilder();
        int closed = 0;
        int open = 0;
        for (int i = 0; i < input.length(); i++) if (input.charAt(i) == ')') closed++;
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == '(' && open < closed){
                str.append(input.charAt(i));
                open++;
            }
            if (input.charAt(i) == ')'){
                if (open > 0){
                    str.append(input.charAt(i));
                    open--;
                }
                closed--;
            }
        }
        return str.toString();
    }
}
