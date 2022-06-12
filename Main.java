import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner dados = new Scanner(System.in);

        System.out.println("Escreva a operação que deseja.");
        String operação = dados.next();

        if(operação.equals("compactar")){

            //ler o nome do arquivo para compactar
            String file = "src/";
            System.out.println("Escreva o nome do arquivo para compactar.");
            file += dados.next();
            file += ".txt";

            compressão comprimeArquivo = new compressão();
            // Executar compresão no arquivo escrito
            try {
                comprimeArquivo.comprimir(file);
            }catch (Exception e){
                System.out.println("Erro");
            }

        }else if(operação.equals("descompactar")){
            //ler o nome do arquivo para desconpactar
            String s = "src/";
            System.out.println("Escreva o nome do arquivo para Descompactar.");
            s += dados.next();
            s += ".txt";

            // Executar descompractação no arquivo escrito
            try {
                descompatador d = new descompatador(s);
            }catch (Exception e){
                System.out.println("Erro");
            }

        }
    }
}

