<template>
  <div class="mx-auto row w-75">
    <div class="col-md-12">
      <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="Search by Product name" v-model="title" />
        <div class="input-group-append">
          <button class="btn btn-outline-secondary" type="button" @click="searchTitle">
            Search
          </button>
        </div>
      </div>
    </div>
    <div class="col-md-8">
      <h4>Products List</h4>
      <div class="row">
        <div class="col-sm-4 " :class="{ active: index == currentIndex }" v-for="(product, index) in products" :key="index" @click="setActiveProduct(product, index)">
          <div class="card mt-5" style="width: 250px; ">
            <img :src="require('@/assets/products/' + product.image)" />
            <div class="card-body">
              <h5 class="card-title">{{ product.title }}</h5>
              <p class="card-text">{{ product.description }}</p>
              <p class="btn btn-primary">Rp. {{ product.price }}</p>
            </div>
          </div>
        </div>
      </div>

      <!-- <button class="m-3 btn btn-sm btn-danger" @click="removeAllProducts">
        Remove All
      </button> -->
    </div>
    <div class="col-md-3 mt-5 pt-4 ml-5">
      <div v-if="currentProduct">
        <h4>Product</h4>
        <div>
          <label><strong>Product Name:</strong></label> {{ currentProduct.title }}
        </div>
        <router-link :to="'/products/' + currentProduct.id" class="badge badge-warning">Details</router-link>
      </div>
      <div v-else>
      </div>
    </div>
  </div>
</template>

<script>
import ProductDataService from "../services/ProductDataService";

export default {
  name: "products-list",
  data() {
    return {
      products: [],
      currentProduct: null,
      currentIndex: -1,
      title: ""
    };
  },
  methods: {
    retrieveProducts() {
      ProductDataService.getAll()
        .then(response => {
          this.products = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    refreshList() {
      this.retrieveProducts();
      this.currentProduct = null;
      this.currentIndex = -1;
    },

    setActiveProduct(product, index) {
      this.currentProduct = product;
      this.currentIndex = product ? index : -1;
    },

    removeAllProducts() {
      ProductDataService.deleteAll()
        .then(response => {
          console.log(response.data);
          this.refreshList();
        })
        .catch(e => {
          console.log(e);
        });
    },

    searchTitle() {
      ProductDataService.findByTitle(this.title)
        .then(response => {
          this.products = response.data;
          this.setActiveProduct(null);
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    addToCart(){
      
    }
  },
  mounted() {
    this.retrieveProducts();
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>