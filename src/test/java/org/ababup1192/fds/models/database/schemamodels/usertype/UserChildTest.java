package org.ababup1192.fds.models.database.schemamodels.usertype;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class UserChildTest {

    @Test
    public void testGetId() throws Exception {
        // SetUp and Exercise
        int actual = new UserChild(1, "ababup1192").getId();
        int expected = 1;
        // Verify
        assertThat(actual, is(expected));
    }


    @Test
    public void testGetName() throws Exception {
        // SetUp and Exercise
        String actual = new UserChild(1, "ababup1192").getName();
        String expected = "ababup1192";
        // Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testToString() throws Exception {
        // SetUp and Exercise
        String actual = new UserChild(1, "ababup1192").toString();
        String expected = "UserChild(id=1, name=ababup1192)";
        // Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testEquals() throws Exception {
        // SetUp
        UserChild userChild1 = new UserChild(1, "ababup1192");
        UserChild userChild2 = new UserChild(1, "ababup1192");
        // Verify
        assertThat(userChild1, is(userChild2));
    }

    @Test
    public void testSerialize() throws Exception {
        // SetUp and Exercise
        UserChild userChild1 = UserChild$.getInstance().serializeModel("1 ababup1192");
        UserChild userChild2 = new UserChild(1, "ababup1192");
        // Verify
        assertThat(userChild1, is(userChild2));
    }

    @Test
    public void testSerializeResultIsNull() throws Exception {
        // SetUp and Exercise
        UserChild userChild1 = UserChild$.getInstance().serializeModel("noNumber ababup1192");
        // Verify
        assertThat(userChild1, nullValue());
    }


    @Test
    public void testToData() throws Exception {
        // SetUp and Exercise
        String actual = new UserChild(1, "ababup1192").toData();
        String expected = "1 ababup1192";
        // Verify
        assertThat(actual, is(expected));
    }

}