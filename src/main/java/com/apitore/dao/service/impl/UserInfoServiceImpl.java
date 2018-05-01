package com.apitore.dao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.UserInfoDAO;
import com.apitore.dao.model.DBUserInfo;
import com.apitore.dao.service.UserInfoService;


@Service
public class UserInfoServiceImpl implements UserInfoService {

  @Autowired
  UserInfoDAO dao;


  @Override
  @Transactional(readOnly=true)
  public List<DBUserInfo> getUserInfo() {
    return dao.getUserInfo();
  }

  @Override
  @Transactional(readOnly=true)
  public DBUserInfo getUserInfo(String username) {
    return dao.getUserInfo(username);
  }

  @Override
  @Transactional(readOnly=true)
  public DBUserInfo getUserInfoByDisplayname(String displayname) {
    return dao.getUserInfoByDisplayname(displayname);
  }

  @Override
  @Transactional(readOnly=true)
  public DBUserInfo getUserInfo(long userId) {
    return dao.getUserInfo(userId);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBUserInfo insert(DBUserInfo val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBUserInfo val) {
    dao.update(val);
  }

}