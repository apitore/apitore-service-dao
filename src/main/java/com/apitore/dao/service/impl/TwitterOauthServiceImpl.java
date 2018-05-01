package com.apitore.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.TwitterOauthDAO;
import com.apitore.dao.model.DBTwitterOauth;
import com.apitore.dao.service.TwitterOauthService;


@Service
public class TwitterOauthServiceImpl implements TwitterOauthService {

  @Autowired
  TwitterOauthDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBTwitterOauth get(Long userId) {
    return dao.get(userId);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBTwitterOauth insert(DBTwitterOauth val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBTwitterOauth val) {
    dao.update(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void delete(DBTwitterOauth val) {
    dao.delete(val);
  }

}