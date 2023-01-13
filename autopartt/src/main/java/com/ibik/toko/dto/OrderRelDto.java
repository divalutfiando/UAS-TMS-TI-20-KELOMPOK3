package com.ibik.toko.dto;

public class OrderRelDto {
  private int id_product;
  private int id_order;
  private int qty;

  public int getId_product() {
    return id_product;
  }
  public void setId_product(int id_product) {
    this.id_product = id_product;
  }
  public int getId_order() {
    return id_order;
  }
  public void setId_order(int id_order) {
    this.id_order = id_order;
  }
  public int getQty() {
    return qty;
  }
  public void setQty(int qty) {
    this.qty = qty;
  }

  
}
