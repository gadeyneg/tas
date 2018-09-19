import java.util.*;

public class Tas_ng {
    private Integer queue[];
    private int indice_last=0;
    private int capacity;

    public void Tas_ng (Integer N){
        queue = new Integer[N];
        capacity=N;
    }

    public void echangeElement(int A, int B){
        int b = queue[A];
        queue[A]=queue[B];
        queue[B]=b;
    }

    public int getIndice_last(){
        return this.indice_last;
    }

    public int getCapacity() {
        return capacity;
    }

    public void ajouterElement(int A){
        queue[++indice_last]=A;
    }

    public int getPere(int i){
        int etage = (int)(Math.floor(Math.log(i)/Math.log(2)));
        int posPere = (int)(Math.floor((i-2^etage)/2));
        return queue[2^(etage-1)+posPere];
    }

    //il manque un -1 dans la partie qui identifie la position du père dans l'étage (suremment ((i-2^etage)-1)/2

    public Integer[] getFils(int i){
        Integer fils[]=new Integer[2];
        int etage = (int)(Math.floor(Math.log(i)/Math.log(2)));
        int posFils = (int)(Math.floor((i-2^etage)*2));
        fils[0]=queue[2^(i+1)+2*posFils];
        fils[0]=queue[2^(i+1)+2*posFils+1];
        return fils;
    }
}
