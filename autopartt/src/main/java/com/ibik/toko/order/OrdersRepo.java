package com.ibik.toko.order;

// import javax.transaction.Transactional;

// import org.springframework.data.jpa.repository.Modifying;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.repository.query.Param;

public interface OrdersRepo extends CrudRepository<Orders, Integer> {
//   @Modifying
//   @Transactional
//   @Query(value = "INSERT INTO order_rel_product(id_product, id_order, qty) VALUES (:id_product,:id_order,:qty)", nativeQuery = true)
//   public void addToCart(@Param("id_product") int id_product, @Param("id_order") int id_order,
//       @Param("qty") int qty);

//   @Query(value = "SELECT a.id_product, a.id_order, a.qty FROM order_rel_product WHERE a.id_order :id_order", nativeQuery = true)
//   public void getCartById(@Param("id_product") int id_product, @Param("id_order") int id_order,
//       @Param("qty") int qty);
}
