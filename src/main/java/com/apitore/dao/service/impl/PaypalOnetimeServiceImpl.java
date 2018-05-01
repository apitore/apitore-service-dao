package com.apitore.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.PaypalOnetimeDAO;
import com.apitore.dao.model.DBPaypalOnetime;
import com.apitore.dao.service.PaypalOnetimeService;


@Service
public class PaypalOnetimeServiceImpl implements PaypalOnetimeService {

  @Autowired
  PaypalOnetimeDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBPaypalOnetime get(String id) {
    return dao.get(id);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBPaypalOnetime insert(DBPaypalOnetime val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBPaypalOnetime val) {
    dao.update(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void delete(DBPaypalOnetime val) {
    dao.delete(val);
  }

}