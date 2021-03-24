package com.lyl.springboot.ossd.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateId {
    public static String generateId(){
        SimpleDateFormat df = new SimpleDateFormat("MMddyyyyHHmmss");
        String id = df.format(new Date());
        return id;
    }

    public static void main(String[] args) {
        System.out.println(generateId());
    }
}
