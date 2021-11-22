#### Encontrar o par de elementos com a menor diferença absoluta

from random import randint
from time import time


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
            if diferenca == 0:
                return 0
            # bloco B --> tempo constante    

    return menorDiferenca            
        
        

def criarLista(n):
    lista = []
    for i in range(n):
    #    lista.append(randint(1, 10000000))
        lista.append(i)
    
    
    return lista    






##### "main"

print("Oi!")

while True:
    n = int(input("Tamanho da lista: "))
    if n <= 0:
        break
    lista = criarLista(n)
    
    inicio = time()
    diferenca = encontrarMenorDiferenca(lista)
    tempo = time() - inicio

    print(diferenca)
    print("tempo = %.9f\n\n" % tempo)

print("Tchau!")
