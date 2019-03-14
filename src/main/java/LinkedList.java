
public interface LinkedList {

    //-x^2*3(22-2.5x)^2/0.1^-2+(x+2x)
    static Node build(String inputInfix, StackContainer stack) {
        stack.clear();
        String valueBeingCaptured = "";
        boolean nextIsSigned = false;
        char[] inputInfixArray = inputInfix.toCharArray();
        Node headInputPostfix = new ValueNode(0);

        for (int i = 0; i < inputInfixArray.length; i++) {

            if (Parser.isValue(inputInfixArray[i])) {
                valueBeingCaptured += inputInfixArray[i];

                while (Parser.isValue(inputInfixArray[i + 1])) {
                    valueBeingCaptured += inputInfixArray[i + 1];
                    i++;
                }
                ValueNode node = new ValueNode(Double.parseDouble(valueBeingCaptured));
                if (nextIsSigned) {
                    node.setValue(node.getValue() * -1);
                    nextIsSigned = false;
                }
                addToLinkedList(headInputPostfix, node);
                valueBeingCaptured = "";
            }

            else if (inputInfixArray[i] == 'x') {
                VariableNode node = new VariableNode(inputInfixArray[i]);
                if (nextIsSigned) {
                    node.setNegative(!node.isNegative());
                    nextIsSigned = false;
                }
                addToLinkedList(headInputPostfix, node);
            }

            else if (Parser.isOperator(inputInfixArray[i])) {

                if (inputInfixArray[i] == '-' && Parser.isUnary(inputInfixArray, i)) {
                    nextIsSigned = true;
                }
                else {
                    OperationNode node = new OperationNode(inputInfixArray[i]);
                    while (stack.look().getContent() == '(') {
                        stack.out();
                    }
                    if(Parser.isGreater(inputInfixArray[i], stack.look().getContent())){
                        stack.in(node);
                    } else{
                        addToLinkedList(headInputPostfix, stack.out());
                        stack.in(node);
                    }
                }
            }

            else if(inputInfixArray[i]=='(') {
                OperationNode node = new OperationNode(inputInfixArray[i]);
                stack.in(node);
            }

            else if(inputInfixArray[i]==')') {
                while (stack.look().getContent() == '(') {
                    stack.out();
                }
                if (stack.getDynamicSize()!=0) {
                    addToLinkedList(headInputPostfix, stack.out());
                }
            }
        }

        while(stack.getDynamicSize()!=0){
            addToLinkedList(headInputPostfix, stack.out());
        }
        return headInputPostfix;
    }

    // adds node to the right of the last node (singly linked list)
    // se mete ya con el subtipo de nodo que es, DUH
    static void addToLinkedList(Node head, Node node){
        if (head.getRight()==null){
            node.setRight(node);
            head = node;
        }
        else if (head.getRight()==head){
            node.setLeft(head);
            node.setRight(node);
            head.setRight(node);
        }
        else {
            node.setRight(node);
            Node lastNode = head.getRight();
            while(lastNode.getRight()!=lastNode){
                node.setLeft(lastNode);
                lastNode = lastNode.getRight();
            }
            node.getLeft().setRight(node);
        }
    }

    static int lengthOfLinkedList(Node head){
        int length =0;
        while(head.getRight()!=head){
            length++;
        }
        return length;
    }

}
