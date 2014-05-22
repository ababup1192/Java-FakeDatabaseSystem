package org.ababup1192.mvc.models.database;

import org.ababup1192.mvc.config.DatabaseConfig;
import org.ababup1192.mvc.models.modelclass.TableObjectInterface;
import org.ababup1192.mvc.utils.Path;

import java.io.File;
import java.io.IOException;

public class Database {
    private String table;
    private String tableFilePath;
    private File file;

    public Database(String table) {
        this.table = table;
        tableFilePath = new Path(DatabaseConfig.DATABASE_PATH + table + ".dat").getPath();
        file = new File(tableFilePath);
    }

    public boolean createDatabase() {
        try {
            return file.createNewFile();
        } catch (IOException e) {
            return false;
        }
    }

    public boolean addData(TableObjectInterface data) {
        if (file.exists()) {

            return true;
        } else return false;
    }

    public boolean deleteDatabase() {
        return !file.exists() || file.delete();
    }
}
