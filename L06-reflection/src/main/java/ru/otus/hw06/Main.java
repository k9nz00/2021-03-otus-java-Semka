package ru.otus.hw06;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
//            App.run(args[0]);

            for (String param : args){
                System.out.println(param);
            }
        } else {
            throw new RuntimeException("Class name is required!");
        }
    }
}