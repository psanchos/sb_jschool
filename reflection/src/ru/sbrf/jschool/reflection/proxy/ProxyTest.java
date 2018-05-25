package ru.sbrf.jschool.reflection.proxy;

import ru.sbrf.jschool.reflection.ITemplateBuilder;
import ru.sbrf.jschool.reflection.TemplateBuilder;
import ru.sbrf.jschool.reflection.TemplateData;
import ru.sbrf.jschool.reflection.TestClass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Динамические прокси
 */
public class ProxyTest {
    public static void main(String[] args) {

        ITemplateBuilder templateBuilder = createTemplateBuilder("Привет {name} {lastName}");
        System.out.println(templateBuilder.getClass());

        System.out.println(templateBuilder.build(new TemplateData("Вася","Пупкин")));

        templateBuilder = createFakeTemplateBuilder();
        System.out.println(templateBuilder.build(new TemplateData("Петр","Васечкин")));

    }

    /**
     * Создаем прокси для ITemplateBuilder который будет выводить время работы каждого метода
     * @param temlate шаблон сообщения
     * @return прокси для ITemplateBuilder
     */
    private static ITemplateBuilder createTemplateBuilder(String temlate){
        final TemplateBuilder delegate = new TemplateBuilder(temlate);
        return (ITemplateBuilder) Proxy.newProxyInstance(
                TestClass.class.getClassLoader(),
                new Class[] {ITemplateBuilder.class},
                new MonTemplateBuilderInvocationHandler(delegate));
    }

    private static  ITemplateBuilder createFakeTemplateBuilder(){
        return (ITemplateBuilder) Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                TemplateBuilder.class.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        System.out.println("Ha ha ha hacked method");
                        return null;
                    }
                });
    }
}
