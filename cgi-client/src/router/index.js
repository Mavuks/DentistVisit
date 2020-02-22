import Vue from "vue";
import Router from 'vue-router'
import Home from '../views/Home.vue'
import AddDentistVisit from "../components/AddDentistVisit.vue"
import DentistVisitList from "../components/DentistVisitList.vue"
import DentistVisit from "../components/DentistVisit"

Vue.use(Router);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/appointments',
    name: 'apoointments',
    component: DentistVisitList,
    children: [
      {
        path: "/appointments/:id",
        name: "dentist-details",
        component: DentistVisit,
        props: true
      }
    ]
  },
  {
    path: '/add',
    name: 'add',
    component: AddDentistVisit
  },


]
const router = new Router({
  routes
})

export default router
