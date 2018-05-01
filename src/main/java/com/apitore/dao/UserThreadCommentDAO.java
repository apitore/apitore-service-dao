package com.apitore.dao;

import com.apitore.dao.model.DBUserThreadComment;


public interface UserThreadCommentDAO {
  public DBUserThreadComment get(Long commentId, Long userId);

  public DBUserThreadComment insert(DBUserThreadComment val);
  public void update(DBUserThreadComment val);
}