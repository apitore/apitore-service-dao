package com.apitore.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.UserRoleDAO;
import com.apitore.dao.model.DBUserRole;
import com.apitore.dao.service.UserRoleService;


@Service
public class UserRoleServiceImpl implements UserRoleService {

  @Autowired
  UserRoleDAO dao;


  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBUserRole insert(DBUserRole val) {
    return dao.insert(val);
  }

}