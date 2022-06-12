import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class compressão {
    private String[] TabelaCodificada;
    private arvoreDeHuffman arvoreH;

    public void comprimir(String file) throws IOException {
        filaComPreferencia frequencia = new filaComPreferencia();
        listaEstatica t = new listaEstatica();

        FileInputStream in = new FileInputStream(file);
        InputStreamReader entrada = new InputStreamReader(in);

        int[] Histograma = new int[256];
        int c = entrada.read();

        // Contagem de frequencia de caracteres
        while(c != -1){
            Histograma[c]++;
            t.add(c);
            c = entrada.read();
        }


        // Cria fila ordenada
        for(int i = 0; i < 256; i++){
            if(Histograma[i] != 0)
                frequencia.inqueue(i, Histograma[i]);
        }
        //frequencia.show();


        // Cria a arvore apartir da frequencia de caracteres
        this.arvoreH = new arvoreDeHuffman(frequencia);

        // Cria a nova tabela
        this.TabelaCodificada = arvoreH.criarTabela();
        arvoreH.codificaArvore();


        // Cria arquivo de saida
        File fi = new File("src/saida.txt");
        fi.createNewFile();

        FileWriter f = new FileWriter(fi);
        BufferedWriter saida = new BufferedWriter(f);

        // Escreve arvore
        saida.write(arvoreH.arvoreCodificada);
        saida.newLine();

        // Codifica texto
        String textoCodificado = "";
        for (int i = 0; i < t.size(); i++){
            textoCodificado += TabelaCodificada[((int)t.get(i))];
        }

        //Escreve texto
        saida.write(textoCodificado);
        saida.close();

    }

}
