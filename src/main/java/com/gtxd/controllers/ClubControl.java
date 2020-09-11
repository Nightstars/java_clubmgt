package com.gtxd.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.gtxd.pojos.Club;
import com.gtxd.pojos.Result;
import com.gtxd.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClubControl {
    @Autowired
    ClubService clubService;
    ObjectMapper mapper=new ObjectMapper();
    //列出说有数据
    @RequestMapping("/index.html")
    public ModelAndView listClub(){
        ModelAndView modelAndView=new ModelAndView("list","clubList",clubService.getAll());
        return modelAndView;
    }
   //增加功能
    @RequestMapping(value = "/addClub",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addClub(Club club) throws JsonProcessingException {
        String result=clubService.addClub(club);
        Gson gson=new Gson();
        return gson.toJson(result);
    }
    //编辑功能
    @RequestMapping(value = "/editClub",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String editClub(Club club) throws JsonProcessingException {
        String result=clubService.editClub(club);
        Gson gson=new Gson();
        return gson.toJson(result);
    }
    //删除功能
    @RequestMapping("/deleteClub")
    public ModelAndView deleteClub(Integer id){
        String result=clubService.deleteClub(id);
        System.out.println(result);
        Result opResult=new Result(result,"index.html");
        ModelAndView modelAndView=new ModelAndView("list","clubList",clubService.getAll());
        modelAndView.addObject("result",opResult);
        return modelAndView;
    }
    //根据ID查询
    @RequestMapping("/getClubById")
    @ResponseBody
    public Club getClubById(Integer id){
        return clubService.getClubByPk(id);
    }
    //跳转到修改页面
    @RequestMapping("/toEditClub")
    public ModelAndView toEditClub(Integer id){
        ModelAndView modelAndView=new ModelAndView("list");
        modelAndView.addObject("clubList",clubService.getAll());
        modelAndView.addObject("isEdit",1);
        modelAndView.addObject("id",id);
        String tst="aaa";
        return modelAndView;

    }
}
