import axios from 'axios'
import type { Usuario } from '../types/Usuario'

export async function buscarUsuarios(): Promise<Usuario[]> {
    const resposta  = await axios.get<Usuario[]>('http://localhost:8080/usuario')

    return resposta.data
}