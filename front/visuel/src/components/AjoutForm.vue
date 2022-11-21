<template>
  <div v-show="show" class="overlay">


    <div class="dialog">
      <form @submit.prevent="creerForme" ref="anyName">

      <div class="dialog__content">
        <h2 class="dialog__title" v-text="title"></h2>
        <div class="constructeur">

          <!-- <button v-on:click="bouton(1)">Carré</button> -->
          <button v-on:click="carre = !carre && !rectangle && !triangle && !cercle">Carré</button>
          <!-- <button v-on:click="bouton(2)">Rectangle</button> -->
          <button v-on:click="rectangle = !carre && !rectangle && !triangle && !cercle">Rectangle</button>
          <!-- <button v-on:click="bouton(3)">Triangle</button> -->
          <button v-on:click="triangle = !carre && !rectangle && !triangle && !cercle">Triangle</button>
          <!-- <button v-on:click="bouton(4)">Cercle</button> -->
          <button v-on:click="cercle = !carre && !rectangle && !triangle && !cercle">Cercle</button>


          </div>
          <div v-if="carre">
            <label for="fname">Côté:</label>
            <input type="number" class="dialog__input" v-text="input" v-model="cote">cm
          </div>

          <div v-if="rectangle">
            <label for="fname">Longueur:</label>
            <input type="number" class="dialog__input" v-text="input" v-model="longueur">cm
            <div class="espace"></div>
            <label for="fname">Largeur:</label>
            <input type="number" class="dialog__input" v-text="input" v-model="largeur">cm
          </div>
          <div v-if="triangle">
            <label for="fname">Côté:</label>
            <input type="number" class="dialog__input" v-text="input" v-model="cote">cm
            <div class="espace"></div>
            <label for="fname">Base:</label>
            <input type="number" class="dialog__input" v-text="input" v-model="base">cm
          </div>

          <div v-if="cercle">
            <label for="fname">Rayon:</label>
            <input type="number" class="dialog__input" v-text="input" v-model="rayon">cm
          </div>
      
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
  props: ['show', 'title','input', 'cancel','confirm'],
  data: () => {
  return{
       carre : false,
       rectangle: false,
       triangle : false,
       cercle: false,   
        liste: "",
        longueur: "",
        largeur: "",
        cote: "",
        base: "",
        rayon: "",
  }
},
methods : {
  creerForme(){
     this.$refs.anyName.reset()

    axios.post("http://localhost:9090/formes",{
        liste: this.$route.params.id,
        longueur: this.longueur,
        largeur: this.largeur,
        cote: this.cote,
        base: this.base,
        rayon: this.rayon
      })
     // console.log(this.carre);
      //this.carre = false
      // this.rectangle = false
      // this.triangle = false
      // this.cercle = false
      },
 
  },
}
</script>


<style scoped>
.dialog__content{
  background-color: #c0c0c0;
}
.constructeur button {
  /* width: 15%; */
  border: solid black 2px;
  background-color: rgb(115, 161, 230);
  /* margin-left: 10%; */
  margin-right: 8%;
  margin-top: 1%;
  margin-bottom: 2%;
}
.espace{
  margin-top: 10%;
}
</style>
     