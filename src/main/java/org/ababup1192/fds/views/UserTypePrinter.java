package org.ababup1192.fds.views;

import org.ababup1192.fds.models.database.schemamodels.usertype.UserType;

import java.util.List;

public class UserTypePrinter {

    public static <T extends UserType> void printUserType(T userType) {
        System.out.println(userType.toString());
    }

    public static <T extends UserType> void printUserTypeList(List<T> userTypeList) {
        for (T userType : userTypeList) {
            System.out.println(userType.toString());
        }
    }

}
