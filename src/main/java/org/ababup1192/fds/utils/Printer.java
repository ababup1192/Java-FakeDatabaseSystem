package org.ababup1192.fds.utils;

public class Printer {

    public static void printCommands(String... commands) {
        int count = 1;

        for (String command : commands) {
            System.out.print(count + ": " + command);
            if (count < commands.length) {
                System.out.print(", ");
            }
            count++;
        }
        System.out.println();
    }

    public static void consoleClear() {
        for (int i = 0; i < 4; ++i) System.out.println();
    }
}
