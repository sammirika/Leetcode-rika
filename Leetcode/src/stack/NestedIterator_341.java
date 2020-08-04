package stack;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 *
 * ***/
public class NestedIterator_341 implements Iterator {

    //定义两个栈，一个存列表，一个存栈
    Stack<NestedInteger> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    //定义一个方法来把nestedlist中的所有元素压进整型栈中
    public void getStack(Stack<NestedInteger> stack1, Stack<Integer> stack2){
        while (!stack1.isEmpty()){
            NestedInteger nestedInteger = stack1.pop();
            if (nestedInteger.isInteger()){
                stack2.push(nestedInteger.getInteger());
            }else {
                //利用接口中的getList方法
                for (NestedInteger e:nestedInteger.getList()){
                    stack1.push(e);
                }
            }
        }
    }

    //nestedList定义再另外的接口中，接口中提供了三个方法，判断整形，获取整形，获取嵌套列表
    public NestedIterator_341(List<NestedInteger> nestedList) {
        //遍历整型直接存进stack2 其他型存进stack2
        for (NestedInteger e:nestedList){
            stack1.push(e);
        }
        getStack(stack1,stack2);

    }

    @Override
    public Integer next() {
        return stack2.pop();
    }

    @Override
    public boolean hasNext() {
        return !stack2.isEmpty();
    }
}
