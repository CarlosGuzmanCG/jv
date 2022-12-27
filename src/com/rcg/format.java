package com.rcg;

public class format {

    private static int nLine = 100;
    private static String source="Test.java";
    private static String message = "Este es un mensaje\n";
    public static void main(String[] args) {
        format1();
        format2F();
        format3S();
        formatDate();
    }


    public static void format1(){

        System.out.println("["+source+" "+nLine+"]: "+message);
    }

    public static void format2F(){
        System.out.printf("[%s %d]: %s\n",source,nLine,message);
    }

    public static void format3S(){
        String s=String.format("[%s %d]: %s\n", source,nLine,message);
        System.out.print(s);
        s=String.format("[%s %d]: %1$s\n", source,nLine,message);
        System.out.print(s);
    }

    public static void formatDate(){
        int day =5;
        int month = 6;
        int year = 2020;

        System.out.println(String.format("%02d/%02d/%04d", day,month,year));
    }

}
