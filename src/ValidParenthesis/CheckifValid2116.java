package ValidParenthesis;

import java.util.Stack;

public class CheckifValid2116 {
    public static boolean canBeValid(String s, String locked) {

        Stack<Integer> open = new Stack<>();
        Stack<Integer> zero = new Stack<>();

        for(int i = 0; i< s.length();i++)
        {
            if(locked.charAt(i) == '0') zero.push(i);
            else if(s.charAt(i) == '(') open.push(i);
            else {
                if(!open.isEmpty()) open.pop();
                else if(!zero.isEmpty()) zero.pop();
                else return false;
            }
        }

        while(!open.isEmpty() && !zero.isEmpty() && open.peek() < zero.peek())
        {
            open.pop();
            zero.pop();
        }

        if(!zero.isEmpty()) return zero.size()%2==0;


        return open.isEmpty();

    }

    public static void main(String[] args) {

        String s = "))()))", locked = "010100";
        System.out.println(canBeValid(s, locked));
    }
}
