package day;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Unil {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

//        ArrayList<Integer> list = new ArrayList();
//        list.add(1234);
//        Class<?> clazz = Class.forName("java.util.ArrayList");
//        Field elementData = clazz.getDeclaredField("elementData");
//        elementData.setAccessible(true);
//
//        Object[] array = (Object[]) elementData.get(list);
//        System.out.println("Arraylist 容量大小: " + array.length);
//
//        StringBuffer str = new StringBuffer();
//        System.out.println(" Stringbuffer 容量"+str.capacity());

//        Integer v1 = new Integer(100);
//        Integer v2 = new Integer(100);
//        Integer v3 = new Integer(150);
//        Integer v4 = new Integer(150);
//        System.out.println(v1==v2);
//        System.out.println(v3==v4);
//        System.out.println(v3==150);
//
        int count = 0;
        for(double x=0.0d;x<10.0d;x+=0.1d){
            count++;
        }
        System.out.println(count);


    }
}
