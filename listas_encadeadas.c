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

// adiciona elemento no final da lista
void add(LISTA *lista, int x) {
    NO_LISTA *novo = (NO_LISTA*) malloc(sizeof(NO_LISTA));


    if (lista->tamanho == 0) {
        lista->primeiro = novo;
    } else {
        lista->ultimo->proximo = novo;
        novo->anterior =
    }

    lista->ultimo = novo;
    lista->tamanho++;


}




int main() {


    int x[5];  // array estático
    long y = 12345678;
    int z = 1234;
    x[4] = z;
    x[3] = y;

    printf("\n%d", x[3]);
    printf("\n%d\n", x[4]);


    int *numeros;
    numeros = (int*) malloc(5 * sizeof(int));  // array dinâmico alocado para 5 elementos


}
