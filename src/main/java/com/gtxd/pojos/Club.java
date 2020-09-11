package com.gtxd.pojos;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
//lombok 生成getter and setter 方法
@Data
//lombok 生成toString 方法，主要是测试用到
@ToString
public class Club {
    //主键id
    private Integer id;
    //俱乐部名
    private String name;
    //负责人
    private String manager;
    //类型名
    private String type;
    //类型编号
    private Integer typeId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //创建日期
    private Date createTime;
    //活动数
    private Integer activityNum;
    //会员数量
    private Integer members;

    public Club() {
    }
//含参构造方法
    public Club(Integer id, String name, String manager, String type, Integer typeId, Date createTime, Integer activityNum, Integer members) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.type = type;
        this.typeId = typeId;
        this.createTime = createTime;
        this.activityNum = activityNum;
        this.members = members;
    }
}
