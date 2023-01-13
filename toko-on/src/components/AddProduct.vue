<template>
  <div class="submit-form">
    <div v-if="!submitted">
      <div class="form-group">
        <label for="title">Title</label>
        <input
          type="text"
          class="form-control"
          id="title"
          required
          v-model="Product.title"
          name="title"
        />
      </div>

      <div class="form-group">
        <label for="description">Description</label>
        <input
          class="form-control"
          id="description"
          required
          v-model="Product.description"
          name="description"
        />
      </div>

      <div class="form-group">
        <label for="description">Image name</label>
        <input
          class="form-control"
          id="image"
          required
          v-model="Product.image"
          name="image"
        />
      </div>

      <button @click="saveProduct" class="btn btn-success">Submit</button>
    </div>

    <div v-else>
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success" @click="newProduct">Add</button>
    </div>
  </div>
</template>

<script>
import ProductDataService from "../services/ProductDataService";

export default {
  name: "add-Product",
  data() {
    return {
      Product: {
        id: null,
        title: "",
        description: "",
        image: "",
        published: false
      },
      submitted: false
    };
  },
  methods: {
    saveProduct() {
      var data = {
        title: this.Product.title,
        description: this.Product.description,
        image: this.Product.image
      };

      ProductDataService.create(data)
        .then(response => {
          this.Product.id = response.data.id;
          console.log(response.data);
          this.submitted = true;
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    newProduct() {
      this.submitted = false;
      this.Product = {};
    }
  }
};
</script>

<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>
