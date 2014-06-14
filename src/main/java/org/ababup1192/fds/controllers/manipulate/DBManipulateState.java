package org.ababup1192.fds.controllers.manipulate;

import org.ababup1192.fds.config.DatabaseConfig;
import org.ababup1192.fds.models.database.Database;
import org.ababup1192.fds.utils.Path;

public interface DBManipulateState {
    Database db = new Database(new Path(DatabaseConfig.PROJECT_PATH));

    DBManipulateState execute();
}
