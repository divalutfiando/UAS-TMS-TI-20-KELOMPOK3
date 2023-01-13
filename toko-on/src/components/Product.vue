<template>
  <div v-if="currentProduct" class="edit-form">
    <h4>Product</h4>
    <div class="row">
      <div class="col-md-6">
        <img class="img-fluid" :src="bannerImage" alt="" />
        <div class="product-thumbnails">
          <ul>
            <img :src="require('@/assets/products/' + currentProduct.image)" />
          </ul>
        </div>
      </div>
      <div class="col-md-4">
        <h1 class="my-4">{{ currentProduct.title }}</h1>
        <h3 class="my-3">
          <svg width="36" height="36" viewBox="0 0 24 24">
            <path
              d="M17,18C15.89,18 15,18.89 15,20A2,2 0 0,0 17,22A2,2 0 0,0 19,20C19,18.89 18.1,18 17,18M1,2V4H3L6.6,11.59L5.24,14.04C5.09,14.32 5,14.65 5,15A2,2 0 0,0 7,17H19V15H7.42A0.25,0.25 0 0,1 7.17,14.75C7.17,14.7 7.18,14.66 7.2,14.63L8.1,13H15.55C16.3,13 16.96,12.58 17.3,11.97L20.88,5.5C20.95,5.34 21,5.17 21,5A1,1 0 0,0 20,4H5.21L4.27,2M7,18C5.89,18 5,18.89 5,20A2,2 0 0,0 7,22A2,2 0 0,0 9,20C9,18.89 8.1,18 7,18Z" />
          </svg>
        </h3>
        <h3 class="my-3">Details</h3>
        <ul>
          <li>{{ currentProduct.description }}</li>
          <li>Harga : Rp. {{ currentProduct.price }}</li>
          <li>Biaya Ongkir : Standar(Rp. 19.000)</li>
        </ul>
        <!-- <button @click="saveProduct" type="button" class="btn btn-outline-primary btn-lg btn-block btn-custom-color">
          Bayar sekarang  
        </button> -->
      </div>
    </div>

    <div>
      <div>
        <p>Pilih Bank Tujuan</p>
      </div>
      <div>
        <div class="input-group input-group-lg mb-3">
          <label class="input-group-text" for="inputGroupSelect01">Transfer Bank</label>
          <select class="form-select" id="inputGroupSelect01">
            <option selected>Choose...</option>
            <option value="1">BCA (03298052)</option>
            <option value="2">BNI (39092735)</option>
            <option value="3">OVO (02841298410)</option>
          </select>
        </div>
        <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
          <option selected>Pilih Ekspedisi</option>
          <option value="1">JNE Reguler</option>
          <option value="2">J&T</option>
          <option value="3">Pos Indonesia</option>
        </select>
      </div>
      <!--JUMLAH BERAT SAMA ONGKIR OTOMATIS-->
      <div class="input-group input-group-lg mb-3">
        <span class="input-group-text">Mau beli berapa?</span>
        <input type="number" class="form-control" v-model="num2" aria-label="Ongkir">
        <!-- <select v-model="operand">
          <option value="+"> + </option>
          <option value="-"> - </option>
          <option value="*"> * </option>
          <option value="/"> / </option>
        </select> -->
        <!-- <input placeholder="num2" type="number" v-model.number="num2"> -->
        <!-- <h2> {{result}} </h2> -->
      </div>
      <div class="input-group mb-5">
        <span class="input-group-text">Alamat</span>
        <textarea class="form-control" aria-label="With textarea"></textarea>
      </div>
      <div class="but">
        <button id="save" type="submit" v-bind:class="{ 'btn btn-success btn-lg btn-block btn-custom-color': clicked, 'btn btn-outline-primary btn-lg btn-block btn-custom-color': !clicked }"
          class="btn my-2" v-on:click="added">
          {{ clicked? "Pembayaran berhasil! invoice beserta resi sudah kami kirim ke email kamu": "Rp. "+ result  }}
        </button>

        <!-- <button @click="msgSucces" type="button" class="btn btn-outline-primary btn-lg btn-block btn-custom-color">
          Rp. {{ result }}
        </button> -->
      </div>
    </div>
    <!-- <form>

      <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title" v-model="currentProduct.title" />
      </div>
      <div class="form-group">
        <label for="description">Description</label>
        <input type="text" class="form-control" id="description" v-model="currentProduct.description" />
      </div>
      <div class="form-group">
        <label for="image">Image Name</label>
        <input type="text" class="form-control" id="image" v-model="currentProduct.image" />
      </div>

      <div class="form-group">
        <label><strong>Status:</strong></label>
        {{ currentProduct.published ? "Published" : "Pending" }}
      </div>

      <div id="intro" style="text-align:center;">
        <input type="text" v-model="selectedDate" class="dateclass" :placeholder="new Date().toLocaleDateString()">
        <input type="text" v-model="selectedDate" class="dateclass" :placeholder="formatDate(process_photo.created_at)">
      </div>

      <div id="app">
        <p>{{ formatDate(process_photo.created_at) }}</p>
      </div>

    </form> -->

    <!-- <button @click="saveProduct" class="btn btn-success">Add To Cart</button> -->

    <!-- <button class="badge badge-primary mr-2" v-if="currentProduct.published" @click="updatePublished(false)">
      UnPublish
    </button>
    <button v-else class="badge badge-primary mr-2" @click="updatePublished(true)">
      Publish
    </button>

    <button class="badge badge-danger mr-2" @click="deleteProduct">
      Delete
    </button>

    <button type="submit" class="badge badge-success" @click="updateProduct">
      Update
    </button>
    <p>{{ message }}</p> -->
  </div>

  <div v-else>
    <!-- <br />
    <p>Please click on a Product...</p> -->
  </div>
</template>

<script>
import ProductDataService from "../services/ProductDataService";
import CartDataService from "../services/CartDataService";
import moment from "moment";

export default {
  name: "product",
  el: '#vue_mult',
  data() {
    return {
      currentProduct: null,
      message: '',
      num1: 19000,
      num2: 0,
      clicked: false,
    };
  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
    result() {
      return this.currentProduct.price * this.num2 + this.num1;
      // switch (this.operand) {
      //   case "+":
      //   case "-":
      //     return this.num1 - this.num2
      //   case "*":
      //     return this.num1 * this.num2
      //   case "/":
      //     return this.num1 / this.num2
    }

  },
  methods: {
    added() {
      this.clicked = true;
    },
    msgSucces() {
      this.message = "berhasil dibayar!";
    },
    formatDate(date) {
      return moment(date).format("YYYY-MM-DD")
    },
    getProduct(id) {
      ProductDataService.get(id)
        .then(response => {
          this.currentProduct = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    sum: function (nums) {
      let result = 0;
      nums.forEach(function (n) { result += n * 1 });
      return result
    },
    saveProduct() {
      var data = {
        id_order: this.currentProduct.id,
        user: { id: this.currentUser.id },
        buy_date: this.formatDate(new Date()),
      };

      // var dataCart = {
      //   id_product: this.currentProduct.id,
      //   // id_order: this.
      // }

      CartDataService.create(data)
        .then(response => {
          this.Product.id = response.data.id;
          console.log(response.data);
          this.submitted = true;
        })
        .catch(e => {
          console.log(e);
        });
      // CartDataService.addToCart(dataCart)
    },

    updatePublished(status) {
      var data = {
        id: this.currentProduct.id,
        title: this.currentProduct.title,
        description: this.currentProduct.description,
        image: this.currentProduct.image,
        published: status
      };

      ProductDataService.update(this.currentProduct.id, data)
        .then(response => {
          console.log(response.data);
          this.currentProduct.published = status;
          this.message = 'The status was updated successfully!';
        })
        .catch(e => {
          console.log(e);
        });
    },

    updateProduct() {
      ProductDataService.update(this.currentProduct.id, this.currentProduct)
        .then(response => {
          console.log(response.data);
          this.message = 'The product was updated successfully!';
        })
        .catch(e => {
          console.log(e);
        });
    },

    deleteProduct() {
      ProductDataService.delete(this.currentProduct.id)
        .then(response => {
          console.log(response.data);
          this.$router.push({ name: "products" });
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.message = '';
    this.getProduct(this.$route.params.id);
  }
};
</script>

<style>
.edit-form {
  max-width: 50%;
  margin: auto;
}

.container-space {
  margin-top: 2rem;
}

.product-thumbnails {
  display: flex;
  margin-top: 2rem;
}

.product-thumbnails>ul {
  display: flex;
  list-style: none;
  padding-left: 0;
}

.product-thumbnails>li {
  margin-right: 10px;
}

.product-thumbnails>ul>li>img {
  width: 100px;
  cursor: pointer;
}

.thumbnail-active {
  border: 2px solid #000;
}

.nav-link>img {
  width: 40px;
  border-radius: 8px;
  margin-right: 10px;
}

.btn-custom-color {
  border: 2px solid #4fc08d;
  color: #4fc08d;
}

.btn-custom-color:hover {
  border: 2px solid #4fc08d;
  background-color: #4fc08d;
  color: #ffffff;
}
</style>
