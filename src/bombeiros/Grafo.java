package bombeiros;

import java.util.*;

public class Grafo {

    private int V; //vertice
    private int A; //aresta
    private int matriz[][]; //matriz
    boolean getV;

    public Grafo(int V){ //inicializa os atributos e cria matriz
        this.V = V;
        this.A = 0;
        matriz = new int[V][V]; //cria matriz
    }

    public void insere(int v, int w){//insere a aresta no grafo e depois atualiza o A.
        if(this.matriz[v][w] == 0){
            this.matriz[v][w]=1;
            this.A++;
        }
    }
    
    public boolean pares(int linha, int coluna){ // verifica se os pares já foram inseridos
        if(this.matriz[linha][coluna] == 1){
            return true;
        }
        return false;
    }
    
    public void mostra( ){
        for( int v=0; v < this.V; v++){
            System.out.print(v+":");
            for( int w=0; w < this.V; w++){
                if( this.matriz[v][w]==1)
                    System.out.print(" "+w);
                    
            }
            System.out.println();
        }
    }
    
    public int getV() {
        return V;
    }
    
    public void caminho(ArrayList<Integer>rota, int v, int w, int i, ArrayList<Boolean>visitado){//monta os caminho
        i++;
        rota.add(v);
        
        if(v == w){  
            System.out.println("é rota: "+rota);
            
        }
        for(int j =2;j < this.V; j++ ){
            if(this.matriz[v][j] == 1){
                visitado.add(j, true);
                caminho(rota, j, w, i, visitado);
                rota.remove(rota.size()-1);
            }
        }
    }
    /*
    public boolean fazcaminho(ArrayList<Integer>sequencia){ //verifica se é caminho
        
        int w = 1;
        
        for(int v= 0; v<=sequencia.size()-2; v++){
            System.out.println("entrou");
            if(this.matriz[sequencia.get(v)][sequencia.get(w)]!=1){
                System.out.println("");
                System.out.println("não é caminho: ");
                System.out.println(sequencia);
                return false;
            }
            if(w <= sequencia.size()-1){
                w+=1;
            }
        }
        return true;
    }*/
}
