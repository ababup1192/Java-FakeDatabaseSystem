package org.ababup1192.fds.models.database;

import org.ababup1192.fds.utils.Path;

import java.io.File;
import java.io.IOException;

public class Database {
    private Path path;
    private File database;

    /**
     * This is a class that provides File System such as database.
     * If you use database or tables, you should call 'use' method and surround try/catch blocks.
     *
     * @param path This method receive Project or Production directory's Path Object.
     */
    public Database(Path path) {
        this.path = new Path(path + "database/");
        this.database = new File(this.path.toString());
    }

    /**
     * This is a method that setup a File System.
     * Specifically, the method make a 'database' directory when it didn't exists.
     * If the method can't create directory, it throws IOException.
     *
     * @throws IOException
     */
    public void use() throws IOException {
        if (!database.exists()) {
            boolean isMaking = database.mkdir();
            if (!isMaking) {
                throw new IOException("Try create Database but it's failed...");
            }
        }
    }

    /**
     * @return the 'database' Path object.
     */
    public Path getPath() {
        return path;
    }

    /**
     * This method deletes 'database' directory.
     *
     * @return If delete function is successfully, returns true.
     */
    public boolean delete() {
        return database.delete();
    }
}
