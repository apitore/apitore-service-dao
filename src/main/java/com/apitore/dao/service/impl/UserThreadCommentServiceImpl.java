package com.apitore.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.UserThreadCommentDAO;
import com.apitore.dao.model.DBUserThreadComment;
import com.apitore.dao.service.UserThreadCommentService;


@Service
public class UserThreadCommentServiceImpl implements UserThreadCommentService {

  @Autowired
  UserThreadCommentDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBUserThreadComment get(Long commentId, Long userId) {
    return dao.get(commentId, userId);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBUserThreadComment insert(DBUserThreadComment val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBUserThreadComment val) {
    dao.update(val);
  }

}