<template>
  <div v-if="this.dentist">
    <h4>Hambaarsti visiidi muutmine</h4>
    <div  v-if="Errors.length">
            <p v-for="(error, index) in Errors" v-bind:key="index"> {{error}}</p>
        </div>
     <table class="table table-striped">
              <thead>
                <tr>
                   <th scope="col" >Hambaarsti nimi</th>
                  <th scope="col">Visiidi aeg</th>
                  <th scope="col">Muuda</th>
                  <th scope="col">Kustuta</th>
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
                <td>  <span class="button is-small btn-success"  v-on:click="updateActive()">Muuda </span></td>
                <td>  <span class="button is-small btn-danger"  v-on:click="deleteDentist(dentist.id)">Kustuta </span></td>
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
      Errors:[],
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

         if(response.data === 'BAD_REQUEST'){
            this.Errors.push("Valitud Aeg on juba valitud. Valige muu aeg!");
            console.log(this.Errors);
          }else{
            this.$router.push('/appointments');
          }
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