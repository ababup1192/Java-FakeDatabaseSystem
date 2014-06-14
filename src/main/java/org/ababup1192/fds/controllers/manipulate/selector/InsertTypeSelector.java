package org.ababup1192.fds.controllers.manipulate.selector;

import org.ababup1192.fds.controllers.manipulate.DBManipulateState;
import org.ababup1192.fds.controllers.manipulate.executor.insertor.UserChildInsertor;
import org.ababup1192.fds.controllers.manipulate.executor.insertor.UserInsertor;
import org.ababup1192.fds.utils.Printer;

import java.util.Scanner;

public class InsertTypeSelector implements DBManipulateState {

    @Override
    public DBManipulateState execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("挿入するデータタイプを選んでください。");
        Printer.printCommands("ユーザー", "ユーザーチャイルド", "終了");
        System.out.println("数字をタイプして、エンターを押して下さい...");

        switch (scanner.nextInt()) {
            case 1:
                return new UserInsertor();
            case 2:
                return new UserChildInsertor();
            case 3:
                return null;
            default:
                return this;
        }
    }

}
