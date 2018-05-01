package com.apitore.dao;

import com.apitore.dao.model.DBUserReport;


public interface UserReportDAO {
  public DBUserReport get(Long apiId, Long userId);

  public DBUserReport insert(DBUserReport val);
  public void update(DBUserReport val);
}