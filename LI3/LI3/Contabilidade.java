
/**
 * Escreva a descrição da classe Contabilidade aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.io.*;

public class Contabilidade implements Serializable
{
    String Codprod;
    int Ncomp;
    int Pcomp;
    double FaturadoN;
    double FaturadoP;
    int mes;

public Contabilidade(){
this.Codprod="";
this.Ncomp=0;
this.Pcomp=0;
this.FaturadoN=0;
this.FaturadoP=0;
this.mes=0;
}

public Contabilidade(String c,int nc, int pc,double n, double p, int me){
    this.Codprod=c;
   this.Ncomp=nc;
   this.Pcomp=pc;
   this.FaturadoN=n;
   this.FaturadoP=p;
   this.mes=me;
}


public Contabilidade(Contabilidade x){
   this.Codprod=x.getCod();
   this.Ncomp=x.getNcomp();
   this.Pcomp=x.getPcomp();
   this.FaturadoN=x.getFatuN();
   this.FaturadoP=x.getFatuP();
   this.mes=x.getMes();
}


public void atualizaContas(Contabilidade x){
    this.Codprod=x.getCod();
   this.Ncomp+=x.getNcomp();
   this.Pcomp+=x.getPcomp();
   this.FaturadoN+=x.getFatuN();
   this.FaturadoP+=x.getFatuP();
 
}


public int getMes(){
return this.mes;}

public int getNcomp(){
return this.Ncomp;}

public int getPcomp(){
return this.Pcomp;}

public double getFatuN(){
return this.FaturadoN;}


public double getFatuP(){
return this.FaturadoP;}

public String getCod(){
return this.Codprod;}


public Contabilidade clone(){
return new Contabilidade (this);}



}
