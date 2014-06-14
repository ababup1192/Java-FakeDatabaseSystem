package org.ababup1192.fds.controllers.manipulate.executor.insertor;

import org.ababup1192.fds.controllers.manipulate.DBManipulateState;
import org.ababup1192.fds.controllers.manipulate.selector.DBManipulateSelector;
import org.ababup1192.fds.models.database.schemamodels.usertype.UserChild;
import org.ababup1192.fds.models.database.table.usertype.UserChildTable;
import org.ababup1192.fds.utils.Printer;

import java.io.IOException;
import java.util.Scanner;

public class UserChildInsertor implements DBManipulateState {
    @Override
    public DBManipulateState execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ユーザ情報の入力をします。");
        System.out.println("ID(数字)と名前(文字列)を空白区切りで入力してください。");
        System.out.println("例 1 山田太郎");
        System.out.println("入力をしてください...");

        int id = scanner.nextInt();
        String name = scanner.next();

        try {
            db.use();
            UserChildTable childTable = new UserChildTable(db);
            childTable.create();

            childTable.insert(new UserChild(id, name));

            System.out.println("挿入が正常終了しました。メインメニューに遷移します。");
        } catch (IOException e) {
            System.out.println("挿入処理中に例外が発生しました。メインメニューに遷移します。");
            e.printStackTrace();
        }

        Printer.consoleClear();
        return new DBManipulateSelector();
    }
}
