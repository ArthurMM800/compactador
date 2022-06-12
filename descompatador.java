import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class descompatador {
    private String binario;
    private String mensagem;
    private int i = 0;
    private no raiz;
    private String texto = "";


    public descompatador(String s) throws IOException {
        leArquivo(s);
        this.raiz = leArvore();
        leTexto();
    }

    public no getRaiz(){
        return raiz;
    }

    public void leArquivo(String s) throws IOException {


        FileInputStream in = new FileInputStream(s);
        InputStreamReader entrada = new InputStreamReader(in);


        String palavra = "";
        String binario = "";
        String msg = "";

        // Leitura do arquivo especificado anteriormente
        int c = entrada.read();

        // Leitura bit a bit da arvore
        while(c != -1){

            // Quando achar 0
            if (c == 48)
                binario += "0";
            // Quando achar 1
            else if (c == 49)
                binario += "1";

            // Quando achar \n
            if(c == 10)
                break;
            c = entrada.read();
        }

        // Leitura bit a bit do texto
        while(c != -1){

            if (c == 48)
                msg += "0";
            else if (c == 49)
                msg += "1";

            c = entrada.read();
        }

        this.binario = binario;
        this.mensagem = msg;
    }

    public no leArvore(){
        // Achou 1 proximos 8 bits caracterizam o elemento da posição
        if(binario.charAt(this.i) == '1'){
            int c = Integer.parseInt(binario.substring(i+1, i+9), 2);
            this.i += 9;
            return new no(c , 0);
        // Chamada recurciva para os filhos
        }else {
            i++;
            return new no(0, this.leArvore(), this.leArvore());
        }
    }

    public void leTexto(){
        no temp = raiz;
        // Leitura do texto
        for(int i = 0; i < mensagem.length(); i++) {
            if (mensagem.charAt(i) == '0' && temp.esquerda != null) {
                temp = temp.esquerda;
            } else if (mensagem.charAt(i) == '1'){
                temp = temp.direita;
            }

            // Escreve o caractere correspondente
            if (temp.éFolha()) {
                texto += (char) (int) temp.getDados();
                temp = raiz;
            }
        }

        System.out.println(texto);
    }



}
