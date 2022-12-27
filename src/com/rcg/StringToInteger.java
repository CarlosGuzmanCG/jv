package com.rcg;

public class StringToInteger{
    public static void main(String []args){
        //toShow();
        //convertToInt();
        //System.out.println(toInteger("-2020"));
        System.out.println(toInteger("20a"));
    }

    public static boolean isDigit(char ch){
        return (ch>= '0') && (ch<='9');
    }

    public static int toInteger(String str){
        int result=0;
        boolean negative =false;
        for(int n=0;n<str.length();n++){
            char ch = str.charAt(n);
            if((n==0) && (ch=='-')){
                negative = true;
                continue;  // continue to next iteration
            }
            if(!isDigit(ch))
                return 0;
            System.out.println("ch->"+ch);
            int digit = ch-'0';
            System.out.println("digit ->"+digit);
            result=result*10+digit;
        }
        if(negative)
            return -result;
        return result;
        
    }

    public static void convertToInt(){
        // https://www.google.com/url?sa=i&url=https%3A%2F%2Felcodigoascii.com.ar%2F&psig=AOvVaw3j42_reiJT-kqhXXS6lYV9&ust=1671857678133000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCKD4jqr5jvwCFQAAAAAdAAAAABAI
        String s = "2020";
        int res=0;
        for(int i=0;i<s.length();i++){
            int digit = s.charAt(i)-'0'; // ascii - 48 
            // System.out.println(digit); => 2+0+2+0=4
            res=res*10+digit; // 2,20,202,2020 => example -> res=2*10+0=20
            System.out.println("->"+res);
        }
        System.out.println(res);
    }

    public static void toShow(){
        int a[]={'0','1','2','3','4','5','6','7','8','9'};
        for(int r:a){
            System.out.println(r);
        }
    }
}
