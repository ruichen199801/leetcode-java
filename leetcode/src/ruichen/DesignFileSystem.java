package ruichen;

import java.util.HashMap;
import java.util.Map;

public class DesignFileSystem {
    // createPath(): TC = O(n), SC = O(n) worst case
    // get(): TC = O(n), SC = O(1)
    class FileSystem {
        private Node root;

        public FileSystem() {
            root = new Node(-1);
        }

        public boolean createPath(String path, int value) {
            // Return false when parent does not exist, or provided full path already exists.
            // "/a/b" -> ["", "a", "b"]
            String[] dirs = path.split("/");
            Node curr = root;

            for (int i = 1; i < dirs.length - 1; i++) {
                String dir = dirs[i];
                if (!curr.children.containsKey(dir)) {
                    return false; // Parent does not exist
                }
                curr = curr.children.get(dir);
            }

            String lastDir = dirs[dirs.length - 1];
            if (curr.children.containsKey(lastDir)) {
                return false; // The path already exists
            }

            // Create the node
            curr.children.put(lastDir, new Node(value));

            return true;
        }

        public int get(String path) {
            String[] dirs = path.split("/");
            Node curr = root;

            for (int i = 1; i < dirs.length; i++) {
                String dir = dirs[i];
                if (!curr.children.containsKey(dir)) {
                    return -1;
                }
                curr = curr.children.get(dir);
            }

            return curr.value;
        }

        class Node {
            Map<String, Node> children;
            int value;

            public Node(int value) {
                children = new HashMap<>();
                this.value = value;
            }
        }
    }
}
