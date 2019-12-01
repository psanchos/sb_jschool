package ru.sbrf.jschool.core.exception;

public class Example1 {

    public static void main(String[] args) {
        try{
            throw new Exception1();
        }catch (Exception1 ex){
            System.out.println("Handle exception 1");
            throw new  Exception2();
        }catch (Exception2 ex){
            throw new Exception3();
        }finally {
            throw new FinallyException();
        }
    }

    static class Exception1 extends RuntimeException{}
    static class Exception2 extends RuntimeException{}
    static class Exception3 extends RuntimeException{}
    static class FinallyException extends RuntimeException{}
}
