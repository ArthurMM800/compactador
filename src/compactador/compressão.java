package compactador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class compressão {
    public static void main(String[] args) throws IOException {
        arvoreDeHuffman arvoreH;
        filaComPreferencia frequencia = new filaComPreferencia();
        no raiz;
        List t = new ArrayList<Integer>();


        String file = "C:\\Users\\USUARIO\\Documents\\BACKUP\\Desktop\\arthur\\Compactador\\src\\compactador\\teste.txt";
        FileInputStream in = new FileInputStream(file);
        InputStreamReader entrada = new InputStreamReader(in);

        int[] Histograma = new int[256];
        int c = entrada.read();

        // Contagem de frequencia
        while(c != -1){
            if(c != -1)
                Histograma[c]++;
            t.add(c);
            c = entrada.read();
        }


        // Cria fila ordenada por frequencia

        for(int i = 0; i < 256; i++){
            if(Histograma[i] != 0)
                frequencia.inqueue(i, Histograma[i]);
        }
        //frequencia.show();


        // cria a arvore
        raiz = criaArvore(frequencia);

        String[] TabelaAscii;

        arvoreH = new arvoreDeHuffman(raiz);
        TabelaAscii = arvoreH.criarTabela();
        arvoreH.codificaArvore();


        String s = "C:\\Users\\USUARIO\\Documents\\BACKUP\\Desktop\\arthur\\Compactador\\src\\compactador\\saida.txt";
        FileWriter f = new FileWriter(s);
        BufferedWriter saida = new BufferedWriter(f);

        saida.write(arvoreH.arvoreCodificada);
        saida.newLine();

        String textoCodificado = "";
        for (int i = 0; i < t.size(); i++){
            textoCodificado += TabelaAscii[((int)t.get(i))];
        }

        saida.write(textoCodificado);

        saida.close();

    }


    private static no criaArvore(filaComPreferencia frequencia){
        no folha;
        while(frequencia.size() > 1){

            no A = frequencia.dequeue();
            no B = frequencia.dequeue();

            folha = new no(A.getPreferencia()+ B.getPreferencia(), A, B);

            frequencia.inqueue(folha);
        }

        return frequencia.dequeue();
    }


    private static void exibirEmOrdem(no raiz) {

        if (raiz.getEsquerda() != null) {
            exibirEmOrdem(raiz.getEsquerda());
        }


        System.out.print(raiz.getDados()+"; ");


        if (raiz.getDireita() != null) {
            exibirEmOrdem(raiz.getDireita());
        }
    }
}
