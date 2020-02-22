<template>
    <div class="list row">
        <div class="col-md-5">
            <h4>Dentist Visit list</h4>
            <input type="text" v-model="search" placeholder="search appointment">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th scope="col" >Dentist Name</th>
                  <th scope="col">Visit Time</th>
                  <th scope="col">Edit</th>
                </tr>
              </thead>
              <tbody v-for="(dentist, index) in filteredDentists" :key="index">
                <td>{{dentist.dentistName}}</td>
                <td> {{dentist.visitTime}}</td>
                <td>   <router-link :to="{
                            name: 'dentist-details',
                            params: {dentist: dentist, id: dentist.id }
                        }">Edit
                        </router-link> </td>

              </tbody>


            </table>

        </div>
        <div class="col-md-6">
            <router-view @refreshData="refreshList"></router-view>
        </div>
    </div>
</template>


<script>
import http from "../http-common";

export default {
  name: "dentistvisit-list",
  data() {

    return {
      dentists: [],
      search: '',
    };
  },
  methods: {

    retrieveDentistVisitList() {
      http
        .get("/appointments")
        .then(response => {
          this.dentists = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.retrieveDentistVisitList();
    },

  },

  mounted() {
    this.retrieveDentistVisitList();
  },
  computed: {
    filteredDentists: function(){
      return this.dentists.filter((dentist) =>{
        return dentist.dentistName.match(this.search);
      })
    }
  },
};
</script>