package day;

public class Main {
    public static void main(String[] args) {
        SeniorClass juniorClass = new JuniorClass();
        System.out.println(juniorClass.toString());
    }
}
class SeniorClass {
    public SeniorClass(){
        this.toString();
    }

    @Override
    public String toString() {
        return "IamSeniorclass";
    }
}

class JuniorClass extends SeniorClass {
    public  String name = "siwa";

    public JuniorClass() {
        super();
        name = "day.JuniorClass";
    }

    public JuniorClass(String nameA){
        name = nameA;
    }

    @Override
    public String toString() {
        return name.toUpperCase();
    }
}
