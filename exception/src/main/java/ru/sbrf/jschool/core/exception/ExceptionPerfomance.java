package ru.sbrf.jschool.core.exception;

public class ExceptionPerfomance {
    public static void main(String[] args) {
        A2 a2=new A2(null);
        Long startTime = System.currentTimeMillis();
        for(int i=0; i<1000000;i++){
            a2.equals(null);
        }

        System.out.println("Ends "+ (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        for(int i=0; i<1000000;i++){
            a2.equalsWithEx(null);
        }
        System.out.println("Ends with exception "+ (System.currentTimeMillis() - startTime));
    }

    static class A2{
        private Integer a;

        public A2(Integer a) {
            this.a = a;
        }

        public boolean equalsWithEx(Object obj){
            try {
                return this.a == ((A2) obj).a;
            }catch (Exception ex){
                return false;
            }finally {
                return true;
            }
        }

        public boolean equals(Object obj){
            if(obj==null)return false;
            return this.a == ((A2) obj).a;
        }

    }
}


