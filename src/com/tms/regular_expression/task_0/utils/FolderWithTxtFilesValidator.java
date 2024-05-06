package com.tms.regular_expression.task_0.utils;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class FolderWithTxtFilesValidator {

    private static File folder;

    private static final String NOT_FOLDER_MESSAGE = "The passed path is not a directory.";
    private static final String NOT_CONTAIN_FILES = "The folder does not contain files.";
    private static final String NOT_CONTAIN_TXT_FILES = "The folder does not contain txt files.";
    private static final String TXT_LESS_THAN_REQUEST = "The number of txt files is less than the requested number for processing.";

    public static File[] validate(File file, int countFilesToParse) {
        FolderWithTxtFilesValidator.folder = file;

        isDirectory();
        isContainsFiles();

        FileFilter txtFilter = f -> f.isFile() && f.getName().endsWith(".txt");
        File[] txtFiles = folder.listFiles(txtFilter);

        isContainsTxtFiles(txtFiles);
        isTxtFilesAreEnough(txtFiles, countFilesToParse);

        return Arrays.stream(txtFiles).limit(countFilesToParse).toArray(File[]::new);
    }

    private static void isDirectory() {
        if (!folder.isDirectory()) {
            throw new RuntimeException(NOT_FOLDER_MESSAGE);
        }
    }

    private static void isContainsFiles() {
        FileFilter fileFilter = File::isFile;
        File[] files = folder.listFiles(fileFilter);
        if (files != null && files.length == 0) {
            throw new RuntimeException(NOT_CONTAIN_FILES);
        }
    }

    private static void isContainsTxtFiles(File[] txtFiles) {
        if (txtFiles != null && txtFiles.length == 0) {
            throw new RuntimeException(NOT_CONTAIN_TXT_FILES);
        }
    }

    private static void isTxtFilesAreEnough(File[] txtFiles, int countFileToParse) {
        if (txtFiles.length < countFileToParse) {
            throw new RuntimeException(TXT_LESS_THAN_REQUEST);
        }
    }

}
