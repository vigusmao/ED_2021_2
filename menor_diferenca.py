#### Encontrar o par de elementos com a menor diferença absoluta

from random import randint
from time import time



## tempo de pior caso = O(n^2)
## espaço = O(1)
def encontrarMenorDiferenca(elementos):

    menorDiferenca = None

    for i in range(len(elementos)):
        x = elementos[i]  # bloco A

        for j in range(i+1, len(elementos)):
            # bloco B
            y = elementos[j]       # tempo constante, ou seja, O(1)

            diferenca = abs(x - y) # O(1)
            if menorDiferenca == None or diferenca < menorDiferenca:
                menorDiferenca = diferenca    # O(1)
            #if diferenca == 0:
            #    return 0
            # bloco B --> tempo constante    

    return menorDiferenca            
        

## tempo de pior caso = O(n log n)
## espaço = O(n)
def encontrarMenorDiferencaOrdenando(elementos):

    menorDiferenca = None  # O(1)

    listaOrdenada = sorted(elementos)  # O(n log n)

    for i in range(len(elementos)-1):  # n-1 repetições
        x = listaOrdenada[i]    # O(1), isto é, tempo constante
        y = listaOrdenada[i+1]  # O(1)

        diferenca = abs(x - y) # O(1)
        if menorDiferenca == None or diferenca < menorDiferenca:
            menorDiferenca = diferenca    # O(1)
        #if diferenca == 0:
        #    return 0

    return menorDiferenca            
       
        

def criarLista(n):
    lista = []
    for i in range(n):
        lista.append(randint(1, 100000000))
    #    lista.append(i)
    
    
    return lista    






##### "main"

print("Oi!")

while True:
    n = int(input("Tamanho da lista: "))
    if n <= 0:
        break
    lista = criarLista(n)
    #print(lista)
    
    inicio = time()
    diferenca = encontrarMenorDiferenca(lista)
    tempo = time() - inicio
    
    print(diferenca)
    print("tempo (algoritmo quadratico) = %.9f\n\n" % tempo)

    inicio = time()
    diferenca = encontrarMenorDiferencaOrdenando(lista)
    tempo = time() - inicio
    
    print(diferenca)
    print("tempo (algoritmo n log n) = %.9f\n\n" % tempo)


print("Tchau!")
