import { createRouter, createWebHistory } from 'vue-router'
import HomeView from "../views/HomeView.vue";
import cardCatalog from "../views/cardCatalog.vue";
import cardCreator from "../views/cardCreator.vue";
import chaseTheState from "../views/chaseTheState.vue";
import checkpointConstruction from "../views/checkpointConstruction.vue";
import objectiveGo from "../views/objectiveGo.vue";
import practiceCatalog from "../views/practiceCatalog.vue";
import practiceCreator from "../views/practiceCreator.vue";
import progressPoker from "../views/progressPoker.vue";
import AboutView from '../views/AboutView.vue';




const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/about",
    name: "about",
    component: AboutView,
  },
  {
    path: "/cardCatalog",
    name: "cardCatalog",
    component: cardCatalog,
  },
  {
    path: "/cardCreator",
    name: "cardCreator",
    component: cardCreator,
  },
  {
    path: "/chaseTheState",
    name: "chaseTheState",
    component: chaseTheState,
  },
  {
    path: "/checkpointConstruction",
    name: "checkpointConstruction",
    component: checkpointConstruction,
  },
  {
    path: "/objectiveGo",
    name: "objectiveGo",
    component: objectiveGo,
  },
  {
    path: "/practiceCatalog",
    name: "practiceCatalog",
    component: practiceCatalog,
  },
  {
    path: "/practiceCreator",
    name: "practiceCreator",
    component: practiceCreator,
  },
  {
    path: "/progressPoker",
    name: "progressPoker",
    component: progressPoker,
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
