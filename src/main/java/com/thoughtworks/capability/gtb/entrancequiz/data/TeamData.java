package com.thoughtworks.capability.gtb.entrancequiz.data;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Team;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class TeamData {
    private static final String DEFAULT_TEAM_NAME_PREFIX = "Team ";
    private static List<Student> shuffleStudentList =  new ArrayList<>();
    private static Team[] teamList = new Team[] {
            new Team(DEFAULT_TEAM_NAME_PREFIX + 1, new ArrayList<Student>()),
            new Team(DEFAULT_TEAM_NAME_PREFIX + 2, new ArrayList<Student>()),
            new Team(DEFAULT_TEAM_NAME_PREFIX + 3, new ArrayList<Student>()),
            new Team(DEFAULT_TEAM_NAME_PREFIX + 4, new ArrayList<Student>()),
            new Team(DEFAULT_TEAM_NAME_PREFIX + 5, new ArrayList<Student>()),
            new Team(DEFAULT_TEAM_NAME_PREFIX + 6, new ArrayList<Student>()),
    };

    public TeamData() {
        List<Student> currentStudentList = StudentData.getStudentList();
        for(Student student: currentStudentList) {
            shuffleStudentList.add(student);
        }
    }

    public static Team[] getRandomTeams() {
        int randomRound = (int) Math.ceil((double) shuffleStudentList.size() / teamList.length);

        //打乱排序
        Collections.shuffle(shuffleStudentList);

        //第一轮清空team的学生，然后逐次添加
        for(int round = 0; round < randomRound; round++) {
            int teamChosenTime = round == randomRound - 1 ? shuffleStudentList.size() % teamList.length : teamList.length;
            for(int team = 0; team < teamChosenTime; team++) {
                if(round == 0) {
                    teamList[team].setTeamMembers(new ArrayList<Student>());
                }
                teamList[team].getTeamMembers().add(shuffleStudentList.get(round * teamList.length + team));
            }
        }

        return teamList;
    }
}
