package com.example.alexandrecardoso.projetohotelfei;

public class LES{
    public int v[] = new int[5];
    public int n;
    /* 0 - Construtor */
    public LES(){
        this.n = 0;
    }
    /* 1 - Função de inserção */
    boolean insere(int x){
        if (n == 5){
            return false; // Não admite mais que 5 imagens
        }
        if(this.busca(x) != -1){
            return false; // Não admite duas imagens iguais no vetor
        }
        int i;
        /* Serve para manipular o i e encontrar o local de inserção */
        for(i=0;i < n && v[i] < x ;i++);
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
    int busca(int x){
        //	Por ser uma Les, o vetor já está ordenado. Portanto, iteramos i:
        // a - Enquanto ele for menor que o total de números inseridos;
        // b - Enquanto o número naquela posição for menor que o número buscado.
        for(int i=0;i<n && v[i] <= x;i++){
            if(v[i] == x)
                // Retorna a posição do número procurado
                return i;
        }
        // Retorna -1 para verificação de erros
        return -1;
    }
    /* 3 - Função de impressão */
    void imprime(){
        if (n == 0){
            System.out.println("LES vazia! Insira novos numeros.\n");
        }else{
            int i;
            System.out.println("[");
            for(i=0;i<n;i++){
                if (i==0){
                    System.out.println(v[i]);
                }else{
                    System.out.println(",");
                    System.out.println(v[i]);
                }
            }
            System.out.println("]");
            System.out.println("Numeros inseridos: " + n);
        }
    }
    boolean removeI(int idx){
        if(idx > n || idx < 0){
            // Indice Inválido
            return false;
        }else{
            // Se o indice for menor que o total de números inseridos - 1, joga o indice pra frente
            // Fazemos isso, para mover da direita p/ esquerda os valores da lista
            for(; idx < n-1 ;idx++){
                v[idx] = v[idx+1];
            }
            // Ao fim do laço, removemos 1 do total de números inseridos
            n--;
            return true;
        }
    }
    /* 5 - Função de remoção - remove o numero */
    boolean removeN(int numero){
        // Utilizando a Busca binária para descobrir o indice
        int i = busca(numero);
        if (i == -1){
            return false;
        }else{
            // Chama a função que remove pelo indice
            if(removeI(i)){
                return true;
            }else{
                return false;
            }
        }
    }
}