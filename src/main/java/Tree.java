

public interface Tree {

    static Node build(Node headInputPostfix, StackContainer stack) {
        stack.clear();
        Node currentNode = headInputPostfix;
        Node nextNode = headInputPostfix.getRight();

        if(currentNode!=nextNode){
            do{
                if (Parser.isOperator(currentNode.getContent().charAt(0))){
                    currentNode.setRight(stack.out());
                    currentNode.setLeft(stack.out());
                    stack.in(currentNode);
                }
                else if (Parser.isValue(currentNode.getContent().charAt(0))){
                    stack.in(currentNode);
                }
                else {
                    stack.in(currentNode);
                }
                currentNode = nextNode;
                nextNode = currentNode.getRight();
            } while(currentNode!=nextNode);
            currentNode.setRight(stack.out());
            currentNode.setLeft(stack.out());
            stack.in(currentNode);
        }
        else {
            return currentNode;
        }
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

    static void toString(Node root){
        System.out.print(root.toString());
        if(root!=root.getRight()){
            toString(root.getLeft());
            toString(root.getRight());
        }
    }
}
