package ru.otus;

import com.google.common.base.CaseFormat;

public class HelloOtus {
    public static void main(String[] args) {

        String str = "geeks_for_geeks";
        System.out.println("Original String: " + str);

        System.out.println("Lower Camel Format: " + CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str));

        System.out.println("Upper Camel Format: " + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, str));
    }
}
