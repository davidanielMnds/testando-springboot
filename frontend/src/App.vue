<script setup lang="ts">

import { ref } from 'vue'
import type { Usuario } from './types/Usuario'
import { buscarUsuarios } from './service/UsuarioService'
import UsuarioLista from './components/UsuarioLista.vue'
import UsuarioControler from './components/UsuarioControler.vue';

</script>

<template>

  <nav>
     <h1>Titulo</h1>
  </nav>

  <div class="layout">

      <aside>

          <UsuarioLista/>

      </aside>

      <main>
        
        <UsuarioControler/>

      </main>

  </div>
    
</template>

<style scoped>

  nav{
    background-color: var(--cor-terciaria);
    display:flex;
    justify-content: center;
    align-items: center;
    h1{
      color:var(--cor-quarta);

    }
  }
    .layout{
      flex:1;
      display:flex;
      align-items: center;
      flex-direction: row;
      margin-left: 4vw;
      margin-right: 4vw;
      padding-left:2vw;
      padding-right: 2vw;
      gap:2vw;
    }

    main{
      flex:1;
      background-color: black;
    }


</style>
