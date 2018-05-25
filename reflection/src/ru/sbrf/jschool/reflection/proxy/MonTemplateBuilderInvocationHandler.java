package ru.sbrf.jschool.reflection.proxy;

import ru.sbrf.jschool.reflection.ITemplateBuilder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Invocation handler позволящий вывести на экран время работы метода
 */
public class MonTemplateBuilderInvocationHandler implements InvocationHandler{

    private ITemplateBuilder delegate;

    public MonTemplateBuilderInvocationHandler(ITemplateBuilder delegate) {
        this.delegate = delegate;
    }

    /**
     * Здесь мы можем перехватить вызов метода проксируемого интерфейса
     * Подменить или дополнить поведение этого метода
     * или делигировать вызов
     *
     * @param o - Объект метод которого был вызван
     * @param method Метод который был вызван
     * @param objects Параметры метода
     * @return Результат работы метода
     * @throws Throwable Исключение которое может быть выбрашено
     */
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        final long start = System.currentTimeMillis();
        final String result = (String) method.invoke(delegate, objects);
        System.out.println(String.format("Method with name %s finished %s ms",
                method.getName(),
                String.valueOf(System.currentTimeMillis()-start)));
        return result;
    }
}
