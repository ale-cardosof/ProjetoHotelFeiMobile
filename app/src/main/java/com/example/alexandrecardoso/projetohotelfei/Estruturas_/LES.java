package com.example.alexandrecardoso.projetohotelfei.Estruturas_;

public class LES<Bitmap>{
    public Bitmap v[] = (Bitmap[]) new Object[5];
    public int n;
    /* 0 - Construtor */
    public LES(){
        this.n = 0;
    }
    /* 1 - Função de inserção */
    public boolean insere(Bitmap x, int posicao){
        if (n == 5 || posicao > 4){
            return false; // Não admite mais que 5 imagens
        }

        /*
        if(this.busca(x) != -1){
            return false; // Não admite duas imagens iguais no vetor
        }*/

        /* Joga o valor inserido na posição de inserção e aumenta o total de números inseridos */
        v[posicao] = x;
        n++;
        return true;
    }
    /* 2 - Função de busca
    public int busca(Bitmap x){
        //	Por ser uma Les, o vetor já está ordenado. Portanto, iteramos i:
        // a - Enquanto ele for menor que o total de números inseridos;
        // b - Enquanto o número naquela posição for menor que o número buscado.
        for(int i=0;i<n && !v[i].equals(x);i++){
            if(v[i] == x)
                // Retorna a posição do número procurado
                return i;
        }
        // Retorna -1 para verificação de erros
        return -1;
    }*/
    // Busca pelo indice
    public Bitmap busca(int x){
        return v[x];
    }

    /* 3 - Função de impressão */
    public void imprime(){
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

    /* 3 - Função que converte String pra ASC*/
    public Long geraAsc(String entrada) {
        String provisorio = "";
        char[] ascii2 = entrada.toCharArray();
        for(char ch:ascii2){
            provisorio = provisorio + ((int)ch - 48);
        }
        return Long.parseLong(provisorio);
    }
}