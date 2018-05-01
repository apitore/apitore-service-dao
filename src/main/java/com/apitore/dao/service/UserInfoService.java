package com.apitore.dao.service;

import java.util.List;

import com.apitore.dao.model.DBUserInfo;


public interface UserInfoService {
  public List<DBUserInfo> getUserInfo();

  public DBUserInfo getUserInfo(long userId);
  public DBUserInfo getUserInfo(String username);
  public DBUserInfo getUserInfoByDisplayname(String displayname);

  public DBUserInfo insert(DBUserInfo val);
  public void update(DBUserInfo val);
}