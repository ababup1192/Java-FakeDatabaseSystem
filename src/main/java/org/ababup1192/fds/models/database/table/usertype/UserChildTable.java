package org.ababup1192.fds.models.database.table.usertype;

import org.ababup1192.fds.models.database.Database;
import org.ababup1192.fds.models.database.schemamodels.usertype.UserChild;
import org.ababup1192.fds.models.database.schemamodels.usertype.UserChild$;


public class UserChildTable extends UserTypeTable<UserChild> {
    public UserChildTable(Database db) {
        super(db, UserChild$.getInstance());
    }

}
