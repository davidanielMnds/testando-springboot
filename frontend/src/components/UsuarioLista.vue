<script setup lang="ts">
    import { ref } from 'vue'
    import type { Usuario } from '../types/Usuario'
    import { buscarUsuarios } from '@/service/UsuarioService';
    const usuarios = ref<Usuario[]>([])
    
    async function carregarUsuarios() {
        usuarios.value = await buscarUsuarios()
    }
</script>

<template>
    <div id="root">

        <h2>Lista de Usuarios</h2>

        <button @click="carregarUsuarios" class="botao_buscar">Buscar Usuarios</button>
        <div id="lista">
            <div v-for="usuario in usuarios" :key="usuario.id" class="item_usuario">

                <div class="Caixa_usuario">
                    <div class="informacoes_usuario">
                        <p><b>Nome:</b> {{ usuario.nome }}</p>
                        <p><b>Email:</b> {{ usuario.email }}</p>
                    </div>
                    <div class="botoes_usuario">
                        <button class="botao_usuario">excluir</button>
                        <button class="botao_usuario">pegar id</button>
                    </div>
                </div>
                
            </div>
        </div>
            
    </div>
</template>

<style scoped>
    #root{
        display:flex;
        flex-direction: column;
        align-items: center;
        width: 16vw;
        height: 75vh;
        box-sizing: border-box;
        border: 3px solid var(--cor-quarta);
        border-radius: 40px;
        background-color:var(--cor-terciaria);
        gap:1rem;
        h2{
            color:var(--cor-quarta);
        }
        overflow: hidden;
    }

    .item_usuario{
        width:90%;
    }

    #lista{
        display:flex;
        flex:1;
        flex-direction: column;
        align-items: center;
        min-height: 0;
        gap: 1rem 0;
        width:100%;
        overflow-y: auto;
        scrollbar-width: thin;
        scrollbar-color: var(--cor-quarta) var(--cor-terciaria);
    }

    .Caixa_usuario{
        display:flex;
        flex-direction: column;
        
        gap:0.4em;
        width:100%;

        border-radius: 21px;
        background: #ffed00;
        box-shadow: inset 10px 10px 20px #c2b400,
        inset -10px -10px 20px #fff900;
    }

    .botoes_usuario{
        display:flex;
        flex-direction: row;
        justify-content: center;
        padding:0.1em 1em;
        gap:0.1em;
        
    }


    .botao_buscar {
    padding: 4px 10px;
    border: 2px solid #2c2c2c;
    background-color: #1a1a1a;
    color: #ffffff;
    font-size: 1rem;
    cursor: pointer;
    border-radius: 30px;
    transition: all 0.4s ease;
    outline: none;
    position: relative;
    overflow: hidden;
    font-weight: bold;
    }

    .botao_buscar::after {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: radial-gradient(
        circle,
        rgba(255, 255, 255, 0.25) 0%,
        rgba(255, 255, 255, 0) 70%
    );
    transform: scale(0);
    transition: transform 0.5s ease;
    }

    .botao_buscar:hover::after {
    transform: scale(4);
    }

    .botao_buscar:hover {
    border-color: #666666;
    background: #292929;
    }

    .botao_usuario {
    padding: 4px 10px;
    border: 2px solid #2c2c2c;
    background-color: #1a1a1a;
    color: #ffffff;
    font-size: 1rem;
    cursor: pointer;
    border-radius: 30px;
    transition: all 0.4s ease;
    outline: none;
    position: relative;
    overflow: hidden;
    font-weight: bold;
    }

    .botao_usuario::after {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: radial-gradient(
        circle,
        rgba(255, 255, 255, 0.25) 0%,
        rgba(255, 255, 255, 0) 70%
    );
    transform: scale(0);
    transition: transform 0.5s ease;
    }

    .botao_usuario:hover::after {
    transform: scale(4);
    }

    .botao_usuario:hover {
    border-color: #666666;
    background: #292929;
    }



</style>