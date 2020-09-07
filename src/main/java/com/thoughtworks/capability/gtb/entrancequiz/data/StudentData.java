package com.thoughtworks.capability.gtb.entrancequiz.data;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentData {
    private static List<Student> studentList = new ArrayList<>();

    public StudentData() {
        String[] students = new String[] {"沈乐棋","徐慧慧","陈思聪","王江林","王登宇","杨思雨","江雨舟","廖燊",
                "胡晓","但杰","盖迈达","肖美琦","黄云洁","齐瑾浩","刘亮亮","肖逸凡","王作文","郭瑞凌","李明豪","党泽"
                ,"肖伊佐","贠晨曦","李康宁","马庆","商婕","余榕","谌哲","董翔锐","陈泰宇","赵允齐","张柯","廖文强",
                "刘轲","廖浚斌","凌凤仪"};
        for(int index = 0; index < students.length; index++) {
            studentList.add(new Student(index+1,students[index]));
        }
    }

    public static List<Student> getStudentList() {
        return studentList;
    }
}
