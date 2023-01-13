import { createWebHistory, createRouter } from "vue-router";
import Home from "./components/Home.vue";
import Login from "./components/Login.vue";
import Register from "./components/Register.vue";
// lazy-loaded
const Profile = () => import("./components/Profile.vue")
// const BoardUser = () => import("./components/BoardUser.vue")
const Products = () => import("./components/ProductsList")
const ProductDetails = () => import("./components/Product")
const Add = () => import("./components/AddProduct")
const Checkout = () => import("./components/Checkout")

const routes = [
  {
    path: "/",
    name: "home",
    component: Home,
  },
  {
    path: "/home",
    component: Home,
  },
  {
    path: "/login",
    component: Login,
  },
  {
    path: "/register",
    component: Register,
  },
  {
    path: "/profile",
    name: "profile",
    component: Profile,
  },
  // {
  //   path: "/user",
  //   name: "user",
  //   component: BoardUser,
  // },
  {
    path: "/checkout",
    name: "checkout",
    component: Checkout,
  },
  {
    path: "/",
    alias: "/products",
    name: "products",
    component: Products,
  },
  {
    path: "/products/:id",
    name: "product-details",
    component: ProductDetails,
  },
  {
    path: "/add",
    name: "add",
    component: Add,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

// router.beforeEach((to, from, next) => {
//   const publicPages = ['/login', '/register', '/home'];
//   const authRequired = !publicPages.includes(to.path);
//   const loggedIn = localStorage.getItem('user');

//   // trying to access a restricted page + not logged in
//   // redirect to login page
//   if (authRequired && !loggedIn) {
//     next('/login');
//   } else {
//     next();
//   }
// });

export default router;