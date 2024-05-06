package com.tms.regular_expression.task_0.models.parsers;

import com.tms.regular_expression.task_0.utils.FolderWithTxtFilesValidator;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FolderWithTxtFilesParser implements IParser {

    private String pathToFolder;
    private int countFileToParse;

    public FolderWithTxtFilesParser(String pathToFolder, int countFileToParse) {
        this.pathToFolder = pathToFolder;
        this.countFileToParse = countFileToParse;
    }

    @Override
    public void parse() {
        File folder = new File(this.pathToFolder);
        File[] txtFiles = FolderWithTxtFilesValidator.validate(folder, this.countFileToParse);

        TxtFileParser parser = new TxtFileParser();
        for (File file : txtFiles) {
            parser.setFile(file);
            parser.parse();
        }
    }

    public String getPathToFolder() {
        return pathToFolder;
    }

    public void setPathToFolder(String pathToFolder) {
        this.pathToFolder = pathToFolder;
    }

    public int getCountFileToParse() {
        return countFileToParse;
    }

    public void setCountFileToParse(int countFileToParse) {
        this.countFileToParse = countFileToParse;
    }

}
