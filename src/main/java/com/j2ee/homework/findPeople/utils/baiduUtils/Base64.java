package com.j2ee.homework.findPeople.utils.baiduUtils;
import sun.misc.BASE64Encoder;

import java.io.*;

public class Base64 {
    public static String encodeImageToBase64(File file){
        byte[] data = null;
        try{
            InputStream inputStream = new FileInputStream(file);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
}
