package example;

public class Ch007ValidParen {
    public static void main(String[] args) {
        String inpStr = "";
        inpStr = "()" ; System.out.println("is given balanced |" + inpStr + "| expected true - actual " + isBalanced(inpStr));
        inpStr = "())" ; System.out.println("is given balanced |" + inpStr + "| expected false - actual " + isBalanced(inpStr));
        inpStr = "(()))(" ; System.out.println("is given balanced |" + inpStr + "| expected false - actual " + isBalanced(inpStr));
        inpStr = "(()))[" ; System.out.println("is given balanced |" + inpStr + "| expected false - actual " + isBalanced(inpStr));
        inpStr = "(())[]{{}}" ; System.out.println("is given balanced |" + inpStr + "| expected true - actual " + isBalanced(inpStr));
        inpStr = "(())[[]{{}}]" ; System.out.println("is given balanced |" + inpStr + "| expected true - actual " + isBalanced(inpStr));
    }

    public static boolean isBalanced(String inpString) {
        return isBalanced(inpString,  0, 0,0, 0, inpString.length());
    }

    private static boolean isBalanced(String charArray, int pA, int pB, int pC, int pos, int len) {
        if (pos == (len)) return (pA + pB + pC) == 0;

        switch (charArray.charAt(pos)) {
            case '{' -> pA++;
            case '}' -> {
                if (pA == 0) return false;
                else pA--;
            }
            case '(' -> pB++;
            case ')' -> {
                if (pB == 0) return false;
                else pB--;
            }
            case '[' -> pC++;
            case ']' -> {
                if (pC == 0) return false;
                else pC--;
            }
        }

        return isBalanced(charArray, pA, pB, pC, pos + 1, len);
    }
}

