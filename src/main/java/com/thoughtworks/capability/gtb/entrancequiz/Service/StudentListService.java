package com.thoughtworks.capability.gtb.entrancequiz.Service;

import com.thoughtworks.capability.gtb.entrancequiz.data.StudentData;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentListService {
    public List<Student> getStudentList() {
        return StudentData.getStudentList();
    }
}
