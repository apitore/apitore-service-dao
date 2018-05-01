package com.apitore.dao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.ThreadFollowDAO;
import com.apitore.dao.model.DBThread;
import com.apitore.dao.model.DBThreadFollow;
import com.apitore.dao.service.ThreadFollowService;


@Service
public class ThreadFollowServiceImpl implements ThreadFollowService {

  @Autowired
  ThreadFollowDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBThreadFollow get(Long userId, Long threadId) {
    return dao.get(userId, threadId);
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBThread> getsByUserId(Long userId, int offset, int limit) {
    return dao.getsByUserId(userId, offset, limit);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBThreadFollow insert(DBThreadFollow val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBThreadFollow val) {
    dao.update(val);
  }

}