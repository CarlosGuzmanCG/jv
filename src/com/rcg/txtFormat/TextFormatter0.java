package com.rcg.txtFormat;

import java.util.StringTokenizer;

public class TextFormatter0 {
    public static void main(String[] args) {
       //simpleString();
       TextFormatter1();
    }

    public static void TextFormatter1(){
        String sr ="La importancia de los denominados lenguajes de especialidad o lenguajes especializados está hoy"+
        "en día fuera de toda duda. Es más, el número de especialistas dedicados a su descripción y aplicación crece incesantemente."
        +"Ello obedece en nuestra opinión a tres razones: en primer lugar, al nuevo papel que juega hoy la lingüística aplicada en el"+
        " marco de la lingüística en general; en segundo lugar, a las necesidades sociales en materia de plurilingüismo, y en tercer lugar, a la importancia que la sociedad actual concede a las especialidades.";
        int leng=sr.length();
        int curPos=0;
        StringTokenizer strT = new StringTokenizer(sr);
        boolean space = false;
        for(int i=0;i<40;i++){
            if((i+(1%10)!=0)){
                System.out.print((i+(1%10))%10);
            }
        }
        System.out.println();
        for(int i=0;i<40;i++){
            System.out.print("-");
        }
        System.out.println( );

        while(strT.hasMoreTokens()){
            String sb = strT.nextToken();
            if((curPos+sb.length())>40){
                System.out.println();
                space=false;
                curPos=0;
            }
            if(space)
                System.out.print(" ");
            System.out.print(sb);
            curPos+=sb.length()+1;
            space = true;
        }
    }

    public static void simpleString(){
        String str = "";

        System.out.println(str);
        System.out.println();
    }
}