package org.ababup1192.fds.controllers.manipulate.selector;

import org.ababup1192.fds.controllers.manipulate.DBManipulateState;
import org.ababup1192.fds.controllers.manipulate.executor.deletor.UserChildDeletor;
import org.ababup1192.fds.controllers.manipulate.executor.deletor.UserDeletor;
import org.ababup1192.fds.utils.Printer;

import java.util.Scanner;

public class DeleteTypeSelector implements DBManipulateState {

    @Override
    public DBManipulateState execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("削除するデータタイプを選んでください。");
        Printer.printCommands("ユーザー", "ユーザーチャイルド", "終了");
        System.out.println("数字をタイプして、エンターを押して下さい...");

        switch (scanner.nextInt()) {
            case 1:
                return new UserDeletor();
            case 2:
                return new UserChildDeletor();
            case 3:
                return null;
            default:
                return this;
        }
    }

}
