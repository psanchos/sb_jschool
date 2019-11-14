package ru.sbrf.jschool.core.exception;

import java.io.IOException;
import java.util.logging.Logger;

public class BestPractice {
    public static final Logger LOGGER= Logger.getLogger(BestPractice.class.getName());

    //Никогда не замалчивайте эксепшн
    public static void advice1(){
        try{
            methodWithException();
        } catch (SpecificException1 ex) {
            //Никогда так не делай
        }
    }

    //Декларируйте конкретные эксепшн
    public static void advice2() throws Exception {
        methodWithException();
        methodWithException2();
    }

    //Старайтесь указывать в блоке catch конкретные классы эксепшн вместо общих
    public static void advice3(){
        try{
            methodWithException();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //При оборачивании исключения в свое собственное, Формируйте цепочку
    public static void advice4() throws MyOwnException {
        try{
            methodWithException();
        } catch (SpecificException1 ex) {
            throw new MyOwnException("Произошло ужасное" + ex.getMessage());
        }
    }

    //Либо бросайте исключение дальше либо логируйте и обрабатывайте, и то и другое нежелательно
    public static void advice5() throws SpecificException1 {
        try{
            methodWithException();
        } catch (SpecificException1 ex) {
            LOGGER.severe(ex.getMessage());
            throw ex;
        }
    }

    //Не бросайте исключение в finally, рискуете потерять истинную причину
    public static void advice6() throws SpecificException1 {
        try{
            methodWithException();
        } finally {
            System.out.println("Закрываем ресурсы");
        }
    }

    //Перехватывайте только те исключения которые можете обработать
    public static void advice7() throws SpecificException1 {
        try{
            methodWithException();
        } catch (SpecificException1 ex) {
            throw ex; //В этом нет смысла
        }
    }




    //Передавайте в сообщении к исклоючению всю необходимую фактуру
    public static void advice8(String userName, int old) throws MyOwnException {
        if(old<18){
            throw new MyOwnException(String.format("Пользователю %s %s дет, вход запрещен", userName, String.valueOf(old)));
        }
    }

    /*
        9. Бросайте исключние как можно раньше, ловите как можно позже
        10. Не используйте исключения для управления ветвлениями алгоритма
     */




    public static void methodWithException() throws SpecificException1{
        throw new SpecificException1();
    }
    public static void methodWithException2() throws SpecificException2{
        throw new SpecificException2();
    }

    public static void methodWithException3() throws SpecificException1, SpecificException2{
    }



}
class SpecificException1 extends Exception{}
class SpecificException2 extends Exception{}
class MyOwnException extends Exception{

    public MyOwnException(String message) {
        super(message);
    }

    public MyOwnException(String message, Throwable cause) {
        super(message, cause);
    }
}

