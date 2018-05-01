package com.apitore.dao;

import java.util.List;

import com.apitore.dao.model.DBApi;


public interface ApiDAO {
  public List<DBApi> getApis_Enabled_Desc(String[] fields, int offset, int limit);
  public List<DBApi> getApis_Enabled_Free_Desc(String[] fields, int offset, int limit);
  public List<DBApi> getApis_Enabled_Paid_Desc(String[] fields, int offset, int limit);

  public List<DBApi> getApis_DevId_Desc_Public(long devId, String[] fields, int offset, int limit);
  public List<DBApi> getApis_UserId_Desc_Public(long userId, String[] fields, int offset, int limit);
  public List<DBApi> getApis_UserId_Desc_Private(long userId, String[] fields, int offset, int limit);

  public DBApi getApi(long apiId);

  public DBApi insert(DBApi val);
  public void update(DBApi val);

  public long countByDevId(Long devId);
  public long countByUserId(Long userId);
}