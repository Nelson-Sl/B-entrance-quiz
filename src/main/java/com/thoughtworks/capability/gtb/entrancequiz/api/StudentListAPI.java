package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.Service.StudentListService;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Team;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

    @GetMapping("/randomTeams")
    public Team[] getRandomTeam() {return studentListService.getRandomTeams(); }

    @PostMapping("/students")
    public ResponseEntity addNewStudent(@RequestBody String studentName) {
         studentListService.addNewStudent(studentName);
        return ResponseEntity.ok().build();
    }
}
