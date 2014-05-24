package org.ababup1192.fds.models.modelclass;

public class User implements TableModelInterface {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toData() {
        return id + " " + name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User(id=" + id + ", name=" + name + ")";
    }

    public boolean equals(Object user) {
        return user instanceof User && id == ((User) user).getId();
    }
}
