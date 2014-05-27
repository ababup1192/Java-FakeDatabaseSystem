package org.ababup1192.fds.models.database.schemamodels.usertype;

import org.ababup1192.fds.models.database.schemamodels.SchemaModelInterface;

abstract public class UserType implements SchemaModelInterface {
    protected int id;
    protected String name;

    public UserType(int id, String name) {
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
        return getClass().getSimpleName() + "(id=" + id + ", name=" + name + ")";
    }


    @Override
    public boolean equals(Object user) {
        return user instanceof UserType && id == ((UserType) user).getId();
    }
}
