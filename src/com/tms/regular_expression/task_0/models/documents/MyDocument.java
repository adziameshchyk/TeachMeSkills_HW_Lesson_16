package com.tms.regular_expression.task_0.models.documents;

import java.util.ArrayList;
import java.util.List;

public class MyDocument {

    private final List<String> docNumbers = new ArrayList<>();
    private String phoneNumber;
    private String email;

    public List<String> getDocNumbers() {
        return docNumbers;
    }

    public void setDocNumber(String docNumber) {
        this.docNumbers.add(docNumber);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "MyDocument{" +
                "docNumbers=" + docNumbers +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
