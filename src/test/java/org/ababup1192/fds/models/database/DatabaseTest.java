package org.ababup1192.fds.models.database;

import org.ababup1192.fds.config.DatabaseConfig;
import org.ababup1192.fds.utils.Path;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void testUse() {
        // SetUp
        Database db = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        // Exercise
        try {
            db.use();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPath() throws Exception {
        // SetUp
        Database db = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        // Exercise
        Path actual = db.getPath();
        // Verify
        assertThat(actual, is(new Path(DatabaseConfig.PROJECT_PATH + "database/")));
    }

    @Ignore
    @Test
    public void testDelete() throws Exception {
        // SetUp
        Database db = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        // Exercise
        try {
            db.use();
            boolean actual = db.delete();
            // Verify
            assertThat(actual, is(true));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}