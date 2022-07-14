public class TreeTraverseWithParentRef {
    public static void main(String... args) {
        Node root = new Node(0, null, null, null);
        Node c1 = new Node(1, root, null, null);
        Node c2 = new Node(2, root, null, null);
        root.left = c1;
        root.right = c2;
        Node c3 = new Node(3, c2, null, null);
        Node c4 = new Node(4, c2, null, null);
        c2.left = c3;
        c2.right = c4;
        Node c5 = new Node(5, c1, null, null);
        c1.left = c5;

        new TreeTraverseWithParentRef().traverse(root);
    }

    private void traverse(Node root) {
        Node p = root;
        while (p != null) {
            while (p.left != null) p = p.left;
            System.out.println(p.value);
            if (p.right != null) p = p.right;
            else {
                while (true) {
                    Node parent = p.parent;
                    if (parent == null) return;
                    
                    if (p == parent.left) {
                        System.out.println(parent.value);
                        p = parent.right;
                        if (p == null) p = parent;
                        else break;
                    } else {
                        p = parent;
                    }
                }
            }
        }
    }
}

class Node {
    int value;
    Node parent;
    Node left;
    Node right;

    Node(int value, Node p, Node l, Node r) {
        this.value = value;
        parent = p;
        left = l;
        right = r;
    }
}
