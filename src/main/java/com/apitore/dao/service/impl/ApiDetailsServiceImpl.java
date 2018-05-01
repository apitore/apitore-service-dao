package com.apitore.dao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.ApiDetailsDAO;
import com.apitore.dao.model.DBApiDetails;
import com.apitore.dao.service.ApiDetailsService;


@Service
public class ApiDetailsServiceImpl implements ApiDetailsService {

  @Autowired
  ApiDetailsDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBApiDetails get(long apiId) {
    return dao.get(apiId);
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBApiDetails> getApiDetails_GT_Date(Date from) {
    return dao.getApiDetails_GT_Date(from);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBApiDetails insert(DBApiDetails val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBApiDetails val) {
    dao.update(val);
  }

}