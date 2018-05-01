package com.apitore.dao;

import java.util.List;

import com.apitore.dao.model.DBUserApis;


public interface UserApisDAO {
  public DBUserApis getUserApis(long userId, long apiId);
  public List<DBUserApis> getUserApis_Desc(long userId, String field, int offset, int limit);

  public DBUserApis insert(DBUserApis val);
  public void update(DBUserApis val);

  public long count(Long userId);
}