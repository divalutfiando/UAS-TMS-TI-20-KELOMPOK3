package com.ibik.toko.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrdersServices {
 
  @Autowired
  private OrdersRepo ordersRepo;

  public Orders save(Orders orders){
    return ordersRepo.save(orders);
  }

  public Orders findOne(int id){
    return ordersRepo.findById(id).get();
  }

  public void findCart(int id_order){
    ordersRepo.findById(id_order).get();
  }

  public Iterable<Orders> findAll(){
    return ordersRepo.findAll();
  }

  // public void findOll(int id_product, int id_order, int qty){
  //   ordersRepo.getCartById(id_product, id_order, qty);
  // }

  public void removeOne(int id){
    ordersRepo.deleteById(id);
  }

  // public void AddCart(int id_product, int id_order, int qty){
  //   ordersRepo.addToCart(id_product, id_order, qty);
  // }

}
