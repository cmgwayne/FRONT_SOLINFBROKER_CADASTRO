<template>
  <div class="form-cadastro">
    <h2>Cadastro</h2>

    <form @submit.prevent="Cadastro">
      <div class="form-group">
        <input type="text" placeholder="Nome">
      </div>
      <div class="form-group">
        <input type="text" v-model="user.email" placeholder="Email">
      </div>
      <div class="form-group">
        <input type="password" v-model="user.password" placeholder="Senha">
      </div>
      <div class="form-group">
        <input type="text" v-model="cpfCnpj" placeholder="Cpf/Cnpj">
      </div>
      
      <!-- Razão Social e Nome Fantasia aparece apenas se o Cpf/Cnpj tiver mais de 11 caracteres -->
      <div v-if="cpfCnpj.length > 11" class="form-group">
        <div class="form-group">
          <input type="text" placeholder="Razão Social">
        </div>
      </div>

      <div v-if="cpfCnpj.length > 11" class="form-group">
        <input type="text" placeholder="Nome fantasia">
      </div>
      
      <button type="submit">Cadastrar</button>
    </form>
  </div>
</template>

<script setup>
import http from '@/services/http.js';
import { reactive, ref } from 'vue';

const user = reactive({
  email: '',
  password: ''
});

const cpfCnpj = ref('');

async function Cadastro() {
  try {
    const { data } = await http.post('/auth', { email: user.email, password: user.password, cpfCnpj });
    console.log(data);
  } catch (error) {
    console.log(error?.response?.data);
  }
}
</script>

<style lang="scss">
.form-container {
  text-align: center;
  margin-top: 50px; /* Ajuste conforme necessário para o espaçamento desejado */
}

h2 {
  margin-bottom: 20px; /* Espaço abaixo do título "Cadastro" */
}

.form-group {
  margin-bottom: 15px; /* Espaço entre os campos de entrada */
}

</style>
