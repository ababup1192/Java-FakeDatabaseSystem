package org.ababup1192.fds.models.database.table.usertype;

import org.ababup1192.fds.models.database.Database;
import org.ababup1192.fds.models.database.schemamodels.usertype.User;
import org.ababup1192.fds.models.database.schemamodels.usertype.User$;


public class UserTable extends UserTypeTable<User> {
    public UserTable(Database db) {
        super(db, User$.getInstance());
    }

}
