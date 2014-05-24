package org.ababup1192.fds.models.database;

import org.ababup1192.fds.config.DatabaseConfig;
import org.ababup1192.fds.models.modelclass.User;
import org.ababup1192.fds.utils.Path;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserTableTest {

    @Test
    public void testGetName() throws Exception {
        // SetUp
        Database db = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            db.use();
            UserTable table = new UserTable(db);
            // Exercise
            String actual = table.getName();
            String expected = "user";
            // Verify
            assertThat(actual, is(expected));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreate() throws Exception {
        // SetUp
        Database db = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            db.use();
            UserTable table = new UserTable(db);
            table.delete();
            // Exercise
            boolean actual = table.create();
            // Verify
            assertThat(actual, is(true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert() throws Exception {
        // SetUp
        Database db = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            db.use();
            UserTable table = new UserTable(db);
            table.delete();
            // Exercise
            table.insert(new User(1, "ababup1192"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAll() throws Exception {
        // SetUp
        Database db = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            db.use();
            UserTable table = new UserTable(db);
            table.delete();
            // Prepare comparable list.
            User user1 = new User(1, "abab");
            User user2 = new User(2, "abab1192");
            User user3 = new User(3, "ababup1192");
            List<User> expected = new ArrayList<User>();
            expected.add(user1);
            expected.add(user2);
            expected.add(user3);
            for (User user : expected) {
                table.insert(user);
            }
            // Exercise
            List<User> actual = table.selectAll();
            // Verify
            assertThat(actual, is(expected));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectById() throws Exception {
        // SetUp
        Database db = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            db.use();
            UserTable table = new UserTable(db);
            table.delete();
            User user1 = new User(1, "abab1");
            User user2 = new User(2, "abab2");
            User expected = new User(3, "abab3");
            table.insert(user1);
            table.insert(user2);
            table.insert(expected);
            // Exercise
            User actual = table.selectById(3);
            // Verify
            assertThat(actual, is(expected));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectByName() throws Exception {
        // SetUp
        Database db = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            db.use();
            UserTable table = new UserTable(db);
            table.delete();
            // Prepare Table
            User user1 = new User(1, "abab123");
            User user2 = new User(2, "abab");
            User user3 = new User(3, "abab");
            table.insert(user1);
            table.insert(user2);
            table.insert(user3);
            // expected List
            List<User> expected = new ArrayList<User>();
            expected.add(user2);
            expected.add(user3);
            // Exercise
            List<User> actual = table.selectByName("abab");
            // Verify
            assertThat(actual, is(expected));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteById() throws Exception {
        // SetUp
        Database db = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            db.use();
            UserTable table = new UserTable(db);
            table.delete();
            // Prepare Table
            User user1 = new User(1, "abab");
            User user2 = new User(2, "ababup");
            User user3 = new User(3, "ababup1192");
            table.insert(user1);
            table.insert(user2);
            table.insert(user3);
            // expected List
            List<User> expected = new ArrayList<User>();
            expected.add(user1);
            expected.add(user3);
            // Exercise
            boolean actual = table.deleteById(2);
            // Verify
            assertThat(actual, is(true));
            assertThat(table.selectAll(), is(expected));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteByIdFailCase() throws Exception {
        // SetUp
        Database db = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            db.use();
            UserTable table = new UserTable(db);
            table.delete();
            // Prepare Table
            User user1 = new User(1, "abab");
            User user2 = new User(2, "ababup");
            User user3 = new User(3, "ababup1192");
            table.insert(user1);
            table.insert(user2);
            table.insert(user3);
            // expected List
            List<User> expected = new ArrayList<User>();
            expected.add(user1);
            expected.add(user2);
            expected.add(user3);
            // Exercise
            boolean actual = table.deleteById(-1);
            // Verify
            assertThat(actual, is(false));
            assertThat(table.selectAll(), is(expected));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteByName() throws Exception {
        // SetUp
        Database db = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            db.use();
            UserTable table = new UserTable(db);
            table.delete();
            // Prepare Table
            User user1 = new User(1, "abab123");
            User user2 = new User(2, "abab");
            User user3 = new User(3, "abab");
            table.insert(user1);
            table.insert(user2);
            table.insert(user3);
            // expected List
            List<User> expected = new ArrayList<User>();
            expected.add(user1);
            // Exercise
            int actual = table.deleteByName("abab");
            // Verify
            assertThat(actual, is(2));
            assertThat(table.selectAll(), is(expected));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteByNameFailCase() throws Exception {
        // SetUp
        Database db = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            db.use();
            UserTable table = new UserTable(db);
            table.delete();
            // Prepare Table
            User user1 = new User(1, "abab123");
            User user2 = new User(2, "abab124");
            User user3 = new User(3, "abab125");
            table.insert(user1);
            table.insert(user2);
            table.insert(user3);
            // expected List
            List<User> expected = new ArrayList<User>();
            expected.add(user1);
            expected.add(user2);
            expected.add(user3);
            // Exercise
            int actual = table.deleteByName("hogehoge");
            // Verify
            assertThat(actual, is(0));
            assertThat(table.selectAll(), is(expected));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete() throws Exception {
        // SetUp
        Database db = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            db.use();
            UserTable table = new UserTable(db);
            table.create();
            // Exercise
            boolean actual = table.delete();
            // Verify
            assertThat(actual, is(true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


