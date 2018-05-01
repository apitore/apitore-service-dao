package com.apitore.dao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.ThreadDAO;
import com.apitore.dao.model.DBThread;
import com.apitore.dao.service.ThreadService;


@Service
public class ThreadServiceImpl implements ThreadService {

  @Autowired
  ThreadDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBThread get(Long threadId) {
    return dao.get(threadId);
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBThread> gets(String field, int offset, int limit) {
    return dao.gets(field, offset, limit);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBThread insert(DBThread val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBThread val) {
    dao.update(val);
  }

}