package com.yunusb.springboot.util;

public final class ApiPaths {

  private static final String BASE_PATH="/api";

  public static final class EntityII {
    public static final String BPA = BASE_PATH+"/entity2";
  }

  public static final class EntityI {
    public static final String BPA = BASE_PATH+"/entity1";
  }

  public static final class User{
    public static final String BPA = BASE_PATH+"/users";
  }

}
