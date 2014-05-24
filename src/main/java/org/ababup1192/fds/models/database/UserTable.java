package org.ababup1192.fds.models.database;

import org.ababup1192.fds.models.modelclass.User;
import org.ababup1192.fds.models.modelclass.User$;

import java.util.ArrayList;
import java.util.List;

public class UserTable extends Table<User> {
    public UserTable(Database db) {
        super(db, User$.getInstance());
    }

    public List<User> selectByName(String name) {
        List<User> tableObjectList = selectAll();
        List<User> resultList = new ArrayList<User>();

        for (User user : tableObjectList) {
            if (user.getName().equals(name)) {
                resultList.add(user);
            }
        }
        return resultList;
    }

    public int deleteByName(String name) {
        List<User> deleteUserList = selectByName(name);

        for (User user : deleteUserList) {
            deleteById(user.getId());
        }
        return deleteUserList.size();
    }

}
