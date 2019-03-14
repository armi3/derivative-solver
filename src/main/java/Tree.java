

public interface Tree {

    static Node build(Node headInputPostfix, StackContainer stack) {
        stack.clear();
        Node currentNode = headInputPostfix;
        Node nextNode = headInputPostfix.getRight();

        while(currentNode!=nextNode){
            if (Parser.isOperator(currentNode.getContent())){
                currentNode.setRight(stack.out());
                currentNode.setLeft(stack.out());
            }
            else if (Parser.isValue(currentNode.getContent())){

            }
            else {

            }

        }


        //Node root = stack.out();
        return stack.out();
    }

    static Node buildDerivative(Node rootInput, StackContainer stack) {
        stack.clear();
        return rootInput;
        //return rootOutput;

    }

    static String unbuild(Node rootOutput, StackContainer stack){
        stack.clear();
        return null;

    }
}
