package test.binaryTree;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/14 14:26 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class BinaryTreeUtils {

    //二叉树递归遍历

    /**
     * 后序
     *
     * @param node
     */
    public void postOrder(Node node) {
        if (node == null) {
            return;
        } else {
            postOrder(node.getLeftChild());
            postOrder(node.getRightChild());
            System.out.print(node.getData() + " ");
        }
    }

    /**
     * 中序
     *
     * @param node
     */
    public static void inOrder(Node node) {
        if (null == node) {
            return;
        } else {
            inOrder(node.getLeftChild());
            System.out.println(node.getData() + " ");
            inOrder(node.getRightChild());
        }
    }

    /**
     * 先序
     *
     * @param node
     */
    public static void preOrder(Node node) {
        //递归实现
        if (null == node) {
            return;
        } else {
            System.err.println(node.getData() + " ");
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
        //非递归实现
        //TODO 利用一个栈，先序遍历即为根先入栈，然后出栈，凡是出栈的元素都打印值
        Node[] nodes = new Node[3];
        Node tmp;
        int level = -1;
        if (null != node) {
            level++;
            nodes[level] = node;
            while (level > -1) {
                tmp = nodes[level];
                level--;
                System.out.println(tmp.getData() + " ");
                if (null != tmp.getRightChild()) {
                    level++;
                    nodes[level] = tmp.getRightChild();
                }
                if (null != tmp.getLeftChild()) {
                    level++;
                    nodes[level] = tmp.getLeftChild();
                }
            }
        }
    }

    /**
     * @param exp A(B(D(,G)),C(E,F))
     * @return
     */
    public static Node createTreeWhileFor(String exp) {
        Node result = null;
        Node tmp = null;
        Node[] nodes = new Node[3];
        char[] exps = exp.toCharArray();
        int level = -1;//二叉树层级
        int direction = 0;//左叉（1）或右叉（2）
        for (int i = 0; i < exps.length; i++) {
            char c = exps[i];
            switch (c) {
                case '(':
                    level++;
                    direction = 1;//左叉
                    nodes[level] = tmp;
                    break;
                case ')':
                    level--;
                    break;
                case ',':
                    direction = 2;//右叉
                    break;
                default:
                    //字母
                    tmp = new Node(c, null, null);
                    if (direction == 0) {
                        result = tmp;
                    } else if (direction == 1) {
                        nodes[level].setLeftChild(tmp);
                    } else if (direction == 2) {
                        nodes[level].setRightChild(tmp);
                    }
            }
        }
        return result;
    }

    /**
     * @param exp A(B(D(,G)),C(E,F))
     * @return
     */
    public static Node createTreeWithWhile(String exp) {
        Node[] nodes = new Node[3];
        Node result, tmp = null;
        int level = -1, direction = 0;
        char[] exps = exp.toCharArray();
        result = null;
        for (int i = 0; i < exps.length; i++) {
            char data = exps[i];
            switch (data) {
                case '(':
                    level++;
                    nodes[level] = tmp;
                    direction = 1;
                    break;
                case ')':
                    level--;
                    break;
                case ',':
                    direction = 2;
                    break;
                default:
                    tmp = new Node(data, null, null);
                    if (null == result) {
                        result = tmp;
                    } else {
                        switch (direction) {
                            case 1:
                                nodes[level].setLeftChild(tmp);
                                break;
                            case 2:
                                nodes[level].setRightChild(tmp);
                                break;
                        }
                    }
            }
        }
        return result;
    }

}
