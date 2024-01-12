<template>
   <div id="app">
    <nav>
      <router-link to="/cadastro"></router-link>
    </nav>
    <div class="content">
      <router-view/>
    </div>
  </div>
</template>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-image: url('@/assets/img/white.png');
  background-size: cover;
  background-position: center;
  height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}

.content {
  background-image: url('@/assets/img/solinftec.png');
  background-size: contain; /* Ajusta o tamanho da imagem central */
  background-repeat: no-repeat;
  width: 300px; /* Ajuste a largura conforme necessário */
  height: 400px; /* Ajuste a altura conforme necessário */
  display: flex;
  align-items: center;
  justify-content: center; 
}
</style>
