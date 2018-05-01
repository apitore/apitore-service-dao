package com.apitore.dao.common;


public enum EnumThread {
  REGISTERED("registerDate","登録日降順","registeredAt"),
  UPDATED("updateDate","更新日降順","updatedAt"),
  PRICE("price","価格降順","askPrice"),
  WANT("want","「欲しい」降順","numWant"),
  MAKE("make","「作る」降順","numMake"),
  GOOD("good","スコア降順","numGood");

  private final String id;
  private final String title;
  private final String field;
  private EnumThread(final String id, final String title, final String field) {
    this.id = id;
    this.title = title;
    this.field = field;
  }
  public String getId() {
    return id;
  }
  public String getTitle() {
    return title;
  }
  public String getField() {
    return field;
  }
  public static EnumThread getEnumFromId(String id) {
    if (REGISTERED.getId().equals(id))
      return REGISTERED;
    else if (UPDATED.getId().equals(id))
      return UPDATED;
    else if (PRICE.getId().equals(id))
      return PRICE;
    else if (WANT.getId().equals(id))
      return WANT;
    else if (MAKE.getId().equals(id))
      return MAKE;
    else if (GOOD.getId().equals(id))
      return GOOD;
    else
      return null;
  }
}
