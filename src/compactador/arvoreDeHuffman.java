package compactador;

public class arvoreDeHuffman {
    private no raiz;
    public String[] tabelaCodificada;
    public String arvoreCodificada;

    public arvoreDeHuffman(no raiz){
        this.raiz = raiz;
        tabelaCodificada = new String[256];
        arvoreCodificada = "";
    }

    public String[] criarTabela(){
        if(raiz.getPreferencia() != 0) {
            criarTabela(raiz, "");
        }
        return tabelaCodificada;
    }

    public void criarTabela(no raiz, String codigo){

        if(raiz.éFolha()){
            int x = (int) raiz.getDados();
            tabelaCodificada[x] = codigo;
            return;
        }

        criarTabela(raiz.esquerda, codigo+"0");

        criarTabela(raiz.direita, codigo+"1");

    }

    public String codificaArvore(){
        if(raiz.getPreferencia() != 0) {
            codificaArvore(raiz);
        }

        return arvoreCodificada;
    }

    public void codificaArvore(no raiz){

        if(raiz.éFolha()){
            arvoreCodificada += 1;
            arvoreCodificada += String.format("%8s", Integer.toBinaryString((int) raiz.getDados())).replace(' ', '0');
            return;
        }
        arvoreCodificada += 0;
        codificaArvore(raiz.esquerda);

        codificaArvore(raiz.direita);
    }

}
