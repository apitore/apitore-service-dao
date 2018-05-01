package com.apitore.dao.service;

import java.util.List;

import com.apitore.dao.model.DBThreadComment;


public interface ThreadCommentService {
  public DBThreadComment get(Long commentId);
  public List<DBThreadComment> gets_OrderParentId(Long threadId);

  public DBThreadComment insert(DBThreadComment val);
  public void update(DBThreadComment val);
  public long count_byThreadId(Long threadId);
}