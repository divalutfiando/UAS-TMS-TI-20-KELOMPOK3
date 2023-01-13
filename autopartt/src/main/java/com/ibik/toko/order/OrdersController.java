package com.ibik.toko.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.ibik.toko.dto.OrderRelDto;
import com.ibik.toko.dto.ResponseData;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
  
  @Autowired
  private OrdersServices ordersServices;

  @PostMapping
  // public orders postPrograms(@Valid @RequestBody orders orders, Errors
  // errors){
  public ResponseEntity<ResponseData<Orders>> postPrograms(@Valid @RequestBody Orders orders, Errors errors) {
    ResponseData<Orders> responseData = new ResponseData<>();

    if (errors.hasErrors()) {
      for (ObjectError error : errors.getAllErrors()) {
        responseData.getMessage().add(error.getDefaultMessage());
        // System.out.println(error.getDefaultMessage());
      }
      responseData.setResult(false);
      responseData.setData(null);

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
      // throw new RuntimeException("Validation Error");
    }

    responseData.setResult(true);
    List<Orders> value = new ArrayList<>();
    value.add(ordersServices.save(orders));
    responseData.setData(value);
    return ResponseEntity.ok(responseData);

    // return ordersServices.save(orders);
  }

  // @PostMapping("/orderRel")
  // // public orders postPrograms(@Valid @RequestBody orders orders, Errors
  // // errors){
  // public ResponseEntity<ResponseData<OrderRelDto>> postPrograms(@Valid @RequestBody OrderRelDto orderRelDto, Errors errors) {
  //   ResponseData<OrderRelDto> responseData = new ResponseData<>();

  //   if (errors.hasErrors()) {
  //     for (ObjectError error : errors.getAllErrors()) {
  //       responseData.getMessage().add(error.getDefaultMessage());
  //       // System.out.println(error.getDefaultMessage());
  //     }
  //     responseData.setResult(false);
  //     responseData.setData(null);

  //     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
  //     // throw new RuntimeException("Validation Error");
  //   }

  //   responseData.setResult(true);
  //   List<String> message = new ArrayList<>();
  //   try{
  //     ordersServices.AddCart(orderRelDto.getId_order(), orderRelDto.getId_product(), orderRelDto.getQty());
  //     message.add("Berhasil Tersimpan!!");
  //   }catch (Exception e){
  //     message.add("Gagal Menyimpan!!");
  //   }
  //   responseData.setData(null);
  //   responseData.setMessage(message);
  //   return ResponseEntity.ok(responseData);

    // return ordersServices.save(orders);
  // }

  // @GetMapping
  // public ResponseEntity<ResponseData<OrderRelDto>> fetchCart() {
  //   ResponseData<Orders> responseData = new ResponseData<>();

  //   // return ordersServices.findAll();
  // }

  @GetMapping
  public ResponseEntity<ResponseData<Orders>> fetchorders() {
    ResponseData<Orders> responseData = new ResponseData<>();

    try {
      responseData.setResult(true);
      responseData.setMessage(null);
      List<Orders> value = (List<Orders>) ordersServices.findAll();
      responseData.setData(value);

      return ResponseEntity.ok(responseData);

    } catch (Exception e) {
      responseData.setResult(false);
      responseData.getMessage().add(e.getMessage());

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

    }
    // return ordersServices.findAll();
  }


  @GetMapping("/{id}")
  // public orders fetchProgramsById(@PathVariable("id") int id) {
  public ResponseEntity<ResponseData<Orders>> postorders(@Valid @PathVariable("id") int id, Orders orders,
      Errors errors) {
    ResponseData<Orders> responseData = new ResponseData<>();

    try {
      responseData.setResult(true);
      List<Orders> value = new ArrayList<>();
      value.add(ordersServices.findOne(id));

      responseData.setData(value);

      return ResponseEntity.ok(responseData);
    } catch (Exception e) {
      responseData.setResult(false);
      responseData.getMessage().add(e.getMessage());

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

    }
    // return ordersServices.findOne(id);
  }

  @PutMapping
  public ResponseEntity<ResponseData<Orders>> updateorders(@Valid @RequestBody Orders orders, Errors errors) {
    ResponseData<Orders> responseData = new ResponseData<>();

    if (orders.getId_order() != 0) {

      if (errors.hasErrors()) {
        for (ObjectError error : errors.getAllErrors()) {
          responseData.getMessage().add(error.getDefaultMessage());
        }
        responseData.setResult(false);
        responseData.setData(null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
      }

      responseData.setResult(true);
      List<Orders> value = new ArrayList<>();
      value.add(ordersServices.save(orders));
      responseData.setData(value);
      return ResponseEntity.ok(responseData);

    } else {
      responseData.setResult(false);
      responseData.setData(null);
      List<String> message = new ArrayList<>();
      message.add("ID is required");
      responseData.setMessage(message);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }
  }

  @DeleteMapping("/{id}")
  // public void deleteProgramsById(@PathVariable("id") int id) {
  public ResponseEntity<ResponseData<Orders>> deleteStudentsById(@PathVariable("id") int id) {
    ResponseData<Orders> responseData = new ResponseData<>();

    if (id != 0) {
      try {
        ordersServices.removeOne(id);
        responseData.setResult(true);
        responseData.getMessage().add("Successfully Removed");

        return ResponseEntity.ok(responseData);

      } catch (Exception e) {
        responseData.setResult(false);
        responseData.getMessage().add(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

      }

    } else {
      List<String> message = new ArrayList<>();
      message.add("ID is required");
      responseData.setMessage(message);
      responseData.setData(null);
      responseData.setResult(false);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }
    // ordersServices.removeOne(id);
  }

}


