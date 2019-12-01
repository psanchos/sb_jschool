package ru.sbrf.jschool.core.exception;

import java.io.IOException;

public class Example2 {
    public static void main(String[] args) throws MyException {
        try {
            throw new IOException();
        }catch (IOException ex){
            System.out.println(ex.getClass().getName());
            throw new MyException3(ex, -1);
        }catch (Exception ex){
            System.out.println(ex.getClass().getName());
        }finally {
            System.out.println("Finally");
            try {
                throw new RuntimeException("Страшный рантайм");
            }catch (RuntimeException ex){
                System.out.println("Finally Exception"+ex.getMessage());
            }
        }
    }

    public static void someMethod() throws RuntimeException{
        throw new RuntimeException("Произошла страшная ошибка");
    }
 }

 interface A {
    void m();
 }


 class MyException extends Exception{}
 class MyException2 extends MyException{}
 class MyException3 extends RuntimeException{
    private int code;

     public MyException3(Throwable cause, int code) {
         super(cause);
         this.code = code;
     }
 }
 class MyRuntimeException extends RuntimeException{}
