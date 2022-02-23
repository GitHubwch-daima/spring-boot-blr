package com.azure.service.impl;

import com.azure.dao.StudentDao;
import com.azure.entity.Student;
import com.azure.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {
}
