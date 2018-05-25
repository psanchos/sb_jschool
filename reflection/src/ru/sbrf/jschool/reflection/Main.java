package ru.sbrf.jschool.reflection;

import java.lang.reflect.*;
import java.util.ArrayList;

/**
 * Created by SBT-Pozdnyakov-AN on 24.05.2018.
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        TestClass object = new TestClass("test");

        Class<?> testClass = TestClass.class;

        //Меняем значение в private final поле o_0
        Field cost = testClass.getDeclaredField("CONST");
        cost.setAccessible(true);
        System.out.println(cost.get(object));
        cost.set(object,"NO_CONST)))))");
        System.out.println(cost.get(object));

        printSuperclasess(ArrayList.class);
    }

    /**
     * Печатаем всю иерархию классов
     * @param clazz класс для которого хотим распечатать иерархию
     */
    public static void printSuperclasess(Class<?> clazz){
        if(clazz==null){
            return;
        }
        System.out.println(clazz.getName());
        printSuperclasess(clazz.getSuperclass());
    }
}
