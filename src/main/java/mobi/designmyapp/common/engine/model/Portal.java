/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.engine.model;


import java.util.List;

/**
 * Created by Loïc Ortola on 7/7/14.
 */
public class Portal {

  private List<String> urls;

  /**
   * The name of the portal
   */
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getUrls() {
    return urls;
  }

  public void setUrls(List<String> urls) {
    this.urls = urls;
  }

  @Override
  public String toString() {
    return "Portal{" +
        "name='" + name + '\'' +
        ", urls='" + urls +
        '}';
  }
}
