package done;import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
public class maxDepth {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    
    public int maxDepth1(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.push(root);
        int res = 0;
        while (deque.isEmpty()) {
            res++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node cur = deque.removeFirst();
                List<Node> list = cur.children;
                if (list.size() != 0) {
                    for (int j = 0; j < list.size(); j++) {
                        deque.addLast(list.get(j));
                    }
                }
            }
        }
        return res;
    }
}
