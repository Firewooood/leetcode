package algorithm;

public class morris {
    public class Node {
        int val;
        Node right;
        Node left;
    }



    public static void morris(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null; //记录左子树上的最右节点
        while (cur != null) {
            mostRight = cur.left; //mostRight是cur的左孩子
            if (mostRight != null) {
                //有左子树的情况
                while (mostRight.right != null && mostRight.right != cur) {
                    //一直向下遍历，直到找到左子树上最右节点。
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    //第一次来到cur处
                    mostRight.right = cur; //将mostRight的右指针指向cur
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null; //若mostRight的右指针指向cur，则将其指向空
                }
            }
            cur = cur.right;
        }
    }


    //先序遍历
    public static void morrisPre(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null; // 记录左子树上的最右节点
        while (cur != null) {
            mostRight = cur.left; // mostRight是cur的左孩子
            if (mostRight != null) {
                // 有左子树的情况
                while (mostRight.right != null && mostRight.right != cur) {
                    // 一直向下遍历，直到找到左子树上最右节点。
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    // 第一次来到cur处
                    mostRight.right = cur; // 将mostRight的右指针指向cur
                    // *************此处打印，节点可到达两次，第一次访问时打印
                    System.out.println(cur.val + " ");
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null; // 若mostRight的右指针指向cur，则将其指向空
                }
            } else { //**************当前节点无左子树，直接打印
                System.out.println(cur.val + " ");
            }
            cur = cur.right;
        }
    }
    
    //中序遍历
    public static void morrisIn(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null; // 记录左子树上的最右节点
        while (cur != null) {
            mostRight = cur.left; // mostRight是cur的左孩子
            if (mostRight != null) {
                // 有左子树的情况
                while (mostRight.right != null && mostRight.right != cur) {
                    // 一直向下遍历，直到找到左子树上最右节点。
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    // 第一次来到cur处
                    mostRight.right = cur; // 将mostRight的右指针指向cur
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null; // 若mostRight的右指针指向cur，则将其指向空
                }
            }
            //*****************此处打印，无左子树 和 节点可到达两次，到达第二次时  打印 */
            System.out.println(cur.val + " ");
            cur = cur.right;
        }
    }

    //后序打印
    public static void morrisPos(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    /************************ 此处打印
                     * 可到达两次的节点，打印左树的右边界
                    */
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        //结尾时打印头节点的右边界
        printEdge(head);
        System.out.println();
    }

    public static void printEdge(Node node) {
        //逆序打印dang'qian
        Node tail = reverseEdge(node);
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        } 
        reverseEdge(tail);
    }

    public static Node reverseEdge(Node node) {
        Node pre = null;
        Node next = null;
        while (node != null) {
            //将pre 右节点的右指针指向 node 
            next = node.right;
            node.right = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

}
