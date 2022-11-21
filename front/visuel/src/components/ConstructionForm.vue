<template>
    <div class="fond">

        <svg @mouseup="mouseup" viewBox="20 20 1000 1000">
            <g v-for="koplo in Construction" v-bind:key="koplo" draggable="true">
                <g v-if="koplo.profondeur != 0 && koplo.profondeur != undefined" v-bind:draggable="true"
                    @mouseup="mouseup">
                    <rect @mousemove="mousemove" @drop="drop" @mouseup="mouseup" @mousedown="onmousedown($event)"
                        style="background-color: black" :x="4" :y="4" :width="koplo.cote * 10"
                        :height="koplo.cote * 10"></rect>
                </g>
                <g @mouseup="mouseup" @mousedown="onmousedown($event)" v-if="koplo.longueur != 0 && koplo.longueur != undefined">
                    <rect @mousemove="mousemove" @drop="drop" @mouseup="mouseup" @mousedown="onmousedown($event)"
                        style="background-color: black" :x="400" :y="300" :width="koplo.largeur * 10"
                        :height="koplo.longueur * 10"></rect>
                </g>
                <g v-if="koplo.rayon != 0 && koplo.rayon != undefined">
                    <circle @mousemove="mousemove" @drop="drop" @mouseup="mouseup" @mousedown="onmousedown($event)"
                        style="background-color: black" :r="koplo.rayon * 10" :cx="100" :cy="100"></circle>
                </g>
                <g @mouseup="mouseup" @mousedown="onmousedown($event)" v-if="koplo.base != 0 && koplo.base != undefined">
                    <polygon @mousemove="mousemove" @drop="drop" @mouseup="mouseup" @mousedown="onmousedown($event)"
                        style="background-color: black" points="0,0 100,0 50,-150" :transform="
                          'translate(' +
                          100 +
                          ',' +
                          500 +
                          ') rotate(0 0 0) scale( ' +
                          koplo.base*10 / 100 +
                          ' )'
                        "></polygon>
                </g>
            </g>
        </svg>


    </div>
</template>
      
<script>
import axios from "axios";

export default {
    name: 'ConstructionForm',
    data() {
        return {
            Construction: null,
            currentDraggableElement: null,
        }
    },

    methods: {
        getForm() {
            axios.get("http://localhost:9090/list/" + this.$route.params.id).then((reponse) => {
                this.Construction = reponse.data.formes;
                console.log(this.Construction);

                //this.Koplo = this.Construction.formes;      

            })


        },
        onDrop(event) {
            const dropzone = event.target;
            const droppedElementId = event.dataTransfer.getData("text");
            const droppedElement = document.getElementById(droppedElementId);

            dropzone.appendChild(droppedElement); //.cloneNode());

            droppedElement.setAttribute("draggable", true);

            const svgPoint = this.getSVGPoint(event, droppedElement);
            this.setPosition(droppedElement, { x: svgPoint.x, y: svgPoint.y });
        },

        mouseup() {
            this.currentDraggableElement = null;
            console.log("up");
            console.log(this.currentDraggableElement);
        },
        onmousedown(event) {
            this.currentDraggableElement = event.target
            console.log("down");
        },
        mousemove(event) {
            console.log(this.currentDraggableElement);
            if (this.currentDraggableElement) {
                const svg = this.getSVGPoint(event);
                event.target.setAttribute("x", svg.x);
                event.target.setAttribute("y", svg.y);
                event.target.setAttribute("cx", svg.x);
                event.target.setAttribute("cy", svg.y);
                event.target.setAttribute(
                "transform",
                "translate(" + svg.x + "," + svg.y + ") rotate(0 0 0)"
            );
            }
        },
        getSVGPoint(event) {
            const point = event.target.viewportElement.createSVGPoint();
            point.x = event.clientX;
            point.y = event.clientY;

            const CTM = event.target.viewportElement.getScreenCTM();
            const svgPoint = point.matrixTransform(CTM.inverse());
console.log(CTM);
            return svgPoint;
        },




        //   Draggable.create(".form", {
        //     bounds:"svg"
        //    })
    },
    mounted: function () {
        this.getForm();
    },

}
</script>
<style scoped>
.fond {
    background-color: gray;
    height: 900px;
    width: 80%;
    margin-left: 10%;
    margin-top: 1%;
}
</style>