package org.ababup1192.fds.controllers.manipulate.selector;

import org.ababup1192.fds.controllers.manipulate.DBManipulateState;
import org.ababup1192.fds.utils.Printer;
import java.util.Scanner;

public class DBManipulateSelector implements DBManipulateState {

    @Override
    public DBManipulateState execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("データベースの操作を選んでください。");
        Printer.printCommands("挿入", "検索", "削除", "終了");
        System.out.println("数字をタイプして、エンターを押して下さい...");

        switch (scanner.nextInt()) {
            case 1:
                Printer.consoleClear();
                return new InsertTypeSelector();
            case 2:
                Printer.consoleClear();
                return new SelectTypeSelector();
            case 3:
                Printer.consoleClear();
                return new DeleteTypeSelector();
            case 4:
                Printer.consoleClear();
                return null;
            default:
                return this;
        }

    }
}

