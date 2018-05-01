package com.apitore.dao;

import java.util.List;

import com.apitore.dao.model.DBApiUseLog;


public interface ApiUseLogDAO {
  public List<DBApiUseLog> getApiUseLog_ByUserId(long userId, int offset, int limit);

  public DBApiUseLog get_NotPaid();
  public List<DBApiUseLog> gets_NotPaid(long userId);
  public List<DBApiUseLog> gets_NotPaid(long apiId, long userId);

  public DBApiUseLog insert(DBApiUseLog value);
  public void update(DBApiUseLog value);
}