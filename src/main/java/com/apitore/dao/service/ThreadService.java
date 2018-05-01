package com.apitore.dao.service;

import java.util.List;

import com.apitore.dao.model.DBThread;


public interface ThreadService {
  public DBThread get(Long threadId);
  public List<DBThread> gets(String field, int offset, int limit);

  public DBThread insert(DBThread val);
  public void update(DBThread val);
}