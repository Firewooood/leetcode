package done;import java.util.ArrayList;
import java.util.List;

public class MapSum {
    class TireNode {
        int val = 0;
        int sum;
        TireNode[] children = new TireNode[26];
    }

    TireNode root;
    public MapSum() {
        root = new TireNode();
    }

    public void insert(String key, int val) {
        TireNode cur = root;
        List<TireNode> repo = new ArrayList<>(key.length());
        for (int i = 0; i < key.length(); i++) {
            int w = key.charAt(i) - 'a';
            TireNode n = cur.children[w];
            if (cur.children[w] == null) {
                n = cur.children[w] = new TireNode();
            }
            //若当前字母未出现过，则将其设为子节点，若出现过，则代入已出现的节点
            repo.add(n); //将当前key加入数列repo
            cur = n;
        }
        int v = val - cur.val; //当两个key值相等时，需要取后一key的val
        cur.val = val;
        for (TireNode n : repo) {
            n.sum += v; //由repo记录刚加入的tireNode，现给每一tireNode加入前缀和
        }
    }

    public int sum(String prefix) {
        int len = prefix.length();
        TireNode cur = root;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int w = prefix.charAt(i) - 'a';
            if (cur.children[w] == null) {
                return 0;
            }
            cur = cur.children[w];
            sum = cur.sum;
        }
        //遍历到前缀的最后一节点，
        return sum;
    }

    /**
     * Your MapSum object will be instantiated and called as such: 
     * MapSum obj = new MapSum(); 
     * obj.insert(key,val); 
     * int param_2 = obj.sum(prefix);
     */
    public static void main(String[] args) {
        
    }
}
