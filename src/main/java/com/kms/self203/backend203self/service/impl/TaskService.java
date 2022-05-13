package com.kms.self203.backend203self.service.impl;

import com.kms.self203.backend203self.entity.Task;
import com.kms.self203.backend203self.repository.ITaskRepository;
import com.kms.self203.backend203self.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private ITaskRepository taskRepository;

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getById(String key) {
        return taskRepository.findById(key);
    }

    @Override
    public Task save(Task entity) {
        return taskRepository.save(entity);
    }

    @Override
    public List<Task> saveAll(List<Task> tasks){
        return taskRepository.saveAll(tasks);
    }

    @Override
    public void remove(Task entity) {
        taskRepository.delete(entity);
    }

    @Override
    public void removeById(String key) {
        taskRepository.deleteById(key);
    }
}
