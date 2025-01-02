package com.pos;

import java.util.Scanner;

public class Util {
    static String stringInput() {
        Scanner input = new Scanner(System.in);

        return input.nextLine();
    }

    static int intInput() {
        Scanner input = new Scanner(System.in);

        return input.nextInt();
    }

    static void lanjutkan() {
        System.out.println("Tekan enter untuk melanjutkan...");
        try {
            System.out.println(System.in.read());
        } catch (Exception e) {
        }
    }
}
