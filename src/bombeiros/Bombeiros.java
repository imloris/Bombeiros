package bombeiros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Bombeiros {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        //variaveis
        int incendio, verticex, verticey;
        String aux, linha, vertice[];
        ArrayList<Integer>sequencia = new ArrayList<>();
        ArrayList<Boolean>visitado = new ArrayList<>();
        // variaveis para abrir e  ler o arquivo
        FileReader leArquivo;
        BufferedReader leBuffer;
        // invocar a classe grafo
        Grafo grafo = new Grafo(7);

        // abre e le o arquivo
        leArquivo = new FileReader("arquivo.txt");
        leBuffer = new BufferedReader(leArquivo);

        //recebe o valor da onde está ocorrendo o incendio
        aux = leBuffer.readLine();
        incendio = Integer.parseInt(aux);

        linha = leBuffer.readLine(); //serve como auxiliar recebendo os valores
        vertice = linha.split(" "); //recebe os valores da linha e quebra a linha
        verticex = Integer.parseInt(vertice[0]);//recebe e transforma em int o primeiro valor do vertice
        verticey = Integer.parseInt(vertice[1]);//recebe e transforma em int o segundo valor do vertice

        grafo.insere(verticex, verticey); //insere os valores do verticex e verticey na primeira aresta

        while(verticex !=0 && verticey != 0){
            linha = leBuffer.readLine();
            vertice = linha.split(" ");
            verticex = Integer.parseInt(vertice[0]);
            verticey = Integer.parseInt(vertice[1]);

            //condição de parada
            if(verticex == 0 && verticey ==0){
                break;
            }
            else{
                if(verticex == verticey){//bloquear pares com x = y
                    System.out.println("par "+verticex+" "+verticey+" x deve ser diferente do y");
                    continue;
                }
                if(grafo.pares(verticex, verticey)){
                    System.out.println("par "+verticex+" "+verticey+" já foi inserido");
                    continue;
                }                             
            }
            
            grafo.insere(verticex, verticey); //insere os pares restantes nas arestas seguintes
        }
        
        System.out.println();
        grafo.mostra();
        System.out.println();
        

        for(int i = 0; i < grafo.getV(); i++){//insere os visitados
            visitado.add(i, false);
        }
        
        grafo.caminho(sequencia, 1, incendio, -1, visitado); //printa os caminhos

    }
}
