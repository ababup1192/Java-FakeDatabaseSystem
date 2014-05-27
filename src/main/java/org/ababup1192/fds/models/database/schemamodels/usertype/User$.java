package org.ababup1192.fds.models.database.schemamodels.usertype;

import org.ababup1192.fds.models.database.schemamodels.SchemaModelInterface$;

public class User$ implements SchemaModelInterface$<User> {
    private static User$ instance = null;

    public static synchronized User$ getInstance() {
        // newするのは初めの1回だけ
        if (instance == null) {
            instance = new User$();
        }
        return instance;
    }

    @Override
    public User serializeModel(String data) {
        try {
            String[] dataArray = data.split(" ");
            if (dataArray.length == 2) {
                int id = new Integer(dataArray[0]);
                String name = dataArray[1];
                return new User(id, name);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getTableName() {
        return "user";
    }
}
