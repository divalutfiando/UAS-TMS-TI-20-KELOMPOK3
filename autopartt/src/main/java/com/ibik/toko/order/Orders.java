package com.ibik.toko.order;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.ibik.toko.models.User;

@Entity
@Table(name="orders")
public class Orders implements Serializable{
  
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id_order;

  @Column(columnDefinition = "DATE")
  @NotEmpty(message = "date is required")
  private String buy_date;

  // @Column(length = 10)
  // private int product;
  
  // @Column(length = 10)
  // private int qty;

  @Column(length = 10)
  private int total;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private User user;

  @Column(name = "status")
	private boolean status;

  // @Column
  // private int customer_id;


  public Orders() {
  }

  public Orders(int id_order, @NotEmpty(message = "date is required") String buy_date, int product, int total, boolean status) {
    this.id_order = id_order;
    this.buy_date = buy_date;
    this.status = status;
    // this.product = product;
    // this.qty = qty;
    this.total = total;
    // this.customer_id = customer_id;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public int getId_order() {
    return id_order;
  }

  public void setId_order(int id_order) {
    this.id_order = id_order;
  }

  public String getBuy_date() {
    return buy_date;
  }

  public void setBuy_date(String buy_date) {
    this.buy_date = buy_date;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  // public int getProduct() {
  //   return product;
  // }

  // public void setProduct(int product) {
  //   this.product = product;
  // }

  // public int getQty() {
  //   return qty;
  // }

  // public void setQty(int qty) {
  //   this.qty = qty;
  // }

  

  // public int getCustomer_id() {
  //   return customer_id;
  // }

  // public void setCustomer_id(int customer_id) {
  //   this.customer_id = customer_id;
  // }

    

}
