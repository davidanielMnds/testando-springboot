<script setup lang="ts">

import { ref } from 'vue'
import type { Usuario } from './types/Usuario'
import { buscarUsuarios } from './service/UsuarioService'

const usuarios = ref<Usuario[]>([])
async function carregarUsuarios() {
  usuarios.value = await buscarUsuarios()
}

</script>

<template>
  <main>
    <h1>Minha API</h1>
    <button @click="carregarUsuarios">
      Carregar usuarios
    </button>

    <div v-for="usuario in usuarios" :key="usuario.id">
      <p>Nome: {{ usuario.nome }}</p>
      <p>Email: {{ usuario.email }}</p>
      
    </div>

  </main>
</template>

<style scoped>
  main{
    max-width: 800px;
    margin: 0 auto;
    padding: 40px;
  }

  button{
    padding: 10px 20px;
    cursor:pointer;
  }
</style>
