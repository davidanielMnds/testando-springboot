import axios from 'axios'
import type { NovoUsuario, Usuario } from '../types/Usuario'

const URL = 'http://localhost:8080/usuario'
export async function buscarUsuarios(): Promise<Usuario[]> {
    const resposta  = await axios.get<Usuario[]>(URL)

    return resposta.data
}

export async function deleteUsuario(id:number) {
    const resposta = await axios.delete(`${URL}/${id}`)
    return resposta.data
}

export async function postUsuario(nome:string, email:string) {
    const usuario: NovoUsuario = {nome, email}
    const resposta = await axios.post<Usuario>(URL, usuario)
    return resposta.data

}