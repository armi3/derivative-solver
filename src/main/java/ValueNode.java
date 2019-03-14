

public class ValueNode extends Node{
    private Node parent;
    private Node right;
    private Node left;
    private double value;
    private String content;

    ValueNode(double value){
        super();
        this.parent = null;
        this.right = null;
        this.left = null;
        this.value = value;
        this.content = "";
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }
}
