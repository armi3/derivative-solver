

public abstract class Node {
    private Node parent;
    private Node right;
    private Node left;
    private char content;

    public Node getParent() {
        return parent;
    }
    public Node getRight() {
        return right;
    }
    public Node getLeft() {
        return left;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public char getContent() {
        return content;
    }
    public void setContent(char content) {
        this.content = content;
    }
}
