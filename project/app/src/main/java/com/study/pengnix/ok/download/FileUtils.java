package com.study.pengnix.ok.download;

import java.io.File;
import java.io.IOException;


public class FileUtils {
    public static boolean createFileByDeleteOldFile(final File file) {
        if (file == null) return false;
        // file exists and unsuccessfully delete then return false
        if (file.exists() && !file.delete()) return false;
        if (!createOrExistsDir(file.getParentFile())) return false;
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean createOrExistsDir(final File file) {
        return file != null && (file.exists() ? file.isDirectory() : file.mkdirs());
    }
}
