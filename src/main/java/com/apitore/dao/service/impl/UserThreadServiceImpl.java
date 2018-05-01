package com.apitore.dao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.UserThreadDAO;
import com.apitore.dao.model.DBUserThread;
import com.apitore.dao.service.UserThreadService;


@Service
public class UserThreadServiceImpl implements UserThreadService {

  @Autowired
  UserThreadDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBUserThread get(Long threadId, Long userId) {
    return dao.get(threadId, userId);
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBUserThread> gets(Long userId, int offset, int limit) {
    return dao.gets(userId, offset, limit);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBUserThread insert(DBUserThread val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBUserThread val) {
    dao.update(val);
  }

}