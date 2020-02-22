<template>
  <div v-if="this.dentist">
    <h4>Dentist Visit Details</h4>

     <table class="table table-striped">
              <thead>
                <tr>
                  <th scope="col" >Dentist Name</th>
                  <th scope="col">Visit Time</th>
                  <th scope="col">Edit </th>
                  <th scope="col">Delete</th>
                </tr>
              </thead>
              <tbody >
                <td><select v-model="dentist.dentistName">
             <option v-for="(name, index) in Names" v-bind:key="index"> {{name.dentistName}}</option>
          </select></td>
                <td>
                  <select v-model="dentist.visitTime" >
                  <option v-for="(time, index) in Times" v-bind:key="index"> {{time.visitTime}}</option>
                  </select>
                </td>
                <td>  <span class="button is-small btn-success"  v-on:click="updateActive()">Edit </span></td>
                <td>  <span class="button is-small btn-danger"  v-on:click="deleteDentist(dentist.id)">Delete </span></td>
              </tbody>
            </table>

  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "dentsit",
  props: ["dentist"],
  data(){
    return{
      Names:[],
      Times :[],
      Dentist:{
        dentistName: "",
        visitTime: null
      }
    }
  },
  methods: {
    updateActive() {
    var data = {
        id: this.dentist.id,
        dentistName: this.dentist.dentistName,
        visitTime: this.dentist.visitTime,

          };
      http
        .put("/appointments/" + this.dentist.id, data)
        .then(response => {

          console.log(response.data);
          this.$router.push('/appointments');
        })
        .catch(e => {
          console.log(e);
        });
    },
    deleteDentist() {
      http
        .delete("/appointments/" + this.dentist.id)
        .then(response => {
          console.log(response.data);
          this.$emit("refreshData");
          this.$router.push('/add');
        })
        .catch(e => {
          console.log(e);
        });
    },
    getDentists(){
         http
        .get("/dentists")
        .then(response => {
          this.Names = response.data;
          console.log(this.Names);
        })
        .catch(e => {
          console.log(e);
        });
      },
      getVisittimes(){
         http
        .get("/visittimes")
        .then(response => {
          this.Times = response.data;
          console.log(this.Times);
        })
        .catch(e => {
          console.log(e);
        });
      }

  },
  mounted() {
    this.getDentists();
    this.getVisittimes();
  },
};
</script>