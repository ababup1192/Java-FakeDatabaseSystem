package org.ababup1192.fds.models.database.table;

import org.ababup1192.fds.models.database.Database;
import org.ababup1192.fds.models.database.schemamodels.SchemaModelInterface;
import org.ababup1192.fds.models.database.schemamodels.SchemaModelInterface$;
import org.ababup1192.fds.utils.Path;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Table<T extends SchemaModelInterface> {
    protected String name;
    protected Path path;
    protected File file;
    protected Database db;
    protected SchemaModelInterface$<T> schemaModelInterface$;

    public Table(Database db, SchemaModelInterface$<T> schemaModelInterface$) {
        this.name = schemaModelInterface$.getTableName();
        this.db = db;
        path = new Path(db.getPath() + name + ".dat");
        file = new File(path.toString());
        this.schemaModelInterface$ = schemaModelInterface$;
    }

    public String getName() {
        return name;
    }

    public boolean create() throws IOException {
        return file.createNewFile();

    }

    public boolean insert(T data) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            if (!file.exists()) {
                create();
            }
            fileWriter.write(data.toData() + "\n");
            fileWriter.close();
            return true;
        } catch (
                IOException e
                )

        {
            e.printStackTrace();
            return false;
        }

    }

    public int insertList(List<T> dataList) {
        int insertCount = 0;

        for (T data : dataList) {
            if (insert(data)) insertCount++;
        }
        return insertCount;
    }

    public List<T> selectAll() {
        List<T> tableObjectList = new ArrayList<T>();
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                T tableObject = schemaModelInterface$.serializeModel(scanner.next());
                if (tableObject != null) {
                    tableObjectList.add(tableObject);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tableObjectList;
    }

    public T selectById(int id) {
        List<T> tableObjectList = selectAll();
        for (T tableObject : tableObjectList) {
            if (tableObject.getId() == id) {
                return tableObject;
            }
        }
        return null;
    }

    public boolean deleteById(int id) {
        T deleteObject = selectById(id);
        List<T> tableObjectList = selectAll();

        if (deleteObject == null) return false;
        else {
            if (delete()) {
                for (T tableObject : tableObjectList) {
                    if (id != tableObject.getId()) {
                        insert(tableObject);
                    }
                }
            }
            return true;
        }
    }

    public boolean delete() {
        return !file.exists() || file.delete();
    }
}
