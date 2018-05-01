package com.apitore.dao;

import java.util.List;

import com.apitore.dao.model.DBThread;


public interface ThreadDAO {
  public DBThread get(Long threadId);
  public List<DBThread> gets(String field, int offset, int limit);

  public DBThread insert(DBThread val);
  public void update(DBThread val);
}