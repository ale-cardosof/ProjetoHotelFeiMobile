package com.example.alexandrecardoso.projetohotelfei;

public class Arvore_user{
    // Atributos
    private Usuario raiz; // Primeiro Usuario
    public int n;

    /* 0 - Construtor */
    public Arvore_user() {
        this.raiz = null;
        this.n = 0;
    }
    /* 1 - Insere */
    public void insere(Usuario x){
        // Anterior irá guardar o possível pai
        Usuario ptrAnterior;
        ptrAnterior = null;
        // Ponteiro Atual é quem percorre de fato a árvore
        Usuario ptrAtual;
        ptrAtual = raiz;
        // Procura quem vai ser o pai e armazena em Ponteiro Anterior
        while(ptrAtual != null){
            ptrAnterior = ptrAtual;
            if(x.getUsernameASC() < ptrAtual.getUsernameASC()){
                ptrAtual = ptrAtual.getEsquerda();
            }else{
                ptrAtual = ptrAtual.getDireita();
            }
        }
        if(ptrAnterior != null){
            if(x.getUsernameASC() < ptrAnterior.getUsernameASC()){
                ptrAnterior.setEsquerda(x);
            }else{
                ptrAnterior.setDireita(x);
            }
        }else{
            raiz = x;
        }
        x.setPai(ptrAnterior);
        n++;
        // Usada no balanceia
        /* Referência o ponteiro pai
        No<T>* pai = novo->getPai();
        // Balanceia a Árvore após a inserção
        while(pai){
        this->balanceia(pai);
        pai = pai->getPai();
        }*/
    }
    /* 2 - Busca pelo username (ASC) */
    public Usuario busca(Long x){
        Usuario ptrAnterior;
        ptrAnterior = raiz;
        while(ptrAnterior != null){
            if(x.equals(ptrAnterior.getUsernameASC())){
                return ptrAnterior;
            }
            if(x > ptrAnterior.getUsernameASC()){
                ptrAnterior = ptrAnterior.getDireita();
            }else{
                ptrAnterior = ptrAnterior.getEsquerda();
            }
        }
        return null;
    }
    /* 3  - Remove pelo username (ASC) */
    public Usuario remove(Long x){
        Usuario ptrRemovido = this.busca(x);
        Usuario novoFilho;
        Usuario pai;
        int qntdFilhos;
        // Se o valor for encontrado
        if(ptrRemovido != null){
            qntdFilhos = this.contaFilhos(ptrRemovido);
            if (qntdFilhos == 2){
                // Nesse Caso, tem dois filhos
                Usuario atual = ptrRemovido.getDireita();
                Usuario anterior = atual;
                // Acha o menor sucessor
                while(atual != null){
                    anterior = atual;
                    atual = atual.getEsquerda();
                }
                // Reposiciona filhos do que irá substituir o removido
                this.remove(anterior.getUsernameASC());
                // Substiui o removido pelo antecessor
                // ptrRemovido.setValor(anterior->getValor());
                // -- Aqui ao invés de fazer a linha acima, eu copiei o Usuário
                ptrRemovido.copiaUser(anterior);
            }else if(qntdFilhos == 1){
                // Nesse Caso, tem apenas 1 filho
                // Verifica se é o da esquerda
                if(ptrRemovido.getEsquerda() != null){
                    // Muda o endereçamento do pai
                    pai = ptrRemovido.getPai();
                    // Muda o endereçamento do filho direito
                    novoFilho = ptrRemovido.getEsquerda();
                    // Troca os endereçamentos do pai e do filho
                    pai.setEsquerda(novoFilho);
                    novoFilho.setPai(pai);
                    // Retorna o filho removido
                    return ptrRemovido;
                }else{
                    // Nesse Caso, tem apenas o da direita
                    // Muda o endereçamento do pai
                    pai = ptrRemovido.getPai();
                    // Muda o endereçamento do filho direito
                    novoFilho = ptrRemovido.getDireita();
                    // Troca os endereçamentos do pai e do filho
                    pai.setDireita(novoFilho);
                    novoFilho.setPai(pai);
                    // Returna o filho removido
                    return ptrRemovido;
                }
            }else{
                // Nesse Caso, não tem filhos, portanto, é só remover
                // Antes, verifica qual filho do pai será apontado para Null
                pai = ptrRemovido.getPai();
                if(pai != null){
                    if(x >= pai.getUsernameASC()){
                        pai.setDireita(null);
                    }else{
                        pai.setEsquerda(null);
                    }
                }else{
                    // Caso o Pai seja nulo, atribumos raiz para nulo e a arvore fica vazia
                    raiz = null;
                }
                /*
                // Referência o ponteiro pai
                No<T>* pai = ptrRemovido->getPai();
                // Balanceia a Árvore após a inserção
                while(pai){
                    this->balanceia(pai);
                    pai = pai->getPai();
                }*/
                // Returna o filho removido
                return ptrRemovido;
            }
            // Se o valor não for encontrado
        }else{
            return null;
        }
        return null; // Nunca cairá aqui.
    }
    /* 4 - Conta filhos */
    public int contaFilhos(Usuario ptr){
        if((ptr.getEsquerda() != null) && (ptr.getDireita() != null))
            return 2;
        else if ((ptr.getEsquerda() != null) || (ptr.getDireita() != null))
            return 1;
        else
            return 0;
    }

}