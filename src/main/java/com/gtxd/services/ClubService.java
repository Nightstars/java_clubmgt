package com.gtxd.services;

import com.gtxd.pojos.Club;
import com.gtxd.repository.ClubDao;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Data
public class ClubService {
    @Autowired
    ClubDao clubDao;
    String resault=null;
    //查询所有记录
    @Transactional(readOnly = true,isolation = Isolation.READ_COMMITTED)
    public List<Club> getAll(){
        return clubDao.getAll();
    }
    //插入数据
    @Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
    public String addClub(Club club){
        if(clubDao.getClubByname(club)==null){
            clubDao.addClub(club);
            resault="添加成功";
        }else {
            resault= "新增失败，俱乐部名称已存在";
        }
        return resault;
    }
    //编辑数据
    @Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
    public String editClub(Club club){
            clubDao.modifyClub(club);
            resault="修改成功";
        return resault;
    }
    //删除数据
    @Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
    public String deleteClub(Integer id){
        if(clubDao.getClubByPk(id).getMembers()==0){
            clubDao.deleteClub(id);
            resault="删除成功";
        }else {
            resault= "删除失败，该俱乐部存在会员，不能删除";
        }
        return resault;
    }
    //修改数据
    @Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
    public void modifyClub(Club club){
        clubDao.modifyClub(club);
    }
    //根据id查找数据
    @Transactional(readOnly = true,isolation = Isolation.READ_COMMITTED)
    public Club getClubByPk(Integer id){
        return clubDao.getClubByPk(id);
    }
}
