package SystemDesign;

import day.TreeNode;

import java.util.*;

/**
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例:
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"**
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * **/

//题目中没有明确限制使用哪一种方式遍历，所以这里使用哪一种遍历方式都是可以的用例的先序是"[1,2,null,null,3,4,null,null,5,null,null]"
public class Day_297 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Day_297 kobe = new Day_297();
        System.out.println(kobe.serialize1(root));
        TreeNode node = kobe.deserialize1(kobe.serialize(root));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                if (temp!=null){
                    System.out.print(temp.val + " ");
                }
                if (temp.left!=null){
                    queue.add(temp.left);
                }
                if (temp.right!=null){
                    queue.add(temp.right);
                }
            }
        }
    }

    private String serializeStr(TreeNode root, String str){
        //递归先序遍历
        if (root==null){
            str += "null,";
        }else {
            //逗号是为了后面还原
            str += str.valueOf(root.val) + ",";
            str = serializeStr(root.left,str);
            str = serializeStr(root.right,str);
        }
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeStr(root,"");
    }
    //list里存放的是节点的字符串表示
    private TreeNode deserializeTree(List<String> list){
        //"[1,2,null,null,3,4,null,null,5,null,null]"
        if (list.get(0).equals("null")){
            //每次删除第一个元素
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        node.left = deserializeTree(list);
        node.right = deserializeTree(list);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //以逗号分隔
        String[] array = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(array));
        return deserializeTree(list);
    }


    //也可以直接层序遍历
    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        StringBuffer str = new StringBuffer("");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        str.append(root.val+",");
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    str.append(node.left.val+",");
                    queue.add(node.left);
                }else {
                    str.append("null,");
                }
                if (node.right!=null){
                    str.append(node.right.val+",");
                    queue.add(node.right);
                }else {
                    str.append("null,");
                }
            }
        }
        return str.toString();
    }

    public TreeNode deserialize1(String data) {
        String[] nodes = data.split(",");
        TreeNode root = getNode(nodes[0]);
        Queue<TreeNode> parents = new LinkedList();
        TreeNode parent = root;
        boolean isLeft = true;
        for(int i = 1; i < nodes.length; i++){
            TreeNode cur = getNode(nodes[i]);
            if(isLeft){
                parent.left = cur;
            }else{
                parent.right = cur;
            }
            if(cur != null){
                parents.add(cur);
            }
            isLeft = !isLeft;
            if(isLeft){
                parent = parents.poll();
            }
        }
        return root;
    }

    private TreeNode getNode(String val){
        if(val.equals("null")){
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }
}
