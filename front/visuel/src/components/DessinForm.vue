<template>
  <!-- <button v-on:click="lien()">voir dessin</button> -->
  <!-- <div v-for="forme in Form" :key="forme"> -->
  <!-- <svg>
  <rect
                
                  style="background-color: black"
                  :x="500"
                  :y="500"
                  :width="forme.cote"
                  :height="forme.cote"
                ></rect>
</svg> -->
<!-- </div> -->
<div class="fond" >
<svg viewBox="20 20 1000 1000"> 
  <g v-for="forme in Form" v-bind:key="forme" >
    <g v-if="forme && forme.profondeur != 0 && forme.profondeur != undefined" >
  <rect
  
                  style="background-color: black"
                  :x="400"
                  :y="300"
                  :width="forme.cote * 10"
                  :height="forme.cote * 10"
                ></rect>
  </g>
  <g v-if="forme.longueur != 0 && forme.longueur != undefined">
  <rect
                
                  style="background-color: black"
                  :x="400"
                  :y="300"
                  :width="forme.largeur * 10"
                  :height="forme.longueur * 10"
                ></rect>
  </g>
  <g v-if="forme.rayon != 0 && forme.rayon != undefined">
  <circle
                
                  style="background-color: black"
                 
                  :r="forme.rayon * 10"
                  :cx="500"
                  :cy="400"


                ></circle>
  </g>
  <g v-if="forme.base != 0 && forme.base != undefined">
  <polygon
                
                  style="background-color: black"
                  points="0,0 100,0 50,-150"
                  :transform="
                    'translate(' +
                    500 +
                    ',' +
                    500 +
                    ') rotate(0 0 0) scale( ' +
                    forme.base*10 / 100 +
                    ' )'
                  "



                ></polygon>
  </g>
  </g>
</svg>
  
</div>
    </template>
    
    <script>
      import axios from "axios";

    export default {
      name: 'DessinForm',
      data() {
    return {
      Form: null,
      
    }
  },
    
    methods: {
      getForm() {
      axios.get("http://localhost:9090/formes/" + this.$route.params.id).then((reponse) => {
        this.Form = reponse.data; 
        console.log(this.Form); 
        console.log(this.Form.cote);     
        return this.Form = {data :reponse.data}
    
     })
    },

  },
  mounted: function () {
    this.getForm();
  },

    }
    </script>
    <style scoped>
    .fond{
      background-color: gray;
      height: 900px; 
      width: 80%;
      margin-left: 10%;
      margin-top: 1%;
    }
    </style>