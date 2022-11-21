import { createApp } from 'vue'
import Form from "./components/Form.vue"
import App from './App.vue'
import * as VueRouter from "vue-router"
import ListForm from "./components/ListForm.vue"
import DessinForm from "./components/DessinForm.vue"
import ConstructionForm from "./components/ConstructionForm.vue"


const router = VueRouter.createRouter({
    history: VueRouter.createWebHistory(),
    routes: [
      {
        path: '/',
        name: 'ListForm',
        component: ListForm
      },
      {
        path: '/formes/:id',
        name: 'FormVue',
        component: Form
      },
      {
        path: '/dessin/:id',
        name: 'DessinForm',
        component: DessinForm
      },
      {
        path: '/koplo/:id',
        name: 'ConstructionForm',
        component: ConstructionForm
      },

    ]
  })

createApp(App).use(router).mount('#app')
