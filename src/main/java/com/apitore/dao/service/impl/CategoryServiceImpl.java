package com.apitore.dao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.CategoryDAO;
import com.apitore.dao.model.DBCategory;
import com.apitore.dao.model.DBThread;
import com.apitore.dao.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  CategoryDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBCategory getCategory(String category) {
    return dao.get(category);
  }

  @Override
  @Transactional(readOnly=true)
  public DBCategory getCategoryLazyApi(String category, int offset, int limit) {
    DBCategory rtn = dao.get(category);
    Integer chk = null;
    // Top Rated
    chk = checkLazyList(rtn.getTopRatedList(), offset, limit);
    if (chk==null) {
      rtn.setTopRatedList(null);
    } else {
      rtn.setTopRatedList(rtn.getTopRatedList().subList(offset, chk));
    }
    // Recently Added
    chk = checkLazyList(rtn.getRecentlyAddedList(), offset, limit);
    if (chk==null) {
      rtn.setRecentlyAddedList(null);
    } else {
      rtn.setRecentlyAddedList(rtn.getRecentlyAddedList().subList(offset, chk));
    }
    // Top Free
    chk = checkLazyList(rtn.getMostCalledFreeList(), offset, limit);
    if (chk==null) {
      rtn.setMostCalledFreeList(null);
    } else {
      rtn.setMostCalledFreeList(rtn.getMostCalledFreeList().subList(offset, chk));
    }
    // Top Paid
    chk = checkLazyList(rtn.getMostCalledPaidList(), offset, limit);
    if (chk==null) {
      rtn.setMostCalledPaidList(null);
    } else {
      rtn.setMostCalledPaidList(rtn.getMostCalledPaidList().subList(offset, chk));
    }
    return dao.get(category);
  }
  @SuppressWarnings("rawtypes")
  private Integer checkLazyList(List list, int offset, int limit) {
    int size = list.size();
    if (size==0 || size<=offset) {
      return null;
    } else if (size>offset+limit) {
      return offset+limit;
    } else {
      return size;
    }
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBThread> getThread_RegisteredAt(String category, int offset, int limit) {
    DBCategory cat = dao.get(category);
    List<DBThread> rtn = cat.getRegisteredAtThread();
    Integer chk = checkLazyList(rtn, offset, limit);
    if (chk==null) {
      return new ArrayList<DBThread>();
    } else {
      return rtn.subList(offset, chk);
    }
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBThread> getThread_UpdatedAt(String category, int offset, int limit) {
    DBCategory cat = dao.get(category);
    List<DBThread> rtn = cat.getUpdatedAtThread();
    Integer chk = checkLazyList(rtn, offset, limit);
    if (chk==null) {
      return new ArrayList<DBThread>();
    } else {
      return rtn.subList(offset, chk);
    }
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBThread> getThread_NumWant(String category, int offset, int limit) {
    DBCategory cat = dao.get(category);
    List<DBThread> rtn = cat.getNumWantThread();
    Integer chk = checkLazyList(rtn, offset, limit);
    if (chk==null) {
      return new ArrayList<DBThread>();
    } else {
      return rtn.subList(offset, chk);
    }
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBThread> getThread_NumGood(String category, int offset, int limit) {
    DBCategory cat = dao.get(category);
    List<DBThread> rtn = cat.getNumGoodThread();
    Integer chk = checkLazyList(rtn, offset, limit);
    if (chk==null) {
      return new ArrayList<DBThread>();
    } else {
      return rtn.subList(offset, chk);
    }
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBCategory insert(DBCategory val) {
    return dao.insert(val);
  }

}