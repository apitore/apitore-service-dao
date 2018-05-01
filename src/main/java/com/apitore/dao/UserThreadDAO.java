package com.apitore.dao;

import java.util.List;

import com.apitore.dao.model.DBUserThread;


public interface UserThreadDAO {
  public DBUserThread get(Long threadId, Long userId);
  public List<DBUserThread> gets(Long userId, int offset, int limit);

  public DBUserThread insert(DBUserThread val);
  public void update(DBUserThread val);
}