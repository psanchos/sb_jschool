package ru.sbrf.jschool.reflection;

/**
 * Created by SBT-Pozdnyakov-AN on 24.05.2018.
 */
public class ChildTestClass extends TestClass {
    private ChildTestClass(String field1) {
        super(field1);
    }

    @Override
    public void protectedMethod() {
        super.protectedMethod();
    }
}
