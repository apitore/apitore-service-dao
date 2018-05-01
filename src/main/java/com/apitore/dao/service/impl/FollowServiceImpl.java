package com.apitore.dao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.FollowDAO;
import com.apitore.dao.model.DBFollow;
import com.apitore.dao.model.DBUserInfo;
import com.apitore.dao.service.FollowService;


@Service
public class FollowServiceImpl implements FollowService {

  @Autowired
  FollowDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBFollow get(Long threadId, Long userId) {
    return dao.get(threadId, userId);
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBUserInfo> getsByFromId(Long fromId, int offset, int limit) {
    return dao.getsByFromId(fromId, offset, limit);
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBUserInfo> getsByToId(Long toId, int offset, int limit) {
    return dao.getsByToId(toId, offset, limit);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBFollow insert(DBFollow val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBFollow val) {
    dao.update(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void delete(DBFollow val) {
    dao.delete(val);
  }

  @Override
  @Transactional(readOnly=true)
  public long countByFromId(Long fromId) {
    return dao.countByFromId(fromId);
  }

  @Override
  @Transactional(readOnly=true)
  public long countByToId(Long toId) {
    return dao.countByToId(toId);
  }

}