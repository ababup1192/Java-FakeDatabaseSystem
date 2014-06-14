package org.ababup1192.fds.controllers.manipulate.executor.selector;

import org.ababup1192.fds.controllers.manipulate.DBManipulateState;
import org.ababup1192.fds.controllers.manipulate.selector.DBManipulateSelector;
import org.ababup1192.fds.models.database.schemamodels.usertype.User;
import org.ababup1192.fds.models.database.table.usertype.UserTable;
import org.ababup1192.fds.utils.Printer;
import org.ababup1192.fds.views.UserTypePrinter;

import java.io.IOException;
import java.util.List;

public class UserSelector implements DBManipulateState {
    @Override
    public DBManipulateState execute() {

        System.out.println("ユーザ情報の検索を開始します。");
        try {
            db.use();
            UserTable userTable = new UserTable(db);
            userTable.create();

            List<User> userList = userTable.selectAll();

            if (userList.size() != 0) {
                System.out.println("件数は、" + userList.size() + "件でした。");
                System.out.println("ユーザテーブルを表示します。");
                UserTypePrinter.printUserTypeList(userList);
            } else {
                System.out.println("件数は、0件でした。");
            }

            System.out.println("検索処理が正常終了しました。メインメニューに遷移します。");
        } catch (IOException e) {
            System.out.println("検索処理中に例外が発生しました。メインメニューに遷移します。");
            e.printStackTrace();
        }

        Printer.consoleClear();
        return new DBManipulateSelector();
    }
}
