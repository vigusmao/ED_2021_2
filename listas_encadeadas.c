#include <stdlib.h>
#include <stdio.h>

typedef struct no_lista {
    int valor;
    struct no_lista *proximo;
    struct no_lista *anterior;
} NO_LISTA;

typedef struct lista_duplamente_encadeada {
    NO_LISTA *primeiro;
    NO_LISTA *ultimo;
    int tamanho;
} LISTA;


LISTA* criar_lista() {
    LISTA* lista = (LISTA*) malloc(sizeof(LISTA));
    lista->primeiro = NULL;
    lista->ultimo = NULL;
    lista->tamanho = 0;
    return lista;
}

// adiciona elemento no final da lista
NO_LISTA* add(LISTA *lista, int x) {
    NO_LISTA *novo = (NO_LISTA*) malloc(sizeof(NO_LISTA));

    if (lista->tamanho == 0) {
        lista->primeiro = novo;
    } else {
        lista->ultimo->proximo = novo;
        novo->anterior = lista->ultimo;
    }

    lista->ultimo = novo;
    lista->tamanho++;

    novo->valor = x;
    novo->proximo = NULL;

    return novo;
}

void remover(LISTA* lista, NO_LISTA* no_a_ser_removido) {
    if (lista->tamanho == 1) {
        lista->ultimo = NULL;
        lista->primeiro = NULL;
    } else {
        if (no_a_ser_removido->anterior != NULL) {
            no_a_ser_removido->anterior->proximo = no_a_ser_removido->proximo;
        } else {
            // era o primeiro no da lista
            lista->primeiro = no_a_ser_removido->proximo;
        }

        if (no_a_ser_removido->proximo != NULL) {
            no_a_ser_removido->proximo->anterior = no_a_ser_removido->anterior;
        } else {
            // era o último da lista
            lista->ultimo = no_a_ser_removido->anterior;
        }
    }

    lista->tamanho--;
    free(no_a_ser_removido);
}

// retorna o primeiro nó da lista cujo valor seja igual ao valor informado
NO_LISTA* encontrarNo(LISTA* lista, int x) {
    NO_LISTA* no = lista->primeiro;
    while (no != NULL) {
        if (no->valor == x) {
            // encontrei!!!!!
            return no;
        }
        no = no->proximo;
    }
    return NULL;
}

// retorna o (indice+1)-ésimo elemento
NO_LISTA* get(LISTA* lista, int indice) {
    int cont = 0;
    NO_LISTA* no = lista->primeiro;
    while (no != NULL) {
        if (cont == indice) {
            return no;
        }
        cont++;
        no = no->proximo;
    }
    return NULL;   // poderia lançar exceção IndexOutOfBoundsException
}

void imprimir_lista(LISTA* lista) {
    NO_LISTA* no = lista->primeiro;
    while (no != NULL) {
        printf("%d", no->valor);
        if (no->proximo != NULL) {
            printf(", ");
        }
        no = no->proximo;
    }
}


int main() {
    LISTA* minha_lista = criar_lista();
    printf("\n Lista criada com tamanho %d", minha_lista->tamanho);

    add(minha_lista, 30);
    add(minha_lista, 40);
    add(minha_lista, 50);
    add(minha_lista, 60);

    printf("\nTamanho atual depois dos adds = %d", minha_lista->tamanho);
    printf("\nValor do primeiro no da lista = %d", minha_lista->primeiro->valor);

    printf("\nValor do ultimo no da lista = %d", minha_lista->ultimo->valor);

    NO_LISTA* no = encontrarNo(minha_lista, 40);
    if (no != NULL) {
        remover(minha_lista, no);
    }

    printf("\nTamanho atual depois da remocao = %d", minha_lista->tamanho);
    printf("\nLista: ");
    imprimir_lista(minha_lista);

}
