import java.util.*;

public class FindSNode {
    private Set<Node> set = new HashSet<Node>();
    private Set<Node> visited = new HashSet<Node>();
    private Node r;
    
    public static void main(String... args) {
        FindSNode f = new FindSNode();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.children.add(n2);
        n1.children.add(n3);
        n2.children.add(n4);
        n3.children.add(n5);
        // n3.children.add(n1);
        n4.children.add(n1);
        
        Set<Node> s = f.solve(n1);
        for (Node n : s) System.out.println(n.value);
    }

    public Set<Node> solve(Node root) {
        r = root;
        helper(root, new ArrayList<Node>());
        return set;
    }

    private void helper(Node root, List<Node> curr) {
        if (root == null) return;
                
        if (visited.contains(root)) {
            if (root == r) {
                for (Node n : curr) set.add(n);
            }
            return;
        }

        visited.add(root);
        if (root.children != null) {
            curr.add(root);
            for (Node n : root.children) {
                helper(n, curr);
            }
            curr.remove(curr.size() - 1);
        }
        visited.remove(root);
    }
}

class Node {
    int value;
    List<Node> children;
    Node(int value) {
        this.value = value;
        children = new ArrayList<Node>();
    }
}
