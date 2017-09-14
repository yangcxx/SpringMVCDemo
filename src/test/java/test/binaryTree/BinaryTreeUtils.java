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

    /**
     * @param exp A(B(D(,G)),C(E,F))
     * @return
     */
    public static Node createTree(String exp) {
        Node[] nodes = new Node[3];
        Node b, p = null;
        int level = -1, k = 0, j = 0;
        char[] exps = exp.toCharArray();
        char data = exps[j];
        b = null;
        while (j < exps.length - 1) {
            switch (data) {
                case '(':
                    level++;
                    nodes[level] = p;
                    k = 1;
                    break;
                case ')':
                    level--;
                    break;
                case ',':
                    k = 2;
                    break;
                default:
                    p = new Node(data, null, null);
                    if (null == b) {
                        b = p;
                    } else {
                        switch (k) {
                            case 1:
                                nodes[level].setLeftChild(p);
                                break;
                            case 2:
                                nodes[level].setRightChild(p);
                                break;
                        }
                    }
            }
            j++;
            data = exps[j];
        }
        return b;
    }

}
