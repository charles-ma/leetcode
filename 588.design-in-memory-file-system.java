/*
 * @lc app=leetcode id=588 lang=java
 *
 * [588] Design In-Memory File System
 */

// @lc code=start
class FileSystem {

    private Node root;
    
    public FileSystem() {
        root = new Node();
    }
    
    public List<String> ls(String path) {
        List<String> result = new ArrayList<String>();
        
        Node n = findPath(path);
        if (n == null) return result;

        if (!n.content.isEmpty()) {
            result.add(n.fileName);
        } else {
            for (String key : n.children.keySet()) result.add(key);
        }

        return result;
    }
    
    public void mkdir(String path) {
        addPath(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        Node n = addPath(filePath);
        n.content += content;
    }
    
    public String readContentFromFile(String filePath) {
        Node n = findPath(filePath);
        return n == null ? "" : n.content;
    }

    private Node findPath(String path) {
        return findPath(root, path.split("/"), false);
    }

    private Node addPath(String path) {
        return findPath(root, path.split("/"), true);
    }

    private Node findPath(Node root, String[] names, boolean edit) {
        if (names.length == 0) return root;

        String name = names[0];
        if (name.equals(""))
            return findPath(root, Arrays.copyOfRange(names, 1, names.length), edit);
        
        if (!edit && !root.children.containsKey(name)) return null;

        Node child = root.children.getOrDefault(name, new Node("", name));
        root.children.put(name, child);
        return findPath(child, Arrays.copyOfRange(names, 1, names.length), edit);
    }
}

class Node {
    Map<String, Node> children = new TreeMap<String, Node>();
    String content = "";
    String fileName = "";

    Node(String... params) {
        if (params.length >= 1) content = params[0];
        if (params.length >= 2) fileName = params[1];
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
// @lc code=end
