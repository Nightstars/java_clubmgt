package com.gtxd.repository;

import com.gtxd.pojos.ClubType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubTypeDao {
    //查询所有类型
    public List<ClubType> getAllType();
}
