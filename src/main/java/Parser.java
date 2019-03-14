

public interface Parser {
    static boolean isOperator(char charToEvaluate) {
        if (charToEvaluate == '+' || charToEvaluate == '-' || charToEvaluate == '*' || charToEvaluate == '/' || charToEvaluate == '^') {
            return true;
        } else {
            return false;
        }
    }

    static boolean isValue(char charToEvaluate) {
        if (charToEvaluate == '0' || charToEvaluate == '1' || charToEvaluate == '2' || charToEvaluate == '3' || charToEvaluate == '4' || charToEvaluate == '5' || charToEvaluate == '6' || charToEvaluate == '7' || charToEvaluate == '8' || charToEvaluate == '9' || charToEvaluate == '.') {
            return true;
        } else {
            return false;
        }
    }

    static boolean isUnary(char[] inputInfixArray, int i) {
        if((!isOperator(inputInfixArray[i-1]) && !isOperator(inputInfixArray[i+1]))
                || (!isOperator(inputInfixArray[i-1]) && inputInfixArray[i+1]=='(')
                || (inputInfixArray[i-1]==')' && !isOperator(inputInfixArray[i+1]))
                || (inputInfixArray[i-1]==')' && inputInfixArray[i-1]=='(')) {
            return false;
        } else {
            return true;
        }
    }

    static boolean isGreater(char charToEvaluate, char charStacked){
        boolean result = false;
        switch (charToEvaluate){
            case '+':
                switch (charStacked){
                    case '+': result = false;break;
                    case '-': result = false;break;
                    case '*': result = false;break;
                    case '/': result = false;break;
                    case '^': result = false;break;
                    default:
                }
                break;
            case '-':
                switch (charStacked){
                    case '+': result = false;break;
                    case '-': result = false;break;
                    case '*': result = false;break;
                    case '/': result = false;break;
                    case '^': result = false;break;
                    default:
                }
                break;
            case '*':
                switch (charStacked){
                    case '+': result = true;break;
                    case '-': result = true;break;
                    case '*': result = false;break;
                    case '/': result = false;break;
                    case '^': result = false;break;
                    default:
                }
                break;
            case '/':
                switch (charStacked){
                    case '+': result = true;break;
                    case '-': result = true;break;
                    case '*': result = false;break;
                    case '/': result = false;break;
                    case '^': result = false;break;
                    default:
                }
                break;
            case '^':
                switch (charStacked){
                    case '+': result = true;break;
                    case '-': result = true;break;
                    case '*': result = true;break;
                    case '/': result = true;break;
                    case '^': result = false;break;
                    default:
                }
                break;
            default:
        }
        return result;
    }

}
