package example;
//
//  could not solve this: then I looked at the solution what is stack based and it is much simpler
//
public class Ch007ValidParen {
    public static void main(String[] args) {
        String inpStr = "";
        inpStr = "()" ; System.out.println("is given balanced |" + inpStr + "| expected true - actual " + isBalanced(inpStr));
        inpStr = "())" ; System.out.println("is given balanced |" + inpStr + "| expected false - actual " + isBalanced(inpStr));
        inpStr = "(()))(" ; System.out.println("is given balanced |" + inpStr + "| expected false - actual " + isBalanced(inpStr));
        inpStr = "(()))[" ; System.out.println("is given balanced |" + inpStr + "| expected false - actual " + isBalanced(inpStr));
        inpStr = "(())[]{{}}" ; System.out.println("is given balanced |" + inpStr + "| expected true - actual " + isBalanced(inpStr));
        inpStr = "[{}]" ; System.out.println("is given balanced |" + inpStr + "| expected true - actual " + isBalanced(inpStr));
        inpStr = "(())[[]{{}}]" ; System.out.println("is given balanced |" + inpStr + "| expected true - actual " + isBalanced(inpStr));
        inpStr = "([)]" ; System.out.println("is given balanced |" + inpStr + "| expected false - actual " + isBalanced(inpStr));
    }

    public static boolean isBalanced(String inpString) {
        return isBalanced(inpString,  0, 0,0, 0, inpString.length());
    }



    private static boolean isBalanced(String charArray, int pA, int pB, int pC, int pos, int len) {
        if (pos == (len)) return (pA + pB + pC) == 0;
        char prev = (pos != 0 ) ? charArray.charAt(pos - 1) : '|' ;
        switch (charArray.charAt(pos)) {
            case '{' -> pA++;
            case '}' -> {
                if (pA == 0 ) return false; // closing bracket before opening
                pA--;
                if (pos != 0 && pA == 0 &&  ('[' == prev || '(' == prev )) return false; // case: {[}

            }
            case '(' -> pB++;
            case ')' -> {
                if (pB == 0 ) return false;
                pB--;
                if (pos != 0 && pB == 0 &&  ('[' == prev || '{' == prev )) return false; // case: {[}

            }
            case '[' -> pC++;
            case ']' -> {
                if (pC == 0 ) return false;
                pC--;
                if (pos != 0 && pC == 0 &&  ('(' == prev || '{' == prev )) return false; // case: {[}

            }
        }

        return isBalanced(charArray, pA, pB, pC, pos + 1, len);
    }
}

