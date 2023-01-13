
<template>
  <div id="app mw-100">
    <nav class="navbar navbar-expand navbar-light bg-light">
      <a href="/" class="navbar-brand text-danger mr-auto">
        <img class="logo ml-2 mr-3" :src="require('./assets/loogo.png')" />
        Autoparts
      </a>
      <div v-if="!currentUser" class="navbar-nav">
        <li class="nav-item">
          <router-link to="/home" class="nav-link">Home</router-link>
        </li>
        <li class="nav-item">
          <!-- <router-link v-if="currentUser" to="/user" class="nav-link">User</router-link> -->
        </li>
        <!-- <li class="nav-item">
          <router-link to="/products" class="nav-link">Products</router-link>
        </li> -->
        <!-- <li class="nav-item">
          <router-link to="/checkout" class="nav-link">Cart</router-link>
        </li> -->
      </div>

      <div v-if="currentUser" class="navbar-nav">
        <li class="nav-item">
          <router-link to="/home" class="nav-link">Home</router-link>
        </li>
        <li class="nav-item">
          <!-- <router-link v-if="currentUser" to="/user" class="nav-link">User</router-link> -->
        </li>
        <li class="nav-item">
          <router-link to="/products" class="nav-link">Products</router-link>
        </li>
        <!-- <li class="nav-item">
          <router-link to="/checkout" class="nav-link">Cart</router-link>
        </li> -->
      </div>

      <div v-if="!currentUser" class="navbar-nav ml-auto">
        <li class="nav-item">
          <router-link to="/register" class="nav-link">
            <font-awesome-icon icon="user-plus" /> Sign Up
          </router-link>
        </li>
        <li class="nav-item">
          <router-link to="/login" class="nav-link">
            <font-awesome-icon icon="sign-in-alt" /> Login
          </router-link>
        </li>
      </div>

      <div v-if="currentUser" class="navbar-nav ml-auto">
        <!-- <li class="nav-item">
          <router-link to="/add" class="nav-link">Add</router-link>
        </li> -->
        <li class="nav-item">
          <router-link to="/profile" class="nav-link">
            <font-awesome-icon icon="user" />
            {{ currentUser.username }}
          </router-link>
        </li>
        <li class="nav-item">
          <a class="nav-link" @click.prevent="logOut">
            <font-awesome-icon icon="sign-out-alt" /> LogOut
          </a>
        </li>
      </div>
    </nav>

    <div class="bg-light content">
      <div class="wrap">
        <router-view />
      </div>
    </div>

    <div id="footer">
      <div class="hr"></div>
      <p>
        <span>
          <img class="logo ml-2 mr-3" :src="require('./assets/loogo.png')" />
          <strong>Autoparts</strong>.
          <br>
          AutoParts Adalah Toko Online Shop Terpercaya Yang Menjual Berbagai Sparepart Motor!
        </span>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
  },
  methods: {
    logOut() {
      this.$store.dispatch('auth/logout');
      this.$router.push('/login');
    }
  }
};
</script>

<style>
#app {
  min-height: 100%;
  position: relative;
}

.content {
  flex: 1 0 auto;
  padding-bottom: 8%;
}

.logo {
  height: 30px;
  width: 30px;
}

.wrap {
  width: 85% !important;
  margin-left: auto;
  margin-right: auto;
  flex: 1 0 auto;
}

#footer span strong {
  font-family: 'Poppins', sans-serif;
  color: var(--red);
}

#footer {
  padding: 1rem 1rem 0 3rem;
  position: fixed;
  top: 100%;
  width: 100%;
  transform: translate(0%, -100%);
  background-color: #999;
}
</style>
