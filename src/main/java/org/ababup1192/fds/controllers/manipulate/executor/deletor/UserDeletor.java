package org.ababup1192.fds.controllers.manipulate.executor.deletor;

import org.ababup1192.fds.controllers.manipulate.DBManipulateState;
import org.ababup1192.fds.controllers.manipulate.selector.DBManipulateSelector;
import org.ababup1192.fds.models.database.schemamodels.usertype.User;
import org.ababup1192.fds.models.database.table.usertype.UserTable;
import org.ababup1192.fds.utils.Printer;
import org.ababup1192.fds.views.UserTypePrinter;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserDeletor implements DBManipulateState {
    @Override
    public DBManipulateState execute() {

        System.out.println("ユーザ情報の削除を開始します。");

        try {
            db.use();
            UserTable userTable = new UserTable(db);
            userTable.create();

            List<User> userList = userTable.selectAll();

            if (userList.size() != 0) {
                System.out.println("件数は、" + userList.size() + "件でした。");
                System.out.println("ユーザテーブルを表示します。");
                UserTypePrinter.printUserTypeList(userList);
                System.out.println();

                System.out.println("削除したいユーザのIDを入力してください。");
                System.out.println("数字をタイプして、エンターを押して下さい...");

                Scanner scanner = new Scanner(System.in);
                int targetId = scanner.nextInt();
                if (userTable.selectById(targetId) != null) {
                    if (userTable.deleteById(targetId)) {
                        System.out.println("ユーザの削除に成功しました。");
                    } else {
                        System.out.println("ユーザの削除に失敗しました。");
                    }

                } else {
                    System.out.println("削除希望のユーザは見つかりませんでした。");
                }

            } else {
                System.out.println("件数は、0件でした。削除対象のユーザは見つかりません。");
            }

            System.out.println("削除処理が正常終了しました。メインメニューに遷移します。");
        } catch (IOException e) {
            System.out.println("検索処理中に例外が発生しました。メインメニューに遷移します。");
            e.printStackTrace();
        }

        Printer.consoleClear();
        return new DBManipulateSelector();
    }
}
