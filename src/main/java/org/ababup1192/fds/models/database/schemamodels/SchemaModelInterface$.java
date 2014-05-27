package org.ababup1192.fds.models.database.schemamodels;

public interface SchemaModelInterface$<T> {
    T serializeModel(String data);

    String getTableName();
}
