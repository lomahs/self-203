package com.kms.self203.backend203self.repository;

import com.kms.self203.backend203self.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends JpaRepository<Task, String> {
}
