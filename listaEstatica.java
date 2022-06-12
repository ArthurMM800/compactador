public class listaEstatica {
    private int contador;
    private Object[] lista;

    public listaEstatica(){
        contador = 0;
        lista = new Object[10];
    }

    public void add(int element){

        if(contador < lista.length) {
            lista[contador] = element;
            contador++;
        }else{
            Object[] aux = new Object[(int)(lista.length*1.5)];

            for(int i = 0; i < contador; i++){
                aux[i] = lista[i];
            }
            lista = aux;
            lista[contador] = element;
            contador++;
        }
    }

    public void add( int indice, int element){
        if(indice > contador)
            return;

        if(contador < lista.length) {
            for (int i = contador; i > indice; i--){
                lista[i] = lista[i-1];
            }
            lista[indice] = element;
        }else{
            Object[] aux = new Object[(int)(lista.length*1.5)];

            for(int i = 0; i < indice; i++){
                aux[i] = lista[i];
            }
            aux[indice] = element;
            for(int i = indice; i < contador; i++){
                aux[i+1] = lista[i];
            }

            lista = aux;
        }
        contador++;
    }

    public Object get(int indice){
        if(indice < contador)
            return lista[indice];

        return 0;
    }

    public void set(int indice, Object elemento){
        if(indice < contador)
            lista[indice] = elemento;
    }

    public void remove(int indice){
        if(indice == contador-1){
            lista[indice] = null;
            contador--;
            return;
        }else if(indice >= contador-1){
            return;
        }else {
            for (int i = indice; i < contador - 1; i++) {
                lista[i] = lista[i + 1];
            }
            lista[contador - 1] = null;
            contador--;
        }
    }

    public int size(){
        return contador;
    }

    public boolean empty(){
        if (contador == 0)
            return true;
        else
            return false;
    }

    public Boolean contains(Object x){
        for(int i = 0; i < contador-1; i++){
            if(lista[i].equals(x))
                return true;
        }
        return false;
    }

    public void clear(){
        lista = new Object[10];
        contador = 0;
    }

    public void show(){
        if(contador == 0){
            System.out.println("A lista esta vazia!");
            return;
        }

        for(int i = 0; i < contador; i++) {
            System.out.print(lista[i] + " ");
        }
        System.out.println();
    }
}
