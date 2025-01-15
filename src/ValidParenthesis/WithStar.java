package ValidParenthesis;

class WithStar {
    public static boolean checkValidString(String s) {

        int open = 0, star = 0;

        for(char brack: s.toCharArray())
        {
            if(brack == '(') open++;
            else if(brack == '*') star++;
            else
            {
                if(open > 0) open --;
                else if(star > 0) star --;
                else return false;
            }
        }

        System.out.println(open+" : "+star);

        if (open > 0) {
            if (open > star) return false;
            open = 0;
            star = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == ')') open++;
                else if (s.charAt(i) == '*') star++;
                else {
                    if (open > 0) open--;
                    else if (star > 0) star--;
                    else return false;
                }
            }

            System.out.println(open+" : "+star);
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "(*))";
        System.out.println(checkValidString(s));

    }
}
