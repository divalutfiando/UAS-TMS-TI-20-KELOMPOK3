<template>
  <div class="container">
    <header class="jumbotron mt-5">
      <h3>
        Hi, <strong>{{currentUser.username}}</strong>
      </h3>
    </header>
    <p>
      <strong>Current Token:</strong>
      {{currentUser.accessToken.substring(0)}}
    </p>
    <!-- <p>
      <strong>User Id:</strong>
      {{currentUser.id}}
    </p> -->
    <p>
      <strong>Email:</strong>
      {{currentUser.email}}
    </p>
    <!-- <strong>Authorities:</strong>
    <ul>
      <li v-for="role in currentUser.roles" :key="role">{{role}}</li>
    </ul> -->
  </div>
</template>

<script>
export default {
  name: 'Profile',
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    }
  },
  mounted() {
    if (!this.currentUser) {
      this.$router.push('/login');
    }
  }
};
</script>