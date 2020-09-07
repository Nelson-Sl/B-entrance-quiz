package com.thoughtworks.capability.gtb.entrancequiz.Service;

import com.thoughtworks.capability.gtb.entrancequiz.data.StudentData;
import com.thoughtworks.capability.gtb.entrancequiz.data.TeamData;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentListService {
    public List<Student> getStudentList() {
        return StudentData.getStudentList();
    }

    public Team[] getRandomTeams() {
        return TeamData.getRandomTeams();
    }
}
