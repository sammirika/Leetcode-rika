package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;


public class ReflectClass {
    private final static String TAG = "ReflectClass";

    public static void main(String[] args) {
//        reflectNewInstance();
//        reflectPrivateConstructor();
        reflectPrivateField();


    }
    //创建实例
    public static void reflectNewInstance(){
        try{
            Class<?> classBook = Class.forName("reflect.Book");
            //创建实例
            Object objectBook = classBook.newInstance();
            Book book = (Book) objectBook;
            book.setAuthor("lihaoyu");
            book.setName("jianfei");
            System.out.println(TAG + "reflectNewInstance book is" + book.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //反射私有构造方法
    public static void reflectPrivateConstructor(){
        try{
            Class<?> classBook = Class.forName("reflect.Book");
            Constructor<?> declaredconstructorBook = classBook.getDeclaredConstructor(String.class,String.class);
            //setAccessible 反射时可以访问司有变量
            declaredconstructorBook.setAccessible(true);
            Object objectBook = declaredconstructorBook.newInstance("中高艺","nessy");
            Book book = (Book) objectBook;
            System.out.println(TAG + "reflectPrivateConstructor" + book.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 反射私有属性
    public static void reflectPrivateField() {
        try {
            Class<?> classBook = Class.forName("reflect.Book");
            Object objectBook = classBook.newInstance();
            Field fieldTag = classBook.getDeclaredField("TAG");
            fieldTag.setAccessible(true);
            String tag = (String) fieldTag.get(objectBook);
            System.out.println("reflectPrivateField tag = " + tag);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
