package com.example.week2_lifecycle;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TextFileManager {

    private static final String FILE_NAME = "Memo.txt";
    Context mContext = null;

    public TextFileManager(Context context) {
        mContext = context;
    }

    public void save(String strData) {
        if (strData == null || strData.equals("")) {
            return;
        }

        FileOutputStream fosMemo = null;

        try {
            fosMemo = mContext.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fosMemo.write(strData.getBytes());
            fosMemo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String load() {
        try {
            FileInputStream fisMemo = mContext.openFileInput(FILE_NAME);
            byte[] memoData = new byte[fisMemo.available()];
            while (fisMemo.read(memoData) != -1) {
            }
            return new String(memoData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void delete() {
        mContext.deleteFile(FILE_NAME);
    }

}
