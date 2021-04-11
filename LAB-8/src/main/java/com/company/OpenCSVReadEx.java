package com.company;


import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import com.opencsv.exceptions.*;

public class OpenCSVReadEx {

    public static void main(String[] args) {
        try {

            CSVReader reader = new CSVReader(new FileReader("src/main/resources/credits.csv"));
            int i=0;
            String [] nextLine;
            int rowNumber = 0;
            while ((nextLine = reader.readNext()) != null && i < 2) {
                rowNumber++;
                String name = nextLine[0];
                //String name2 = nextLine[1];
                System.out.println(name);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        }
    }
