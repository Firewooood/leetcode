package done;
import java.util.ArrayDeque;
import java.util.Deque;

public class simplifyPath {
    public static void main(String[] args) {
        simplifyPath s1 = new simplifyPath();
        String path = "/a/./b/../../c/";
        System.out.println(s1.s1(path));
    }
    
    /**
     * 一个点 . 代表当前目录本身，两个点..表示将目录切换至上一级，
     * 任意多个连续斜杠//可被视为单个斜杠/
     * 请注意，返回的 规范路径 必须遵循下述格式：
     * 
     * 始终以斜杠 '/' 开头。
     * 两个目录名之间必须只有一个斜杠 '/' 。
     * 最后一个目录名（如果存在）不能 以 '/' 结尾。
     * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
     * 返回简化后得到的 规范路径 。
     * 
     * @param path
     * @return
     */

    public String s1(String path) {
        Deque<String> d = new ArrayDeque<>();
        int n = path.length();
        for (int i = 1; i < n;) {
            if (path.charAt(i) == '/' && ++i >= 0)
                continue;
            int j = i + 1;
            while (j < n && path.charAt(j) != '/')
                j++;
            String item = path.substring(i, j);
            //将有效的文件名作为单位处理，上述操作将item提取出来.
            if (item.equals("..")) {
                if (!d.isEmpty())
                    d.pollLast();      //item 为 ..  弹出上一入队的元素
            } else if (!item.equals(".")) // item 为. 不做处理
            {
                d.addLast(item); //item 为有效值，将其存入栈中
            }
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        while (!d.isEmpty())
            sb.append("/" + d.pollFirst());

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
