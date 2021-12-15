package com.nelluri.random;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Base64;

public class ExcelEncoder {
    String filePath ="src/test.xlsx";

    public String getEncodedContent() throws Exception {
        /*
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
        String plainString = contentBuilder.toString();
        String encodedString = Base64.getEncoder().encodeToString(plainString.getBytes());
        System.out.println(encodedString);
        return encodedString;
        */
        File inputFile = new File(filePath);
        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        System.out.println(encodedString);
        return encodedString;
    }

    public static void main(String[] args) throws Exception{
        ExcelEncoder excelEncoder = new ExcelEncoder();
        excelEncoder.getEncodedContent();
        ExcelParser parser = new ExcelParser();
        parser.parse( excelEncoder.getEncodedContent());
    }

    }
