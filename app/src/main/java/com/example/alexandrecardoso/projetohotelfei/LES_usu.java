package com.example.alexandrecardoso.projetohotelfei;

// Função LES adptada para funcionamento junta a Classe Usuário
public class LES_usu{
    public Usuario v[] = new Usuario[10]; // Vetor de Usuários
    public int n; // Número de Administradores existentes
    /* 0 - Construtor */
    public LES_usu(){
        this.n = 0;
    }
    /* 1 - Função de inserção */
    boolean insere(Usuario x){
        // Verifica o limite
        if (n == v.length){
            return false;
        }
        int i;
        /* Serve para manipular o i e encontrar o local de inserção */
        for(i=0;i < n && v[i].getUsernameASC() < x.getUsernameASC() ;i++);
        /* j=n para j apontar para frente do ultimo numero da lista */
        for(int j=n; j > i;j--){
            v[j] = v[j-1];
        }
        /* Joga o valor inserido na posição de inserção e aumenta o total de números inseridos */
        v[i]=x;
        n++;
        return true;
    }
    /* 2 - Função de busca */
    int busca(String username){
        /* Converte String pra ASC */
        Long usernameProcura = this.geraAsc(username);

        //	Por ser uma Les, o vetor já está ordenado pela ASC do username. Portanto, iteramos i:
        // a - Enquanto ele for menor que o total de números inseridos;
        // b - Enquanto o número naquela posição for menor que o número buscado.
        for(int i=0;i<n && v[i].getUsernameASC() <= usernameProcura;i++){
            System.out.println("Ola papai");
            System.out.println(v[i].getUsernameASC());
            System.out.println(usernameProcura);
            if(v[i].getUsernameASC().equals(usernameProcura)){
                // Retorna a posição
                return i;
            }
        }
        // Retorna -1, indicando que não achou
        return -1;
    }
    /* 3 - Função que converte String pra ASC */
    public Long geraAsc(String entrada) {
        String provisorio = "";
        char[] ascii2 = entrada.toCharArray();
        for(char ch:ascii2){
            provisorio = provisorio + (int)ch;
        }
        return Long.parseLong(provisorio);
    }

}