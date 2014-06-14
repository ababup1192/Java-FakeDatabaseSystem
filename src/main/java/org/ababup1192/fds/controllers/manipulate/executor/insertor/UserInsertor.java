package org.ababup1192.fds.controllers.manipulate.executor.insertor;

import org.ababup1192.fds.controllers.manipulate.DBManipulateState;
import org.ababup1192.fds.controllers.manipulate.selector.DBManipulateSelector;
import org.ababup1192.fds.models.database.schemamodels.usertype.User;
import org.ababup1192.fds.models.database.schemamodels.usertype.UserChild;
import org.ababup1192.fds.models.database.table.usertype.UserChildTable;
import org.ababup1192.fds.models.database.table.usertype.UserTable;
import org.ababup1192.fds.utils.Printer;
import org.ababup1192.fds.views.UserTypePrinter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInsertor implements DBManipulateState {
    @Override
    public DBManipulateState execute() {
        User addingUser;

        // ユーザ情報の入力
        Scanner scanner = new Scanner(System.in);
        System.out.println("ユーザ情報の入力をします。");
        System.out.println("ID(数字)と名前(文字列)を空白区切りで入力してください。");
        System.out.println("例 1 山田太郎");
        System.out.println("入力をしてください...");

        int id = scanner.nextInt();
        String name = scanner.next();

        try {
            db.use();

            UserTable userTable = new UserTable(db);
            UserChildTable childTable = new UserChildTable(db);
            userTable.create();
            childTable.create();


            List<UserChild> childList = childTable.selectAll();
            List<UserChild> addingChildList = new ArrayList<UserChild>();

            // 子供情報の入力
            if (childList.size() != 0) {
                System.out.println("続いて、子供として登録するユーザを選んで下さい(空白区切りで複数入力可)。");
                System.out.println("読み込みを終了する場合には、-1 を入力してください。");
                System.out.println("例: 1 2 -1");

                System.out.println("子供リストの表示\n");
                UserTypePrinter.printUserTypeList(childList);
                System.out.println();
                System.out.println("登録する子供がいなければ、そのまま -1 を入力してエンターを押して下さい...");

                //
                while (scanner.hasNextInt()) {
                    int targetId = scanner.nextInt();
                    if (targetId == -1) break;
                    UserChild addingChild = childTable.selectById(targetId);
                    if (addingChild != null) {
                        addingChildList.add(addingChild);
                    }
                }
                if (addingChildList.size() != 0) {
                    addingUser = new User(id, name, addingChildList);
                } else {
                    addingUser = new User(id, name);
                }
            } else {
                addingUser = new User(id, name);
            }
            userTable.insert(addingUser);

            System.out.println("挿入が正常終了しました。メインメニューに遷移します。");

        } catch (IOException e) {
            System.out.println("挿入処理中に例外が発生しました。メインメニューに遷移します。");
            e.printStackTrace();
        }

        Printer.consoleClear();
        return new DBManipulateSelector();
    }
}
