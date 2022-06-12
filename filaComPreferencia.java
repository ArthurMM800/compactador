public class filaComPreferencia {
    private no primeiro;
    private no ultimo;
    private int contador;

    public filaComPreferencia() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public void inqueue(Integer dado, int frequecia){
        no novoNo = new no(dado, frequecia);

        if(primeiro == null){
            primeiro = novoNo;
            ultimo = novoNo;

        }else if(primeiro.getPreferencia() > frequecia){
            novoNo.setProximo(primeiro);
            primeiro = novoNo;

        }else if(ultimo.getPreferencia() <= frequecia){
            ultimo.setProximo(novoNo);
            ultimo = novoNo;

        }else{
            no aux = primeiro;

            while(aux != null && novoNo.getPreferencia() >= aux.getProximo().getPreferencia()){
                aux = aux.getProximo();
            }

            novoNo.setProximo(aux.getProximo());
            aux.setProximo(novoNo);
        }
        contador++;

    }

    public void inqueue(no x){

        if(primeiro == null){
            primeiro = x;
            ultimo = x;

        }else if(primeiro.getPreferencia() > x.getPreferencia()){
            x.setProximo(primeiro);
            primeiro = x;

        }else if(ultimo.getPreferencia() <= x.getPreferencia()){
            ultimo.setProximo(x);
            ultimo = x;

        }else{
            no aux = primeiro;

            while(aux != null && x.getPreferencia() >= aux.getProximo().getPreferencia()){
                aux = aux.getProximo();
            }

            x.setProximo(aux.getProximo());
            aux.setProximo(x);
        }
        contador++;

    }



    public no dequeue(){
        if(primeiro == null)
            return null;

        no v = primeiro;

        primeiro = primeiro.getProximo();
        contador--;

        return v;
    }

    public no proximo(){
        return primeiro;
    }



    public int size(){
        return contador;
    }

    public boolean contains(Object elemento){
        no aux = primeiro;
        while (aux.getProximo() != null){
            if (aux.getDados().equals(elemento))
                return true;
            aux = aux.getProximo();
        }
        return false;
    }



    public void clear(){
        primeiro = null;
        ultimo = null;
        contador = 0;
    }

    public void show(){

        if(primeiro != null){
            System.out.print(primeiro.getDados()+ " "+ primeiro.getPreferencia());
            no aux = primeiro;
            while (aux.getProximo() != null){
                aux = aux.getProximo();
                System.out.print(", " + aux.getDados()+ " "+ aux.getPreferencia());
            }
            System.out.println();
        }
    }
}
