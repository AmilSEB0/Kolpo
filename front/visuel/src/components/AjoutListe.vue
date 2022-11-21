<template>
  <div v-show="show" class="overlay">


    <div class="dialog">

      <form @submit.prevent="creerListe">
      <div class="dialog__content">
        <h2 class="dialog__title" v-text="title"></h2>
        <p class="dialog__description" v-text="description"></p>
        <input class="dialog__input" id="nom" v-model="ListData.nom" v-text="input">
      </div>

      <hr />

      <div class="dialog__footer">
        <button @click="cancel" class="dialog__cancel">Annuler</button>
        <button @click="confirm" class="dialog__confirm">Ajouter</button>
      </div>
    </form>
    </div>

  </div>
  
</template>

<script>
import axios from "axios";

export default {
    props: ['show', 'title', 'description','input', 'cancel', 'confirm'],
    data() {
      return {
        ListData :{
          nom: '',
        },
        FormList: null,
      }
    },
    methods : {
      creerListe(){
        axios.post("http://localhost:9090/list", this.ListData)
     
      },
      getAllList() {
      axios.get("http://localhost:9090/list").then((reponse) => {
        this.FormList = reponse.data
      })
    },
 
    }
}




</script>
    
<!-- <<script>
    export default {
      name: 'AjoutListe',
    }
</script> -->

<style scoped>
.dialog__content{
  background-color: #c0c0c0;
}
</style>
     