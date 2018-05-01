package com.apitore.dao;

import java.util.List;

import com.apitore.dao.model.DBFollow;
import com.apitore.dao.model.DBUserInfo;


public interface FollowDAO {
  public DBFollow get(Long fromId, Long toId);

  public List<DBUserInfo> getsByFromId(Long fromId, int offset, int limit);
  public List<DBUserInfo> getsByToId(Long toId, int offset, int limit);

  public DBFollow insert(DBFollow val);
  public void update(DBFollow val);
  public void delete(DBFollow val);

  public long countByFromId(Long fromId);
  public long countByToId(Long toId);
}