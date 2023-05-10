package com.fido.api;

import java.util.Date;

public class Utils {
    public static void log(String msg, String level){
        System.out.println("[[" + level + "] " + (new Date()).toInstant().toString() + "] " + msg);
    }
}
