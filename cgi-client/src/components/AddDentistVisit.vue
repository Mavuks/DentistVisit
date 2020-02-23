<template>
  <div class="submitform">
    <div>
        <div class="form-group">
        <div  v-if="Errors.length">
            <p v-for="(error, index) in Errors" v-bind:key="index"> {{error}}</p>
        </div>

          <label for="dentistName">Dentist name</label>
          <!-- <input type="text" class="form-control" id="dentistName"  name="dentistName"> -->
          <select v-model="Dentist.dentistName" >
            <option v-for="(name, index) in Names" v-bind:key="index"> {{name.dentistName}}</option>
          </select>
          <p v-if="!nameIsValid" class="error-message"> Palun valige Arst!</p>
        </div>

        <div class="form-group">
          <label for="time">Visit time</label>
          <!-- <input type="datetime" class="form-control" id="time"  value="DD.MM.YYYY HH:MM" required v-model="Dentist.visitTime" name="time"> -->
          <select v-model="Dentist.visitTime">
            <option v-for="(time, index) in Times" v-bind:key="index"> {{time.visitTime}}</option>

            </select>
            <p v-if="!timeIsValid" class="error-message"> Palun Valige Aeg!</p>
        </div>

        <button v-on:click="saveDentist" class="btn-succsses">Submit</button>
    </div>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "add-Visit",
  data() {
    return {
      Errors: [],
      Names: [],
      Times: [],
      Dentist: {
        dentistName: "",
        visitTime: null
      },

        };
  },

  computed: {
    nameIsValid(){
      return !!this.Dentist.dentistName

    },

    timeIsValid(){
      return !!this.Dentist.visitTime
    },

    formIsValid(){
      return this.nameIsValid && this.timeIsValid
    }

  },
  methods: {
    saveDentist() {
      var data = {
        dentistName: this.Dentist.dentistName,
        visitTime: this.Dentist.visitTime,
      };
      if(this.formIsValid){
        http
        .post("/", data)
        .then(response => {
          console.log(response.data);
          if(response.data === 'BAD_REQUEST'){
            this.$router.push('/add');
            this.Errors.push("Valitud Aeg on juba valitud. Valige muud aeg!");
            console.log(this.Errors);
          }else{
            this.$router.push('/appointments');
          }

        })
        .catch(e => {
          console.log(e);
        });
      }else{
        console.log("Worng")
      }


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