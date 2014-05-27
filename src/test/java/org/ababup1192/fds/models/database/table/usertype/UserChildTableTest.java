package org.ababup1192.fds.models.database.table.usertype;

import org.ababup1192.fds.config.DatabaseConfig;
import org.ababup1192.fds.models.database.Database;
import org.ababup1192.fds.models.database.schemamodels.usertype.UserChild;
import org.ababup1192.fds.utils.Path;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserChildTableTest {

    @Test
    public void testGetName() throws Exception {
        // SetUp
        Database db = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            db.use();
            UserChildTable table = new UserChildTable(db);
            // Exercise
            String actual = table.getName();
            String expected = "userChild";
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
            UserChildTable table = new UserChildTable(db);
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
            UserChildTable table = new UserChildTable(db);
            table.delete();
            // Exercise
            table.insert(new UserChild(1, "ababup1192"));
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
            UserChildTable table = new UserChildTable(db);
            table.delete();
            // Prepare comparable list.
            UserChild userChild1 = new UserChild(1, "abab");
            UserChild userChild2 = new UserChild(2, "abab1192");
            UserChild userChild3 = new UserChild(3, "ababup1192");
            List<UserChild> expected = new ArrayList<UserChild>();
            expected.add(userChild1);
            expected.add(userChild2);
            expected.add(userChild1);
            for (UserChild userChild : expected) {
                table.insert(userChild);
            }
            // Exercise
            List<UserChild> actual = table.selectAll();
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
            UserChildTable table = new UserChildTable(db);
            table.delete();
            UserChild userChild1 = new UserChild(1, "abab1");
            UserChild userChild2 = new UserChild(2, "abab2");
            UserChild expected = new UserChild(3, "abab3");
            table.insert(userChild1);
            table.insert(userChild2);
            table.insert(expected);
            // Exercise
            UserChild actual = table.selectById(3);
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
            UserChildTable table = new UserChildTable(db);
            table.delete();
            // Prepare Table
            UserChild userChild1 = new UserChild(1, "abab123");
            UserChild userChild2 = new UserChild(2, "abab");
            UserChild userChild3 = new UserChild(3, "abab");
            table.insert(userChild1);
            table.insert(userChild2);
            table.insert(userChild3);
            // expected List
            List<UserChild> expected = new ArrayList<UserChild>();
            expected.add(userChild2);
            expected.add(userChild3);
            // Exercise
            List<UserChild> actual = table.selectByName("abab");
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
            UserChildTable table = new UserChildTable(db);
            table.delete();
            // Prepare Table
            UserChild userChild1 = new UserChild(1, "abab");
            UserChild userChild2 = new UserChild(2, "ababup");
            UserChild userChild3 = new UserChild(3, "ababup1192");
            table.insert(userChild1);
            table.insert(userChild2);
            table.insert(userChild3);
            // expected List
            List<UserChild> expected = new ArrayList<UserChild>();
            expected.add(userChild1);
            expected.add(userChild3);
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
            UserChildTable table = new UserChildTable(db);
            table.delete();
            // Prepare Table
            UserChild userChild1 = new UserChild(1, "abab");
            UserChild userChild2 = new UserChild(2, "ababup");
            UserChild userChild3 = new UserChild(3, "ababup1192");
            table.insert(userChild1);
            table.insert(userChild2);
            table.insert(userChild3);
            // expected List
            List<UserChild> expected = new ArrayList<UserChild>();
            expected.add(userChild1);
            expected.add(userChild2);
            expected.add(userChild3);
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
            UserChildTable table = new UserChildTable(db);
            table.delete();
            // Prepare Table
            UserChild userChild1 = new UserChild(1, "abab123");
            UserChild userChild2 = new UserChild(2, "abab");
            UserChild userChild3 = new UserChild(3, "abab");
            table.insert(userChild1);
            table.insert(userChild2);
            table.insert(userChild3);
            // expected List
            List<UserChild> expected = new ArrayList<UserChild>();
            expected.add(userChild1);
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
            UserChildTable table = new UserChildTable(db);
            table.delete();
            // Prepare Table
            UserChild userChild1 = new UserChild(1, "abab123");
            UserChild userChild2 = new UserChild(2, "abab124");
            UserChild userChild3 = new UserChild(3, "abab125");
            table.insert(userChild1);
            table.insert(userChild2);
            table.insert(userChild3);
            // expected List
            List<UserChild> expected = new ArrayList<UserChild>();
            expected.add(userChild1);
            expected.add(userChild2);
            expected.add(userChild3);
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
            UserChildTable table = new UserChildTable(db);
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


