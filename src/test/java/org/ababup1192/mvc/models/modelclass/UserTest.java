package org.ababup1192.mvc.models.modelclass;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testGetId() throws Exception {
        // SetUp and Exercise
        int actual = new User(1, "ababup1192").getId();
        int expected = 1;
        // Verify
        assertThat(actual, is(expected));
    }


    @Test
    public void testGetName() throws Exception {
        // SetUp and Exercise
        String actual = new User(1, "ababup1192").getName();
        String expected = "ababup1192";
        // Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testToString() throws Exception {
        // SetUp and Exercise
        String actual = new User(1, "ababup1192").toString();
        String expected = "User(id=1, name=ababup1192)";
        // Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testEquals() throws Exception {
        // SetUp
        User user1 = new User(1, "ababup1192");
        User user2 = new User(1, "ababup1192");
        // Verify
        assertThat(user1, is(user2));
    }

    @Test
    public void testToData() throws Exception {
        // SetUp and Exercise
        String actual = new User(1, "ababup1192").toData();
        String expected = "1 ababup1192";
        // Verify
        assertThat(actual, is(expected));
    }

}