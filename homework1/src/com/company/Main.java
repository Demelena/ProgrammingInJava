package com.company;


import org.testng.annotations.Test;

public class Main {

    public static void main(String[] args) {

        String mess1 = "Welcome to Java BootCamp!!!";
        String mess2 = "Welcome to Portnov Computer School!";

        print(mess1);
        Tools.myPrint(mess1);
        Tools.myPrint(mess2);
    }
}
