package com.apitore.dao.service;

import java.util.List;

import com.apitore.dao.model.DBThread;
import com.apitore.dao.model.DBThreadFollow;


public interface ThreadFollowService {
  public DBThreadFollow get(Long userId, Long threadId);
  public List<DBThread> getsByUserId(Long userId, int offset, int limit);

  public DBThreadFollow insert(DBThreadFollow val);
  public void update(DBThreadFollow val);
}