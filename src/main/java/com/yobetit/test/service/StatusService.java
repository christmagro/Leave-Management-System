package com.yobetit.test.service;

import com.yobetit.test.entities.StatusEntity;
import com.yobetit.test.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Christian Magro on 14/07/2015.
 */
@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;


    public StatusEntity getStatus(Integer id){
      return statusRepository.findOne(id);
    }

    public String addStatus(StatusEntity statusEntity){
        statusRepository.save(statusEntity);

        return "ok";
    }
}
