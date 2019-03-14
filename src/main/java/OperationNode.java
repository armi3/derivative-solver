

public class OperationNode extends Node {
    private Node parent;
    private Node right;
    private Node left;
    private char content;

    OperationNode(char content){
        super();
        this.parent = null;
        this.right = null;
        this.left = null;
        this.content = content;
    }

    @Override
    public Node getParent() {
        return parent;
    }

    @Override
    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public Node getRight() {
        return right;
    }

    @Override
    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public Node getLeft() {
        return left;
    }

    @Override
    public void setLeft(Node left) {
        this.left = left;
    }

    @Override
    public char getContent() {
        return content;
    }

    @Override
    public void setContent(char content) {
        this.content = content;
    }
}
