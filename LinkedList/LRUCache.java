package LinkedList;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {
    int capacity;
    HashMap<Integer, Integer> map;
    LinkedList<Integer> list;
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Integer>();
        // 初始化一个大小为capacity的双向链表
        list = new LinkedList<Integer>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.isEmpty() || !map.containsKey(key))
            return -1; // 当前列表为空 或 不存在key时，返回-1；
        // 从链表中找到key的节点，将其移到最前面。
        list.removeFirstOccurrence(key);
        list.addFirst(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key))
        {
            list.removeFirstOccurrence(key);
            list.addFirst(key);
            map.put(key, value);
        }
        else if (capacity > 0) {
            // 当前LRU缓存未满
            list.removeFirstOccurrence(key);
            list.addFirst(key);
            map.put(key, value);
            this.capacity--; // 缓存大小减一
        } else {
            // 当前LRU已满
            // 当前插入的key 原列表中没有，则删除列表尾，并将当前key value加入列表头
            map.remove(list.getLast());
            list.removeLast();
            list.addFirst(key);
            map.put(key, value);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
