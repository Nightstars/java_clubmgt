package com.gtxd.repository;

import com.gtxd.pojos.Club;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubDao {
    //查询所有
    public List<Club> getAll();
    //插入数据
    public void addClub(Club club);
    //删除数据
    public void deleteClub(Integer id);
    //修改数据
    public void modifyClub(Club club);
    //根据id查找数据
    public Club getClubByPk(Integer id);
    //根据名字查询数据
    public Club getClubByname(Club club);
}
