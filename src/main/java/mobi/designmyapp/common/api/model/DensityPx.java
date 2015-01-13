/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.model;

public class DensityPx {

  private String density;
  private int width;
  private int height;

  public DensityPx(String density, int width, int height) {
    this.density = density;
    this.width = width;
    this.height = height;
  }

  public String getDensity() {
    return density;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("density=").append(this.density);
    sb.append(", ").append("width=").append(this.width);
    sb.append(", ").append("height=").append(this.height);
    return sb.toString();
  }

}
