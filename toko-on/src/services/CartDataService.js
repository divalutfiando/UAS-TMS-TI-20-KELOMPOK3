import http from "./http-common";

class ProductDataService {
  getAll() {
    return http.get("/orders");
  }

  get(id) {
    return http.get(`/orders/${id}`);
  }

  create(data) {
    return http.post("/orders", data);
  }

  update(id, data) {
    return http.put(`/orders/${id}`, data);
  }

  delete(id) {
    return http.delete(`/orders/${id}`);
  }

  deleteAll() {
    return http.delete(`/orders`);
  }

  addToCart() {
    return http.post('/orders/orderRel')
  }

  // findByTitle(title) {
  //   return http.get(`/products?title=${title}`);
  // }
}

export default new ProductDataService();