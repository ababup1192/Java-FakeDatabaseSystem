package org.ababup1192.fds.controllers;

import org.ababup1192.fds.controllers.manipulate.DBManipulateState;
import org.ababup1192.fds.controllers.manipulate.selector.DBManipulateSelector;

import java.io.IOException;

public class DataBaseSimulator {

    public static void main(String args[]) {

        DBManipulateState states = new DBManipulateSelector();

        while (states != null) {
            states = states.execute();
        }

        System.out.println("データベースシステムは終了しました。");
    }

}