package com.gtxd.controllers;

import com.gtxd.pojos.ClubType;
import com.gtxd.services.ClubTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ClubTypeControl {
    @Autowired
    ClubTypeService clubTypeService;
    //获取俱乐部类型
    @RequestMapping("/getAllType")
    @ResponseBody
    public List<ClubType> listClubType(){
        return clubTypeService.getAll();
    }
}
