package com.apitore.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.UpdateDataDAO;
import com.apitore.dao.model.DBUpdateData;
import com.apitore.dao.service.UpdateDataService;


@Service
public class UpdateDataServiceImpl implements UpdateDataService {

  @Autowired
  UpdateDataDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBUpdateData get(Integer id) {
    return dao.get(id);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBUpdateData insert(DBUpdateData val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBUpdateData val) {
    dao.update(val);
  }

}