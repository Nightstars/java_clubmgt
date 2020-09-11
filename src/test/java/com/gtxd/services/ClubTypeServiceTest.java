package com.gtxd.services;

import com.gtxd.pojos.ClubType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/spring.xml")
public class ClubTypeServiceTest {
    @Autowired
    ClubTypeService clubTypeService;
    @Test
    public void getAllTest(){
        List<ClubType> clubTypeList=clubTypeService.getAll();
        System.out.println(clubTypeList);
    }
}
