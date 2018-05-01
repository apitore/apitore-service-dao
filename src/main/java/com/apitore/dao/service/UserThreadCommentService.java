package com.apitore.dao.service;

import com.apitore.dao.model.DBUserThreadComment;


public interface UserThreadCommentService {
  public DBUserThreadComment get(Long commentId, Long userId);

  public DBUserThreadComment insert(DBUserThreadComment val);
  public void update(DBUserThreadComment val);
}