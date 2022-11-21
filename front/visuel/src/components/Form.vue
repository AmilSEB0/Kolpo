<template>
  <div class="body">
    <header>
  <h1>Formes</h1>
  </header>
  
    <div class="titre">
      <button @click="showDialog = true" class="btn"><img class="ajouter" src="../assets/ajouter.png"></button>
      <button v-on:click="Construction()">Faire un koplo avec les formes</button>
    </div>
    <button v-on:click="getAllList()">Construire la nouvelle forme</button>

    <div class="form" v-for="formes in Form" :key="formes">

<div v-if="formes.longueur != 0 && formes.longueur != undefined">
  <button v-on:click="Suppression(formes.id)"><img class="delete" src="../assets/delete.png"></button>
  <p><u>Forme :</u> Réctangle </p> 
  <p><u>Longueur :</u> {{ formes.longueur }} cm</p>
  <p><u>Largeur :</u> {{ formes.largeur }} cm</p>
  <p><u>Périmetre :</u> {{ formes.perimetre }} cm</p>
  <p><u>Air :</u> {{ formes.air }} cm²</p>
  <button v-on:click="lien(formes.id)" class="forme"><p>Voir la forme</p></button>
</div>

<div v-if="formes.base != 0 && formes.base != undefined">
  <button v-on:click="Suppression(formes.id)"><img class="delete" src="../assets/delete.png"></button>
  <p><u>Forme :</u> Triangle </p> 
  <p><u>Base :</u> {{ formes.base }} cm</p>
  <p><u>Côté :</u> {{ formes.cote }} cm</p>
  <p><u>Périmetre :</u> {{ formes.perimetre }} cm</p>
  <p><u>Air :</u> {{ formes.air }} cm²</p>
  <button v-on:click="lien(formes.id)" class="forme"><p>Voir la forme</p></button>
</div>

<div v-if="formes.profondeur != 0 && formes.profondeur != undefined">
  <button v-on:click="Suppression(formes.id)"><img class="delete" src="../assets/delete.png"></button>
  <p><u>Forme :</u> Carré </p> 
  <p><u>Côté :</u> {{ formes.cote }} cm</p>
  <p><u>Périmetre :</u> {{ formes.perimetre }} cm</p>
  <p><u>Air :</u> {{ formes.air }} cm²</p>
  <button v-on:click="lien(formes.id)" class="forme"><p>Voir la forme</p></button>
</div>

<div v-if="formes.rayon != 0 && formes.rayon != undefined">
 <button v-on:click="Suppression(formes.id)"><img class="delete" src="../assets/delete.png"></button>
  <p><u>Forme :</u> Cercle </p> 
  <p><u>Rayon :</u> {{ formes.rayon }} cm</p>
  <p><u>Périmetre :</u> {{ formes.perimetre }} cm</p>
  <p><u>Air :</u> {{ formes.air }} cm²</p>
  <button v-on:click="lien(formes.id)" class="forme"><p>Voir la forme</p></button>
</div>
</div>
<AjoutForm :show="showDialog"
          :cancel="cancel"
          :confirm="confirm"
          title="Ajouter une nouvelle forme ?"/>
  </div>
  </template>
  
  <script>
  import AjoutForm from './AjoutForm';
  import axios from "axios";

  export default {
    name: 'FormVue',
    components: { AjoutForm },
  data() {
    return {
      showDialog: false,
      Form: null,
    }
  },

  methods: {
    lien: function(id){
      this.$router.push({
        name: "DessinForm",
        params: { id:  id},
      });  },
    cancel() {
      this.showDialog = false;
    },

    confirm() {
      this.showDialog = false;
    },
    
    getAllList() {
      axios.get("http://localhost:9090/list/" + this.$route.params.id).then((reponse) => {
        this.FormList = reponse.data
        this.Form = this.FormList.formes;        
     })
    },
    Suppression(id){
        axios.delete("http://localhost:9090/formes/" +id).then(() => {
          this.getAllList();
        })

    },
    Construction(){
      this.$router.push({
        name: "ConstructionForm",
        params: { id:  this.$route.params.id},

      });  },

  },  
  mounted: function () {
    this.getAllList();
  },
  }
  </script>
  <style scoped>
  .forme{
  background-color: blue;
  }
  .forme p {
  color: black;
  }
  .form {
      display: flex;
      justify-content: center;
      flex-wrap: wrap;
  }
  
  .form div {
      width:30%;
      border: solid black 2px;
      background-color: rgb(248, 246, 246);
      /* margin-left: 10%; */
      margin-right: 10%;
      margin-top: 1%;
      margin-bottom: 2%;
  }

  u{
    font-weight: bold;
  }
  p{
    font-size: 150%;
  }
  .body {
      background-color: #d5d6aa;
      height:1000vh;
  }
  html {
    background-color: #d5d6aa;
  }

  h1{
    text-decoration: underline;
    font-size: 500%;
  
  }
  </style>
  