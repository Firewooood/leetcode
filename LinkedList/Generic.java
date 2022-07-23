package LinkedList;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Generic {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        // list.add("a"); //此处直接添加报错

        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        add.invoke(list, "kll");
        // 即实现向Integer数组中存储String
        System.out.println(list);
    }
}
