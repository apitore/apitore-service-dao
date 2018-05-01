package com.apitore.dao.entity;

import lombok.Data;


@Data
public class AccountUpdate {
  String username;
  boolean removeThumbnail;
  String  familyname;
  String  firstname;
  String  displayname;
  String  affiliation;
  String  homepage;
  boolean open;
  String  description;

}
