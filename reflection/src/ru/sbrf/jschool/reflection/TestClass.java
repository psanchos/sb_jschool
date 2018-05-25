package ru.sbrf.jschool.reflection;

/**
 * Created by SBT-Pozdnyakov-AN on 24.05.2018.
 */
public class TestClass {
    private String field1;
    private final String CONST="I'M CONSTANT";

    public TestClass(String field1) {
        this.field1 = field1;
    }

    public String  getField(){
        return field1;
    }

    public void printSomeWord(){
        System.out.println("hello");
    }
    private void privateMethod(){
        System.out.println("private function");
    }
    protected void protectedMethod(){

    }
}
