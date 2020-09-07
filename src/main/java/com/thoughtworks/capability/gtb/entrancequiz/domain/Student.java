package com.thoughtworks.capability.gtb.entrancequiz.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getSet属性
@Builder //构建对象
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int sid;
    private String name;
}
