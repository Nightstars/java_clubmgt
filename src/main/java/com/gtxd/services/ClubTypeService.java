package com.gtxd.services;

import com.gtxd.pojos.ClubType;
import com.gtxd.repository.ClubTypeDao;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Data
public class ClubTypeService {
    @Autowired
    ClubTypeDao clubTypeDao;
    //查询所有类型
    @Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
    public List<ClubType> getAll(){
        return clubTypeDao.getAllType();
    }
}
