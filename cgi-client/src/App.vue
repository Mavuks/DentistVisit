<template>
  <div id="app">
      <div id="nav">
      <router-link to="/">Esileht</router-link> |
      <router-link to="/Add">Registeerimine</router-link> |
      <router-link to="/appointments">Registreeringud</router-link>
    </div>
    <router-view/>
  </div>


</template>
<script>

export default {
  name: 'app',

}
</script>

<style>

@import "https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css";
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
