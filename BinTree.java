/**
 * A generic binary tree class with methods for inserting, navigating, and traversing nodes.
 * @param <T> The type of data held in the tree nodes.
 */
import java.util.ArrayList;

public class BinTree<T> {
    Node<T> root;

    /**
     * Constructs an empty binary tree with a null root.
     */
    BinTree() {
        Node<T> root = null;
        this.root = root;
    }

    /**
     * Constructs a binary tree with a given root node.
     * @param n The root node of the binary tree.
     */
    BinTree(Node<T> n) {
        Node<T> root = n;
        this.root = root;
    }

    /**
     * Inserts a new node with given data into the binary tree.
     * @param node The current node being traversed.
     * @param data The data to be inserted into the new node.
     * @return The updated binary tree with the new node added.
     */
    public Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            return node;
        }
        if (node.getLeft() != null) {
            insert(node.getLeft(), data);
        } else {
            node.setLeft(new Node<>(data));
        }
        if (node.getRight() != null) {
            insert(node.getRight(), data);
        } else {
            node.setRight(new Node<>(data));
        }
        return node;
    }

    /**
     * Checks if the binary tree is empty.
     * @return True if the root node is null, false otherwise.
     */
    public boolean isEmpty() {
        if (this.root == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the root node of the binary tree.
     @return The root node of the binary tree.
     */
    public Node<T> getRoot() {
        return this.root;
    }

    /**
     * Sets the root node of the binary tree.
     * @param n The new root node of the binary tree.
     */
    public void setRoot(Node<T> n) {
        this.root = n;
    }

    /**
     * Navigates to the right child node of a given node.
     * @param current The current node being navigated.
     * @return The right child node of the given node.
     */
    public Node<T> navigateRight(Node<T> current) {
        if (current.getRight() == null) {
            System.out.println("Cannot navigate because the right child is null.");
            return current;
        } else {
            return current.getRight();
        }
    }

    /**
     * Navigates to the left child node of a given node.
     * @param current The current node being navigated.
     * @return The left child node of the given node.
     */
    public Node<T> navigateLeft(Node<T> current) {
        if (current.getLeft() == null) {
            System.out.println("Cannot navigate because the left child is null.");
            return current;
        } else {
            return current.getLeft();
        }
    }

    /**
     * Adds a new node with given data as the right child of a given node.
     * @param current The current node being navigated.
     * @param data The data to be inserted into the new node.
     * @return The updated binary tree with the new node added as the right child.
     */
    public Node<T> addNodeRight(Node<T> current, T data) {
        if (current == null) {
            setRoot(new Node<>(data));
        } else if (current.getRight() == null) {
            current.setRight(new Node<>(data));
        }
        return current;
    }

    /**
     * Adds a new node with given data as the left child of a given node.
     * @param current The current node being navigated.
     * @param data The data to be inserted into the new node.
     * @return The updated binary tree with the new node added as the left child.
     */
    public Node<T> addNodeLeft(Node<T> current, T data) {
        if (current == null) {
            setRoot(new Node<>(data));
        } else if (current.getLeft() == null) {
            current.setLeft(new Node<>(data));
        }
        return current;
    }

    /**
     * Traverses the binary search tree in infix order, starting from the specified node, recursively.
     * The student data stored in each node is added to an output array list in infix order.
     * @param node the node to start the traversal from
     * @param output the array list to store the student data in infix order
     * @return the array list containing the student data in infix order
     */
    private ArrayList<T> infixTraversalRec(Node<T> node, ArrayList<T> output) {
        if (node == null) {
            return output;
        }
        if (node.getLeft() != null) {
            infixTraversalRec(node.getLeft(), output);
        }
        output.add(node.getData());
        if (node.getRight() != null) {
            infixTraversalRec(node.getRight(), output);
        }
        return output;
    }

    /**
     * Wrapper for infixTraversalRec
     * @return
     */
    public ArrayList<T> infixTraversalW() {
        ArrayList<T> output = new ArrayList<>();
        if (this.root == null) {
            return output;
        }
        return infixTraversalRec(this.root, output);
    }

    /**
     * Returns a string representation of this binary tree. Overrides the toString() method of Object.
     * If the root is null, the output string is "{____}".
     * Otherwise, the output string is in the form "{" + toStringHelper(this.root) + "}",
     * where toStringHelper() recursively constructs a string representation of each node in the tree.
     * For each node, its data is concatenated with the string representation of its left and right subtrees (if not null) in the form "(left, right)".
     * @return a string representation of this binary tree.
     */
    @Override
    public String toString() {
        if (this.root == null) {
            return "{____}";
        }
        return "{" + toStringHelper(this.root) + "}";
    }

    /**
     * A recursive helper method that constructs a string representation of a binary tree node.
     * Concatenates the node's data with the string representation of its left and right subtrees (if not null) in the form "(left, right)".
     * @param node the node to construct a string representation for
     * @return a string representation of the node and its subtrees.
     */
    private String toStringHelper(Node<T> node) {
        String output = node.getData().toString() + "";
        if (node.getLeft() != null) {
            output += "( " + toStringHelper(node.getLeft()) + ", ";
        } else {
            output += "(____,";
        }
        if (node.getRight() != null) {
            output += " " + toStringHelper(node.getRight()) + " ";
        } else {
            output += "____)";
        }
        return output;
    }
}