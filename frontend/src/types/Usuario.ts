export interface Usuario {
    id: number
    nome: string
    email: string
}

export type NovoUsuario = Omit<Usuario, 'id'>