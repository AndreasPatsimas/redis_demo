package org.patsimas.redis_demo.domain;

import lombok.*;
import org.patsimas.redis_demo.enums.Gender;
import org.springframework.data.redis.core.RedisHash;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Student")
public class Student {

    private String id;
    private String name;
    private Gender gender;
    private int grade;
}
