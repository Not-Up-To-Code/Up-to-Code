<template>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>
    <router-link to="/cardCatalog">Card Catalog</router-link>
    <router-link to="/cardCreator">Card Creator</router-link>
    <router-link to="/chaseTheState">Chase The State</router-link>
    <router-link to="/checkpointConstruction">Checkpoint Construction</router-link>
    <router-link to="/objectiveGo">Objective Go</router-link>
    <router-link to="/practiceCatalog">Practice Catalog</router-link>
    <router-link to="/practiceCreator">Practice Creator</router-link>
    <router-link to="/progressPoker">Progress Poker</router-link>
  </nav>
  <router-view />
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
