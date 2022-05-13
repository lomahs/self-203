package com.kms.self203.backend203self.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IService<E, K> {

    List<E> getAll();

    Optional<E> getById(K key);

    E save(E entity);

    void remove(E entity);

    void removeById(K key);
}
