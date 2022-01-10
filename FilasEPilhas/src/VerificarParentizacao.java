public class VerificarParentizacao {

    /**
     * Valida a aprentização de uma expressão aritmética
     * @param expressao a expressão a ser validada
     * @return true, se válida; false, se inválida
     */
    public static boolean verificar(String expressao) {
        Pilha<Character> pilha = new PilhaUsandoListaEncadeada<>();

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                pilha.empilhar(c);
            } else if (c == '}') {
                if (pilha.consultarTopo() != '{') {
                    return false;
                }
                pilha.desempilhar();
            } else if (c == ']') {
                if (pilha.consultarTopo() != '[') {
                    return false;
                }
                pilha.desempilhar();
            } else if (c == ')') {
                if (pilha.consultarTopo() != '(') {
                    return false;
                }
                pilha.desempilhar();
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(verificar("{[10 * (30 - x)^2] / (4 - y + z)}"));  // true
        System.out.println(verificar("{[10 * (30 - x)^2) / (4 - y + z)}"));  // false
        System.out.println(verificar("{[10 * (30 - x))^2] / (4 - y + z)}")); // false
        System.out.println(verificar("{[10 * (30 - x)^2] / (4 - y + z})"));  // false
        System.out.println(verificar("((10 * (30 - x)^2) / (4 - y + z))"));  // true

    }
}



/*    main() {
        System.out.println(facaAlgo(3));




     public int facaAlgo(int x) {
           int resultado = 2 * fatorial(x);
           if (resultado > 1000) {
               resultado -= 200;
           }
           return resultado;
     }

     public int fatorial(int x) {
        if (x <= 1) {
             return 1;
        }
        return x * fatorial(x - 1);
     }






    ___________________
*/

