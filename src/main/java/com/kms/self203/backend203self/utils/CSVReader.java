package com.kms.self203.backend203self.utils;

import com.kms.self203.backend203self.entity.Task;
import com.kms.self203.backend203self.service.IUserService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVReader {

    @Autowired
    private IUserService userService;

    public List<Task> csvToTask(InputStream inputStream){
        List<Task> tasks = new ArrayList<>();

        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            for (CSVRecord csvRecord : csvParser) {
                Task task = new Task(
                        csvRecord.get("ID"),
                        csvRecord.get("TASK"),
                        csvRecord.get("ISCOMPLETED").equals("true"),
                        userService.getById(csvRecord.get("USERID")).get()
                );

                tasks.add(task);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }
}
