package ru.sbrf.jschool.core.exception;

import java.io.*;

public class Example3 {

    public static void main(String[] args) throws IOException {
        autocl();
    }
    public static int calc(int i){
        try{
            if(i==4)
                throw new Exception();
            return i;
        }catch (Exception e){

            return -1;
        }finally {
            System.out.println("close res");
        }
    }

    public static void autocl() throws IOException {
        try(OutputStream stream=new FileOutputStream("test.file")){
            throw new RuntimeException("exp");
        }
    }
}


