package com.mt.service;

import com.mt.domain.Advertisement;
import com.mt.mapper.AdvertisementMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdvertisementService {

    @Resource
    private AdvertisementMapper advertisementMapper;

    public int addAdvertisement(Advertisement one){
        return advertisementMapper.insertSelective(one);
    }

    public int updateAdvertisement(Advertisement one){
        return advertisementMapper.updateByPrimaryKeySelective(one);
    }

    public int delAdvertisement(Integer id){
        return advertisementMapper.delById(id);
    }

    public List<Advertisement> list(){
        return advertisementMapper.list();
    }

    public Advertisement getById(Integer id){
        return advertisementMapper.selectByPrimaryKey(id);
    }

    public List<Advertisement> listByMemberId(Integer id){
        return advertisementMapper.listByMemberId(id);
    }

}
