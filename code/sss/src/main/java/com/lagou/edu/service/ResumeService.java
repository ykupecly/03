package com.lagou.edu.service;

import com.lagou.edu.pojo.Resume;

import java.util.List;

public interface ResumeService {
    List<Resume> findAll();

    void save(Resume resume);

    void deleteById(Long id);
}
