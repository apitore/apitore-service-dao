package com.apitore.dao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.ThreadCommentDAO;
import com.apitore.dao.model.DBThreadComment;
import com.apitore.dao.service.ThreadCommentService;


@Service
public class ThreadCommentServiceImpl implements ThreadCommentService {

  @Autowired
  ThreadCommentDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBThreadComment get(Long commentId) {
    return dao.get(commentId);
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBThreadComment> gets_OrderParentId(Long threadId) {
    return dao.gets_OrderParentId(threadId);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBThreadComment insert(DBThreadComment val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBThreadComment val) {
    dao.update(val);
  }

  @Override
  @Transactional(readOnly=true)
  public long count_byThreadId(Long threadId) {
    return dao.count_byThreadId(threadId);
  }

}