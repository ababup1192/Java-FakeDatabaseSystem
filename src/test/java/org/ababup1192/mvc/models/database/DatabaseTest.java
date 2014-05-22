package org.ababup1192.mvc.models.database;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void testCreateDatabase() throws Exception {
        // SetUp
        Database database = new Database("user");
        database.deleteDatabase();
        // Exercise
        boolean actual = database.createDatabase();
        // Verify
        assertThat(actual, is(true));
    }

    @Test
    public void testDeleteDatabase() throws Exception {
        // SetUp
        Database database = new Database("user");
        // Exercise
        boolean actual = database.deleteDatabase();
        // Verify
        assertThat(actual, is(true));
    }

}