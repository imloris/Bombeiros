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
    
    public void mostra(){
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
    
    public void caminho(ArrayList<Integer>rota, int v, int w, int i){//monta os caminho
        rota.add(v);
        
        if(v == w){
            System.out.println("é rota: "+rota);
        }

        for(int j = 2;j < this.V; j++ ){
            if(this.matriz[v][j] == 1){
                caminho(rota, j, w, i);
                rota.remove(rota.size()-1);
            }
        } 
    }
    
    void ciclo(ArrayList<Boolean>visitado, int v, int w){ //verifica se ja foi visitado
        visitado.set(v, true);
        
        for(int j = 1; j < this.V; j++){
            if(this.matriz[v][j] == 1){
                if(visitado.get(j) == false){
                    ciclo(visitado, j, w);
                    visitado.set(j, false);
                } else {
                    System.out.println("par "+v+" "+j+" forma ciclo");
                    this.matriz[v][j] = 0;
                }
            }
        }
    }  
}
