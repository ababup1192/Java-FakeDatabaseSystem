package org.ababup1192.fds.utils;

public class Path {
    private String path;


    public Path(String path) {
        this.path = path.replace("~", System.getProperty("user.home"));
    }

    @Override
    public String toString() {
        return path;
    }

    @Override
    public boolean equals(Object path) {
        return path instanceof Path && this.path.equals(path.toString());
    }
}
