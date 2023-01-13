
<template>
  <Slider />
  <section class="service mt-3">
    <div class="box-cont">
      <div class="box">
        <i class="fas fa-shipping-fast"></i>
        <h3>Fast Delivery</h3>
        <p>Layanan pengiriman yang memberikan pengiriman lebih cepat dan lebih nyaman dalam rangka memenuhi permintaan
          pelanggan.</p>
      </div>
      <div class="box">
        <i class="fas fa-undo"></i>
        <h3>10 days replacements</h3>
        <p>Anda juga dapat mengembalikan produk dalam waktu 10 hari setelah pengiriman untuk pengembalian dana penuh.
        </p>
      </div>
      <div class="box">
        <i class="fas fa-headset"></i>
        <h3>1 x 24 Hours</h3>
        <p>Siap melayani anda setiap saat.</p>
      </div>
    </div>
  </section>

</template>

<script>
import UserService from "../services/user.service";
import Slider from './Slider.vue'

export default {
  name: "Home",
  data() {
    return {
      content: "",
    };
  },
  mounted() {
    UserService.getPublicContent().then(
      (response) => {
        this.content = response.data;
      },
      (error) => {
        this.content =
          (error.response &&
            error.response.data &&
            error.response.data.message) ||
          error.message ||
          error.toString();
      }
    );
  },
  components: {
    Slider
  },
};
</script>

<style>
.service .box-cont {
  display: flex;
  flex: wrap;
  gap: 1.5rem;
  background: white;
  border: .1rem solid #000;
  border-radius: .5rem;
  padding: 2rem;
}

.service .box-cont .box {
  text-align: center;
  flex: 1 1 30rem;
}

.service .box-cont .box i {
  font-size: 4rem;
  color: red;
}

.service .box-cont .box h3 {
  font-size: 1rem;
  color: #000;
}

.service .box-cont .box p {
  font-size: 1rem;
  color: #949494;
  padding: 1rem 0;
}
</style>