package test;

import reflect.ReflectClass;

import java.lang.annotation.ElementType;

public class reflectTest {

    public static void main(String[] args) {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = Integer.class;
        Class c5 = ElementType.class;
        Class c6 = int[][].class;
        Class c7 = void.class;
        Class c8 = Class.class;
        Class c9 = Override.class;
        Class c10 = ReflectClass.class;

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);
        System.out.println(c10);
    }
}
