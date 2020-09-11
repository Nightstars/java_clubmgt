package com.gtxd.pojos;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ClubType {
    //主键id
    private Integer id;
    //类型名
    private String name;

    public ClubType() {
    }

    public ClubType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
