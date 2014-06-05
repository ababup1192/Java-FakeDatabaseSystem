package org.ababup1192.fds.models.database.schemamodels.usertype;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
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
        String expected = "User(id=1, name=ababup1192) [  ]";
        // Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testToStringAddChildList() throws Exception {
        // SetUp and Exercise
        List<UserChild> userChildList = new ArrayList<UserChild>();
        userChildList.add(new UserChild(1, "abJr"));
        userChildList.add(new UserChild(2, "abJr2"));
        String actual = new User(1, "ababup1192", userChildList).toString();
        String expected = "User(id=1, name=ababup1192) [ UserChild(id=1, name=abJr), UserChild(id=2, name=abJr2) ]";
        // Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testEquals() throws Exception {
        // SetUp
        User user1 = new User(1, "ababup1192");
        User user2 = new User(1, "abab1192");
        // Verify
        assertThat(user1, is(user2));
    }

    @Test
    public void testSerialize() throws Exception {
        // SetUp and Exercise
        User user1 = User$.getInstance().serializeModel("1 ababup1192");
        User user2 = new User(1, "ababup1192");
        // Verify
        assertThat(user1, is(user2));
    }

    @Test
    public void testSerializeResultIsNull() throws Exception {
        // SetUp and Exercise
        User user1 = User$.getInstance().serializeModel("noNumber ababup1192");
        // Verify
        assertThat(user1, is(nullValue()));
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