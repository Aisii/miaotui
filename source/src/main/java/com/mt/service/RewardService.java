package com.mt.service;

import com.mt.domain.Reward;
import com.mt.mapper.RewardMapper;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RewardService {

    @Resource
    private RewardMapper rewardMapper;

    public int addReward(Reward one){
        return rewardMapper.insertSelective(one);
    }

    public int updateReward(Reward one){
        return rewardMapper.updateByPrimaryKeySelective(one);
    }

    public List<Reward> list(){
        return rewardMapper.list();
    }
}
