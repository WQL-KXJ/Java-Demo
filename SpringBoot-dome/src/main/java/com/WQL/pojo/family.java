package com.WQL.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@ToString
@Component
public class family {

    String name;
    String relation;
}
