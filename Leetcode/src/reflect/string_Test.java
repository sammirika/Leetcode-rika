package reflect;

import java.lang.reflect.Field;

public class string_Test {
    public static void main(String[] args) {
        String str = "hello nessy";
        System.out.println(str);

        //string的值虽然是final但是可以通过反射来改变
        try{
            //获取String类中的私有数组变量
            Field field = String.class.getDeclaredField("value");
            field.setAccessible(true);
            char[] array = (char[]) field.get(str);
            array[5] = '_';
            System.out.println(str);
        }catch (NoSuchFieldException | IllegalAccessException e1){
            e1.printStackTrace();
        }
    }
}
