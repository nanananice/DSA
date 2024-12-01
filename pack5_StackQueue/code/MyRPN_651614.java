package code;

import java.util.regex.Pattern;
import java.util.StringTokenizer;

public class MyRPN {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;
            return pattern.matcher(strNum).matches();
    }   
    public static double computeRPN(String rpn) {
        MyStackA stack = new MyStackA();
        StringTokenizer st = new StringTokenizer(rpn);

        while(st.hasMoreTokens()) {
            String t = st.nextToken();
                    
            if(isNumeric(t))
                stack.push(Double.parseDouble(t));
            else {
                double a = stack.pop();
                double b = stack.pop();
                if(t.equals("-")) {
                    stack.push(b-a);
                }
                if(t.equals("+")) {
                    stack.push(b+a);
                }
                if(t.equals("*")) {
                    stack.push(b*a);
                }
                if(t.equals("/")) {
                    stack.push(b/a);
                }
            }
            }
        return stack.pop();
    }  
}
