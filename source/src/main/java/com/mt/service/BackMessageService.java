package com.mt.service;

import com.mt.domain.BackMessage;
import com.mt.mapper.BackMessageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BackMessageService {

   @Resource
   private BackMessageMapper backMessageMapper;

   public int addBackMessage(BackMessage one){
       return backMessageMapper.insertSelective(one);
   }

   public int updateBackMessage(BackMessage  one){
       return backMessageMapper.updateByPrimaryKeySelective(one);
   }

   public int delBackMessage(Integer id){
       return backMessageMapper.delById(id);
   }

   public List<BackMessage> listByArticleId(Integer id){
       return backMessageMapper.listByArticleId(id);
   }
}
