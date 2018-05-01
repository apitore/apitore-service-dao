package com.apitore.dao.common;


public enum EnumCommercial {
  OK(1,"可"),
  CONDITIONAL(2,"条件付き可"),
  NG(3,"不可");

  private final int id;
  private final String str;
  private EnumCommercial(final int id, final String str) {
    this.id = id;
    this.str = str;
  }
  public int getId() {
    return id;
  }
  public String getStr() {
    return str;
  }
  public static EnumCommercial getEnumFromInt(int id) {
    if (id==1)
      return OK;
    else if (id==2)
      return CONDITIONAL;
    else if (id==3)
      return NG;
    else
      return null;
  }
}
