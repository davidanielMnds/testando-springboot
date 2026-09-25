<script setup lang="ts">
    import { ref } from "vue"
    import {postUsuario} from '../service/UsuarioService'

    const nome = ref('')
    const email = ref('')
    const id = ref()

    async function criar() {
        const resposta = await postUsuario(nome.value, email.value)
    }

    async function atualizar() {
        
    }

</script>

<template>

    <div class="root">

        <nav>
            <h2>Menu</h2>
        </nav>

        <div class="menu">
            
            <form @submit.prevent>

                <div class="campos">

                    <div class="valor_usuario">
                        <label>ID</label>
                        <input v-model="id" type="number" required/>
                    </div>

                    <div class="valor_usuario">
                        <label>Nome</label>
                        <input v-model="nome" type="text" required/>
                    </div>

                    <div class="valor_usuario">
                        <label>Email</label>
                        <input v-model="email" type="email" required/>
                    </div>

                </div>
                
                <div class="botoes">

                    <button @click="criar" class="botao">Criar usuario</button>
                    <button @click="atualizar" class="botao">Atualizar usuário</button>

                </div>

            </form>

        </div>
    </div>
</template>

<style scoped>
    .root{
        display:flex;
        flex-direction: column;
        height: 75vh;
        flex:1;
        box-sizing: border-box;
        border: 3px solid var(--cor-quarta);
        border-radius: 40px;
        background-color:var(--cor-terciaria);
        gap:1rem;
        padding:0 2rem;
    }

    nav{
        display: flex;
        justify-content: center;
        h2{
            color:var(--cor-quarta)
        }
    }

    .menu{
        display:flex;
        flex-direction: column;
    }
    
</style>