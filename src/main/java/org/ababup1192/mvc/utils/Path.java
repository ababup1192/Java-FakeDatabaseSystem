package org.ababup1192.mvc.utils;

public class Path {
    private String path;


    public Path(String path) {
        this.path = path.replace("~", System.getProperty("user.home"));
    }

    public String getPath() {
        return path;
    }
}
