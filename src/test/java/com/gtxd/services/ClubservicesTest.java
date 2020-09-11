package com.gtxd.services;

import com.gtxd.pojos.Club;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/spring.xml")
public class ClubservicesTest {
    @Autowired
    ClubService clubService;
    @Test
    public void getAllTest(){
        List<Club> clubList=clubService.getAll();
        System.out.println(clubList);
    }
    @Test
    public void addClubTest(){
        clubService.addClub(new Club(0,"新点篮球俱乐部","王五","",3,new Date(),50,30));
    }
    @Test
    public void modifyClubTest(){
        clubService.modifyClub(new Club(3,"新点篮球俱乐部","王五","",3,new Date(),50,40));
    }
    @Test
    public void getClubByPkClubTest(){
        System.out.println(clubService.getClubByPk(1));
    }
}
