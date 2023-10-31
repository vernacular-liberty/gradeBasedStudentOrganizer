/**
 * A generic class representing a node in a binary tree data structure.
 * @param <T> the type of data stored in the node
 */
public class Node<T>{
    Node<T> right;
    Node<T> left;
    T studentData;

    /**
     * Constructs a new Node object with the specified data.
     * @param studentData the data to be stored in the node
     */
    Node(T studentData){
        this.right = null;
        this.left = null;
        this.studentData = studentData;
    }

    /**
     * Returns the data stored in the node.
     * @return the data stored in the node
     */
    public T getData(){
        return this.studentData;
    }

    /**
     * Returns the right child node of the current node.
     * @return the right child node of the current node
     */
    public Node<T> getRight(){
        return this.right;
    }

    /**
     * Returns the left child node of the current node.
     * @return the left child node of the current node
     */
    public Node<T> getLeft(){
        return this.left;
    }

    /**
     * Sets the right child node of the current node.
     * @param s the node to be set as the right child
     */
    public void setRight(Node<T> s){
        this.right = s;
    }

    /**
     * Sets the left child node of the current node.
     * @param s the node to be set as the left child
     */
    public void setLeft(Node<T> s){
        this.left = s;
    }

    /**
     * Returns a string representation of the node's data and its child nodes.
     * @return a string representation of the node
     */
    @Override
    public String toString(){
        String output =  "Data: " + this.studentData.toString() + "{";
        if (this.getLeft() == null){
            output += "____,";
        } else{
            output += this.getLeft().studentData.toString() + ", ";
        }
        if (this.getRight() == null){
            output += "____}";
        } else {
            output += this.getRight().studentData.toString() + "}";
        }
        return output;
    }
}