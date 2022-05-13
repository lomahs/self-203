package com.kms.self203.backend203self.service;

import com.kms.self203.backend203self.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITaskService extends IService<Task, String>{

    List<Task> saveAll(List<Task> tasks);
}
