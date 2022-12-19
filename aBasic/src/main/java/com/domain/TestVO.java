package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 모든 인자 있는 생성자
//모든 인자 없는 생성자
@NoArgsConstructor
public class TestVO {
   
   private String name;
   private int age;
   
}