package org.ababup1192.fds.models.database.table.usertype;

import org.ababup1192.fds.models.database.Database;
import org.ababup1192.fds.models.database.table.Table;
import org.ababup1192.fds.models.database.schemamodels.SchemaModelInterface$;
import org.ababup1192.fds.models.database.schemamodels.usertype.UserType;

import java.util.ArrayList;
import java.util.List;

abstract public class UserTypeTable<T extends UserType> extends Table<T> {
    public UserTypeTable(Database db, SchemaModelInterface$<T> schemaModelInterface$) {
        super(db, schemaModelInterface$);
    }

    public List<T> selectByName(String name) {
        List<T> userTypeObjList = selectAll();
        List<T> resultList = new ArrayList<T>();

        for (T userTypeObj : userTypeObjList) {
            if (userTypeObj.getName().equals(name)) {
                resultList.add(userTypeObj);
            }
        }
        return resultList;
    }

    public int deleteByName(String name) {
        List<T> deleteUserTypeObjList = selectByName(name);

        for (T deleteUserTypeObj : deleteUserTypeObjList) {
            deleteById(deleteUserTypeObj.getId());
        }
        return deleteUserTypeObjList.size();
    }

}
