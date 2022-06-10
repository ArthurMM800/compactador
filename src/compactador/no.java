package compactador;

public class no {
    private Object dados;
    private no proximo;
    public no esquerda;
    public no direita;
    private int preferencia;

    public no() {
        this.proximo = null;
        this.preferencia = 0;
        this.esquerda = null;
        this.direita = null;
        this.dados = null;
    }

    public no(int preferencia) {
        this.proximo = null;
        this.preferencia = preferencia;
        this.esquerda = null;
        this.direita = null;
        this.dados = null;
    }

    public no(Object dado, int preferencia) {
        this.proximo = null;
        this.preferencia = preferencia;
        this.esquerda = null;
        this.direita = null;
        this.dados = dado;
    }

    public no(int preferencia, no esquerda, no direita) {
        this.proximo = null;
        this.preferencia = preferencia;
        this.esquerda = esquerda;
        this.direita = direita;
        this.dados = null;
    }

    public boolean éFolha(){
        return esquerda == null && direita == null;
    }


    public no getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(no esquerda) {
        this.esquerda = esquerda;
    }

    public no getDireita() {
        return direita;
    }

    public void setDireita(no direita) {
        this.direita = direita;
    }

    public int getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(int preferencia) {
        this.preferencia = preferencia;
    }

    public Object getDados() {
        return dados;
    }

    public void setDados(Object dados) {
        this.dados = dados;
    }

    public no getProximo() {
        return proximo;
    }

    public void setProximo(no proximo) {
        this.proximo = proximo;
    }
}
