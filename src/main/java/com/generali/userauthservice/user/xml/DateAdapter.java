package com.generali.userauthservice.user.xml;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAdapter extends XmlAdapter<String, LocalDateTime> {

        String GENERALI_DATE_FORMATTER = "dd-MM-yyyy HH:mm:ss:SSSSSS";

    @Override
    public LocalDateTime unmarshal(String s) throws Exception {
        return LocalDateTime.parse(s, DateTimeFormatter.ofPattern(GENERALI_DATE_FORMATTER));
    }

    @Override
    public String marshal(LocalDateTime localDateTime) throws Exception {
        return localDateTime.format(DateTimeFormatter.ofPattern(GENERALI_DATE_FORMATTER));
    }
}
