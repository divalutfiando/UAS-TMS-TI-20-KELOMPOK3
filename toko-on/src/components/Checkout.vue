<template>
  <div class="container border border-secondary mt-3 mb-3 p-2">
    <section class="">
      <div class="text-center">
        <p>DETAIL PEMESANAN</p>
      </div>
      <div class="small-container cart-page">

        <table class="table">
          <tr class="bg-danger text-white">
            <th>Product</th>
            <th class="qty">Quantity</th>
            <th>Subtotal (Rp.)</th>
          </tr>
          <tr>
            <!--isi FORM PRODUCT-->
            <td>
              <div class="cart-info">
                <!-- <img src="./Media/Image/Product/reflektor.png" width="35%"> -->
                <div>
                  <p>Headlamp</p>
                  <small>Price: 150.000</small>
                  <br>
                  <a href="">Remove</a>
                </div>
              </div>
            </td>
            <td><input type="number" value="1"></td>
            <td class="total">100.000</td>
            <!--END FORM PRODUCT-->
          </tr>
        </table>

        <div class="total-price row">
          <div class="info col-7">
            <td>
              Perhatikan kembali product yang anda pesan <br>sebelum ke langkah selanjutnya!
            </td>
          </div>
          <table class="col-5">
            <tr>
              <td>TOTAL</td>
              <td>Rp. 500.000</td>
            </tr>
          </table>
        </div>
      </div>

      <!--form data data pembelian-->
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
          <span class="input-group-text">Ongkir</span>
          <input type="text" class="form-control" value="Rp. 11.0000,00-" aria-label="Ongkir">
        </div>
        <div class="input-group mb-5">
          <span class="input-group-text">Alamat</span>
          <textarea class="form-control" aria-label="With textarea"></textarea>
        </div>
        <div class="but">
          <button class="btn btn-primary btn-lg btutton" type="submit">Checkout</button>
        </div>
      </div>
    </section>
  </div>
</template>