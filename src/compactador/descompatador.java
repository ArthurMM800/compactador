package compactador;

public class descompatador {
    private String binario;
    private String mensagem;
    private int i = 0;
    private no raiz;
    private String texto = "";



    public descompatador(String binario, String mensagem){
        this.binario = binario;
        this.raiz = leArvore();
        this.mensagem = mensagem;
        leTexto();

    }

    public no getRaiz(){
        return raiz;
    }

    public no leArvore(){
        if(binario.charAt(this.i) == '1'){
            int c = Integer.parseInt(binario.substring(i+1, i+9), 2);
            this.i += 9;
            return new no(c , 0);

        }else {
            i++;
            return new no(0, this.leArvore(), this.leArvore());
        }
    }

    public void leTexto(){
        no temp = raiz;
        for(int i = 0; i < mensagem.length(); i++) {
            if (mensagem.charAt(i) == '0' && temp.esquerda != null) {
                temp = temp.esquerda;
            } else if (mensagem.charAt(i) == '1'){
                temp = temp.direita;
            }

            if (temp.éFolha()) {
                texto += (char) (int) temp.getDados();
                temp = raiz;
            }
        }

        System.out.println(texto);
    }



}
