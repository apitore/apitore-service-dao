package com.apitore.dao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.MyfeedDAO;
import com.apitore.dao.model.DBMyfeed;
import com.apitore.dao.service.MyfeedService;


@Service
public class MyfeedServiceImpl implements MyfeedService {

  @Autowired
  MyfeedDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBMyfeed get(Long feedId) {
    return dao.get(feedId);
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBMyfeed> getsByUserId(Long feedId, int offset, int limit) {
    return dao.getsByUserId(feedId, offset, limit);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBMyfeed insert(DBMyfeed val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBMyfeed val) {
    dao.update(val);
  }

}