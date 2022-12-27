package com.rcg;

import java.util.StringTokenizer;

public class StringTokenizerDemo {
    public static void main(String[] args) {
        String sr = "1,2,3,4,5,6,7,8,9";
        cleanAString(sr);
;    }

        public static void cleanAString(String sr){
            StringTokenizer s = new StringTokenizer(sr, ",");
            while(s.hasMoreTokens()){
                String result = s.nextToken();
                System.out.println(result);
            }
        }

    // "Undocumented Windows: Programmer's Guide to reserved Microsoft Windows API Functions" of Andrew Schulman.
}
