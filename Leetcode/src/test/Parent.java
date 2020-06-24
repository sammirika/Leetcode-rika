package test;

public class Parent {
    public String Base = "101";

    public void doSomething(){

        System.out.println("parent");
    }
}

class Child extends Parent{
    public String Base = "100";


    @Override
    public void doSomething() {
        System.out.println("child");
    }

    public static void main(String[] args) {
        Parent child = new Child();
        System.out.println(((Child) child).Base);
        child.doSomething();
    }
}

