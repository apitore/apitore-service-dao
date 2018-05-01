package com.apitore.dao.service;

import java.util.List;

import com.apitore.dao.model.DBUserThread;


public interface UserThreadService {
  public DBUserThread get(Long threadId, Long userId);
  public List<DBUserThread> gets(Long userId, int offset, int limit);

  public DBUserThread insert(DBUserThread val);
  public void update(DBUserThread val);
}