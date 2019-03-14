
public class Main {

    public static void main(String[] args) {
        String inputInfix = "-x+x^2*2";
        String inputInfix2 = "-x^2*3(22-2.5x)^2/0.1^-2+(x+2x)";
        StackContainer stack = new StackContainer();

        Node headInputPostfix = LinkedList.build(inputInfix, stack);
        LinkedList.toString(headInputPostfix);
        Node rootInput = Tree.build(headInputPostfix, stack);
        Tree.toString(rootInput);
        //Node rootOutput = Tree.buildDerivative(rootInput, stack);
        //String outputPostfix = Tree.unbuild(rootOutput, stack);
        //System.out.print(outputPostfix);

    }

}