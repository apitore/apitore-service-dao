package com.apitore.dao;

import java.util.List;

import com.apitore.dao.model.DBMyfeed;


public interface MyfeedDAO {
  public DBMyfeed get(Long feedId);
  public List<DBMyfeed> getsByUserId(Long userId, int offset, int limit);

  public DBMyfeed insert(DBMyfeed val);
  public void update(DBMyfeed val);
}