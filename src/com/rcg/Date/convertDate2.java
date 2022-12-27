package com.rcg.Date;

import java.time.Month;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class convertDate2 {
 
    public static java.util.Date parseDate(String strDate, String format){
        int date=0, month=0, year=0,cont=0,postD=0,postM=0,postY=0;
        char dateC, monthC, yearC,symbol=' ',tmpC;
        boolean comparation=true;
        
        if((strDate == null) || (strDate.length()==0) || ((format.length()<0) && (format.length()>10)))
                return null;
        else{
        String regex = "[./-]";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(format);
        if(mat.find()){
            for(int i =0;i<format.length();i++){
                tmpC = format.charAt(i);
                if(tmpC==('.') ||  tmpC==('/') || tmpC==('-')){
                    
                    if(comparation)
                        symbol = tmpC;  
                    else
                        comparation =false;
                    
                    if(symbol!=tmpC) //    "dd/mm.yyyy"
                        break;
                    
                    continue;
                }
 
                if(i<9){
                    if((tmpC == 'd')  && ((format.charAt(i+1))=='d')){
                        dateC = tmpC;
                        postD=postM+postY+1;
                    }
    
                    if((tmpC == 'y') && ((format.charAt(i+1))=='y')){
                        yearC = tmpC;
                        postY=postM+postD+1;
                    }
    
                    if((tmpC == 'm') && ((format.charAt(i+1))=='m') ){
                        monthC = tmpC;
                        postM=postD+postY+1;
                    }
                }
                //System.out.println("D: "+postD+" M: "+postM+" A: "+postY);
            }
            //System.out.println("D: "+postD+" M: "+postM+" A: "+postY);
            
            if(postY==1) // yyyy/dd/mm
                return null;
 
            if(postY==2)
                return null;
            
            int idx0 = strDate.indexOf(symbol);
            if(idx0==-1)
                return null; // Fecha invalida.
            String tmp;
            int idx1;
            try{
                if(postD ==1){
                    //  dd/mm/yyyy
                    postD -=1;
                    tmp = strDate.substring(postD,idx0);
                    date = Integer.parseInt(tmp);
                   //System.out.println("Date: "+date);
    
                    idx1 = strDate.indexOf(symbol,idx0+1);
                    //System.out.println("idx0 "+idx0+" idx1: "+idx1);

                    tmp=strDate.substring(idx0+1,idx1);
                    month=Integer.parseInt(tmp);

                    //System.out.println("Date: "+month);
    
                    tmp = strDate.substring(idx1+1);
                    year = Integer.parseInt(tmp);
                   
                }
    
                if(postM==1){
                    //  mm/dd/yyyy
                    postM--;
                    tmp= strDate.substring(postM, idx0);
                    month = Integer.parseInt(tmp);
 
                    idx1 = strDate.indexOf(symbol,idx0+1);
                    tmp = strDate.substring(idx0+1,idx1);
                    date = Integer.parseInt(tmp);
    
                    tmp = strDate.substring(idx1+1);
                    year = Integer.parseInt(tmp);
                }
 
                if((date<0) || (date>31))
                    return null;
    
                if((month<1) || (month>12))
                    return null;
                
                if((month==2) && (date>29))
                    return null;

                if((year<1970) && (year>2099))
                    return null;
 
/*
            idx1=strDate.indexOf(symbol, idx0+1);
            if(idx1 == -1)
                return null;
            tmp = strDate.substring(idx0+1, idx1);
            month = Integer.parseInt(tmp);
            if((month<1) || (month>12))
                return null;

            tmp = strDate.substring(idx1+1);
            year = Integer.parseInt(tmp);
            if((year<1970) &&(year>2099))
                return null;
*/
                    
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.DATE,date);
                cal.set(Calendar.MONTH,month-1);
                cal.set(Calendar.YEAR,year);
                cal.set(Calendar.HOUR_OF_DAY,0);
                cal.set(Calendar.MINUTE,0);
                cal.set(Calendar.SECOND,0);
                cal.set(Calendar.MILLISECOND,0);
        
                    return cal.getTime();
            }catch(Exception e){
                return null;
            }
            
 
        }
            
    }
    
    return null;
    }
 
    public static void main(String[] args) {
       String tests[] = new String[] {
            "31/12/2020", "dd/mm/yyyy",
            "12/01/2020", "dd/mm/yyyy",
            "01/12/2020", "mm/dd/yyyy",
            "12/01/2020", "mm/dd/yyyy",
            "01/12/2020", "dd/mm/yyyy",
            "01/12/2020", "mm/dd/yyyy",
            "01/12/2020", "dd/mm/yyyy",
            "01/12/2020", "dd/mm/yyyy",
            "01/12/20",   "dd/mm/yyyy",
            "1/12/20",    "dd/mm/yyyy",
            "01/12/20",   "mm/dd/yyyyy",
            "01.10.2000",    "dd.mm.yyyy",
            "01-12-2000",   "mm-dd-yyyy",
            "30/02/2020", "dd/mm/yyyy",
            "31/02/2020", "dd/mm/yyyy",
            " 1/ 2/2020", "dd/mm/yyyy"
        };
        for (int n=0; n<tests.length; n+=2) {
            java.util.Date d = parseDate(tests[n], tests[n+1]);
            System.out.println(tests[n] + "\t" + tests[n+1] + "\t" + d);
        }
    }
}