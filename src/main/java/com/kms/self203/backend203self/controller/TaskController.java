package com.kms.self203.backend203self.controller;

import com.kms.self203.backend203self.entity.Task;
import com.kms.self203.backend203self.service.ITaskService;
import com.kms.self203.backend203self.service.impl.TaskService;
import com.kms.self203.backend203self.utils.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @Autowired
    private CSVReader csvReader;

    @GetMapping
    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getOne(@PathVariable String id) {
        return taskService.getById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.save(task));
    }

    @PostMapping("import/csv")
    public ResponseEntity<List<Task>> importFromCsv(@RequestParam("file")MultipartFile file){

        try {
            return ResponseEntity.ok(taskService.saveAll(csvReader.csvToTask(file.getInputStream())));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable String id, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.save(task));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        taskService.removeById(id);
    }
}
