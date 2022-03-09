package com.WQL.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "persion")
@Component
public class yaml_pojo {
        String name;
        int age;
        Date birthday;
        Boolean leader;
        List<String> friend;
        String[] Technologystack;
        Map<String,String> type;
        family ftype;
        Map<String,family> map;
        }
