package com.rcg;

public class StringTest {

    private static void appendTest1(){
        long start =System.currentTimeMillis();
        String s = "Hola mundo: ";
        for(int i=0;i<100000;i++){
            s+=i;
        }
        long end = System.currentTimeMillis();

        System.out.println("Tiempo trascurrido: "+(end-start)+" ms.");
    }

    private static void appendTest2(){
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<100000;i++){
            sb.append(i);
        }
        String s = sb.toString();
        long end = System.currentTimeMillis();
        System.out.println("Tiempo transcurrido: "+(end-start) +" ms.");
    }

    public static void main(String args[]){
        appendTest1();
        appendTest2();
    }
}
