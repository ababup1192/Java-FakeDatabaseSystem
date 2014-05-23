package org.ababup1192.fds.models.database;

import org.ababup1192.fds.models.modelclass.SerializableModel;
import org.ababup1192.fds.models.modelclass.TableObjectInterface;
import org.ababup1192.fds.utils.Path;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Table<T extends TableObjectInterface> {
    protected String name;
    protected Path path;
    protected File file;
    protected Database db;
    protected SerializableModel<T> singletonModel;

    public Table(Database db, SerializableModel<T> singletonModel) {
        this.name = singletonModel.getTableName();
        this.db = db;
        path = new Path(db.getPath() + name + ".dat");
        file = new File(path.toString());
        this.singletonModel = singletonModel;
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

    public List<T> selectAll() {
        List<T> tableObjectList = new ArrayList<T>();
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                T tableObject = singletonModel.serializeModel(scanner.next());
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
            if (tableObject.getId() == id){
                return tableObject;
            }
        }
        return null;
    }

    public boolean delete() {
        return !file.exists() || file.delete();
    }
}
