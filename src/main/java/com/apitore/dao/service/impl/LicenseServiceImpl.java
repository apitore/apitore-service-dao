package com.apitore.dao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.LicenseDAO;
import com.apitore.dao.model.DBLicense;
import com.apitore.dao.service.LicenseService;


@Service
public class LicenseServiceImpl implements LicenseService {

  @Autowired
  LicenseDAO dao;


  @Override
  @Transactional(readOnly=true)
  public List<DBLicense> get() {
    return dao.get();
  }

}