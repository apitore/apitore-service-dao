package com.apitore.dao.service;

import com.apitore.dao.model.DBUserReport;


public interface UserReportService {
  public DBUserReport get(Long apiId, Long userId);

  public DBUserReport insert(DBUserReport val);
  public void update(DBUserReport val);
}