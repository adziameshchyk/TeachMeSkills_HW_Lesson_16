package com.tms.regular_expression.task_0.models.parsers;

import com.tms.regular_expression.task_0.models.data.DataStorage;
import com.tms.regular_expression.task_0.models.documents.MyDocument;
import com.tms.regular_expression.task_0.models.parsers.IParser;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtFileParser implements IParser {


    private File file;

    @Override
    public void parse() {
        MyDocument document = new MyDocument();

        Pattern docPattern = Pattern.compile("\\d{4}[-][a-zа-я]{3}[-]\\d{4}[-][a-zа-я]{3}[-]\\d[a-zа-я]\\d[a-zа-я]", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Pattern phonePattern = Pattern.compile("(\\+*)[(]\\d{2}[)]\\d{7}([\\W\\n\\t]|$)");
        Pattern emailPattern = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}", Pattern.CASE_INSENSITIVE);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                Matcher docMatcher = docPattern.matcher(line);
                Matcher phoneMatcher = phonePattern.matcher(line);
                Matcher emailMatcher = emailPattern.matcher(line);

                if (docMatcher.find()) {
                    document.setDocNumber(docMatcher.group());
                }
//                while (docMatcher.find()) {
//                    document.setDocNumber(docMatcher.group());
//                }

                if (phoneMatcher.find()) {
                    document.setPhoneNumber(phoneMatcher.group());
                }

                if (emailMatcher.find()) {
                    document.setEmail(emailMatcher.group());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DataStorage.data.put(this.file.getName(), document);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
