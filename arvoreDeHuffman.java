public class arvoreDeHuffman {
    private no raiz;
    public String[] tabelaCodificada;
    public String arvoreCodificada;

    public arvoreDeHuffman(no raiz){
        this.raiz = raiz;
        tabelaCodificada = new String[256];
        arvoreCodificada = "";
    }

    // Metodo para criar arvore a partir da frequencia de caracteres
    public arvoreDeHuffman(filaComPreferencia frequencia){

        this.raiz = criaArvore(frequencia);
        tabelaCodificada = new String[256];
        arvoreCodificada = "";
    }

    private no criaArvore(filaComPreferencia frequencia){

        no folha;
        // Transforma fila de prioridade em uma arvore
        while(frequencia.size() > 1){
            no A = frequencia.dequeue();
            no B = frequencia.dequeue();

            folha = new no(A.getPreferencia()+ B.getPreferencia(), A, B);

            frequencia.inqueue(folha);
        }

        return frequencia.dequeue();
    }

    public no getRaiz(){
        return raiz;
    }

    public String[] criarTabela(){
        // metodo rucursivo para criar a tabela
        if(raiz.getPreferencia() != 0) {
            criarTabela(raiz, "");
        }
        return tabelaCodificada;
    }

    public void criarTabela(no raiz, String codigo){

        // Exeção de um elemento na arvore
        if(raiz.éFolha() && raiz == this.raiz){
            int x = raiz.getDados();
            tabelaCodificada[x] = "0";
            return;
        }

        // Se achar um elemento adicionar o novo valor na tabela
        if(raiz.éFolha()){
            int x = raiz.getDados();
            tabelaCodificada[x] = codigo;
            return;
        }

        // Chamada recursiva com codigo atualizado
        criarTabela(raiz.esquerda, codigo+"0");

        criarTabela(raiz.direita, codigo+"1");

    }

    public String codificaArvore(){

        // metodo rucursivo para codificar a arvore
        if(raiz.getPreferencia() != 0) {
            codificaArvore(raiz);
        }

        return arvoreCodificada;
    }

    public void codificaArvore(no raiz){

        // Quando achar um elemento, escreve 1 seu valor
        if(raiz.éFolha()){
            arvoreCodificada += 1;
            arvoreCodificada += String.format("%8s", Integer.toBinaryString(raiz.getDados())).replace(' ', '0');
            return;
        }

        // Quando não achar, escreve 0 e chama o metodo para os filhos
        arvoreCodificada += 0;
        codificaArvore(raiz.esquerda);

        codificaArvore(raiz.direita);
    }

    public void exibirEmOrdem() {
        if( raiz != null) {
            exibirEmOrdem(raiz);
            System.out.println();
        }else
            System.out.println("Arvore vazia");
    }

    private void exibirEmOrdem(no raiz) {
        if (raiz.getEsquerda() != null) {
            exibirEmOrdem(raiz.getEsquerda());
        }

        System.out.print(raiz.getDados()+" ");

        if (raiz.getDireita() != null) {
            exibirEmOrdem(raiz.getDireita());
        }
    }
}
