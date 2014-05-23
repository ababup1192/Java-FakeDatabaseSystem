package org.ababup1192.fds.models.modelclass;


public interface SerializableModel<T> {

    public T serializeModel(String data);

    public String getTableName();
}
