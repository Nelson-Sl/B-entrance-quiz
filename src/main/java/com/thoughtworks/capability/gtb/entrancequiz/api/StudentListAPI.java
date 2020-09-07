package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.Service.StudentListService;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentListAPI {
    private final StudentListService studentListService;

    public StudentListAPI(StudentListService studentListService) {
        this.studentListService = studentListService;
    }

    @GetMapping("/students")
    public List<Student> getStudentList() {
        return studentListService.getStudentList();
    }
}
