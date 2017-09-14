package test.binaryTree;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/14 14:29 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class Test {

    public static void main(String[] args) {
        String exp = "A(B(D(,G)),C(E,F))";
        Node tree = BinaryTreeUtils.createTreeWithWhile(exp);
        System.out.println("BinaryTree 创建：" + tree);
        Node result = BinaryTreeUtils.createTreeWhileFor(exp);
        System.out.println("BinaryTree 创建：" + result);

        //先序打印
        BinaryTreeUtils.preOrder(result);
        //中序打印
        BinaryTreeUtils.inOrder(result);

    }

}
