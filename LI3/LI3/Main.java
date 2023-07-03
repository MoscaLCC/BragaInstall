
/**
 * Escreva a descrição da classe Main aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Main implements Serializable
{
    public static void main(String [] args){
        out.print('\u000C');
        GestHiper gest= new GestHiper();
        Scanner lerI = new Scanner(System.in);
        Scanner lerS = new Scanner(System.in);
        int cont=0;
        int rp=0;
        String cdp2="";
       out.println("--BEM-VINDO AO GESTHIPER--OO--\n");
    do{out.println("------------------------------");
       out.println("|0)Carregar estruturas       |");// vai mudar
       out.println("|1)Salvaguardar estado       |");
       out.println("|2)Queries Estatísticas      |");
       out.println("|3)Queries Interativas       |");
       out.println("|11)Sair do Programa         |");
       out.println("------------------------------");
       cont=lerI.nextInt();
       
       switch(cont){
       
          case (0):
           out.println("Como deseja carregar? 1) Ficheiros fonte 2) de ObjectStream:");
           rp=lerI.nextInt();
           if(rp==1){
          String info="";
          out.println("Insira o nome do ficheiro de compras que deseja ler:");
          cdp2=lerS.next();
          out.println(" A Carregar...."); 
          try{
              Crono.start();
              info = gest.CarregaDados(cdp2);
              out.println("Elapsed time:"+Crono.print()+"s");
            }
          catch(IOException e){out.println(e.getMessage());}
           out.println("Deseja ver informação sobre o ficheiro lido? (S/N)");
           char rep= lerS.next().charAt(0);
           if(rep=='S'||rep=='s')
               out.println(info);
           break;}
           else{
          
           out.println("insira nome do ficheiro que quer carregar: 1)hipermercado 2) outro ");
            rp= lerI.nextInt();
            if(rp==1)
               {try{
                   Crono.start();
                   gest.CarregaObjeto("hipermercado");
                   out.println("Elapsed time:"+Crono.print()+"s");}
                catch(IOException e){out.println(e.getMessage());}
                catch(ClassNotFoundException e){out.println(e.getMessage());}
                
                }
             else {
                out.println("insira nome do ficheiro:");
                cdp2=lerS.next();
                
                try{
                     Crono.start();
                    gest.CarregaObjeto(cdp2);
                     out.println("Elapsed time:"+Crono.print()+"s");
                }
                catch(IOException e){out.println(e.getMessage());}
                catch(ClassNotFoundException e){out.println(e.getMessage());}
            }  
           break;
        }
           
           
           case(1):
            
            out.println("insira nome do ficheiro em que quer guardar: 1)hipermercado 2) outro ");
            rp= lerI.nextInt();
            if(rp==1)
               {try{
                   Crono.start();
                   gest.gravaObjeto("hipermercado");
                   out.println("Elapsed time:"+Crono.print()+"s");
                }
                catch(IOException e){out.println(e.getMessage());}
               
                
                }
             else {
                out.println("insira nome do ficheiro:");
                cdp2=lerS.next();
                
                try{
                     Crono.start();
                    gest.gravaObjeto(cdp2);
                  out.println("Elapsed time:"+Crono.print()+"s");}
                catch(IOException e){out.println(e.getMessage());}
                
            }  
          break;
           
           
          case (2):
           menuEstatistica(gest);
              break;
          case (3):    
           menuInterativo(gest);
            break;   
            
              
              default: break;
        
    }
    }while(cont!=11);
    
     out.println("------------------------------");
    }


public static void menuEstatistica(GestHiper gest)
{
Scanner lerI = new Scanner(System.in);
        Scanner lerS = new Scanner(System.in);
        int cont=0;
        int rp=0;
        String cdp2="";
        
        
        
    
    do{
   out.println("---------------------------------------------------------------------");
   out.println("1)Numero total de compras mensais");
   out.println("2)Faturação Mensal");
   out.println("3)Numero de clientes distintos que compraram em cada mês");
   out.println("4) Número total de compras invalidas");
   out.println("5)Sair do menu");
   
   out.println("---------------------------------------------------------------------");
   rp= lerI.nextInt();
   switch(rp){
    case(1):
     Crono.start();  
    for(cont=1;cont<13;cont++){
         out.println("\n..........Mes " + cont+"..........");
         out.println("Numero total de Compras:"+gest.getNumeroComprasMes(cont));}
      out.println("Elapsed time:"+Crono.print()+"s");
      break;
    case (2):
      double ft=0;
      Crono.start();  
      for(cont=1;cont<13;cont++){
          out.println("\n..........Mes " +cont+"..........");  
          out.println("Faturação Mensal:"+gest.faturacaoMes(cont));
          ft+=gest.faturacaoMes(cont);
         }
         out.println("\n\nFaturação Anual:"+ft);
          out.println("Elapsed time:"+Crono.print()+"s");
         break;
    case(3):
     Crono.start();   
     for(cont=1;cont<13;cont++){
          out.println("\n..........Mes " +cont+"..........");  
          out.println("Nº de clientes distintos:"+gest.QtdClientesCompraramMes(cont));
        }
      out.println("Elapsed time:"+Crono.print()+"s");
        break;
     case (4):
         out.println("Número total de compras invalidas:"+gest.getNumeroInvalidas());
         out.println("Deseja imprimir num ficheiro de texto as compras invalidas(S/N)?");
         String scn = lerS.next();
         if(scn.equals("S") || scn.equals("s")){
         out.println("insira nome: para o ficheiro");
         cdp2= lerS.next();
         try{Crono.start();   
             gest.GravaTxtInvalidas(cdp2);
            out.println("Elapsed time:"+Crono.print()+"s");
            }
         catch(IOException e){out.println(e.getMessage());}
         catch(Exception e){out.println("Erro alheio ao programa");
            
            }
        }
         
      
       break;
      
      default: break;
    }
   

}while(rp!=5);

}

public static void menuInterativo(GestHiper gest){
    Scanner lerI = new Scanner(System.in);
        Scanner lerS = new Scanner(System.in);
        int cont=0;
        int rp=0;
        String cdp2="";
      
    
      do{  
       out.println("1)Lista de códigos dos produtos nunca comprados e  total");
       out.println("2)Lista de códigos dos clientes que nunca compraram e total");
       out.println("3) Determinar o nº total de compras e o total de cliente distintos que as realizaram num determinado mes");
       out.println("4) Dado um código de cliente, determina,mensalmente, nº compras que fez,nº produtos distintos que  comprou, quanto gastou e total anual facturado");
       out.println("5) Dado o código de um produto existente, determinar, mês a mês, quantas vezes foi comprado, por quantos clientes diferentes e o total facturado;");
       out.println("6)Dado o código de um produto existente, determinar, mês a mês, quantas vezes foicomprado em modo N e em modo P e respectivas facturações;");
       out.println("7) Dado o código de um cliente determinar a lista de códigos de produtos que mais comprou (e quantos), ordenada por ordem decrescente de quantidade e, para quantidades iguais, por ordem alfabética dos códigos;");
       out.println("8) Determinar o conjunto dos X produtos mais vendidos em todo o ano (em número de unidades vendidas) indicando o número total de distintos clientes que o compraram");
       out.println("9)Determinar os X clientes que compraram um maior número de diferentes produtos, indicando quantos, sendo o critério de ordenação igual a 7;");
       out.println("10) Dado o código de um produto, determinar o conjunto dos X clientes que mais o compraram e qual o valor gasto (ordenação cf. 7);");
       
       out.println("11)Sair do Programa");
       
       cont=lerI.nextInt();
       
       switch(cont){
       
          
         
          case (1):
           Crono.start();
           
           ArrayList<String> gnc = new ArrayList<String>(gest.getNaoComprados()); 
           int w = gnc.size();
           int nprod =25;
           int npaginas = w/nprod;
           int ct =1;
           int pagina=-1;
           char c1;
           int es=0;
          
           
           out.println("\n nº de paginas: de 0 até"+npaginas+"\n nº de produtos:"+w);
           while(ct==1){
           
               out.println("Insira:\n1-Seguinte\n2-Anterior\n3-Pagina Especifica");
               es=lerI.nextInt();
               
               if(es==1){
                   pagina=pagina+1;
                   if(pagina<=npaginas && pagina>=0){
                    out.println("\n");
                    
                        for(int i=nprod*pagina;i<nprod*(pagina+1) && i<w; i++){
                            out.print(gnc.get(i)+"\n");
                        }
                    }
                    
                    else{
                    out.println("\ninsira uma pagina valida\n");
                    out.println("ir para outra pagina(S/N):");
                        c1=lerS.next().charAt(0);
                        if(c1=='N'||c1=='n'){ct=0;}
                        
                    }
               
            }
            
              if(es==2){
                   pagina=pagina-1;
                   if(pagina<=npaginas && pagina>=0){
                    out.println("\n");
                    
                        for(int i=nprod*pagina;i<nprod*(pagina+1) && i<w; i++){
                            out.print(gnc.get(i)+"\n");
                        }
                    }
                    
                    else{
                    out.println("\ninsira uma pagina valida\n");
                    out.println("ir para outra pagina(S/N):");
                        c1=lerS.next().charAt(0);
                        if(c1=='N'||c1=='n'){ct=0;}                        
                    }
               
            }

            if(es==3){
                   out.println("\nPara que pagina quer ir:\n");
                   pagina=lerI.nextInt();
                   if(pagina<=npaginas && pagina>=0){
                    out.println("\n");
                    
                        for(int i=nprod*pagina;i<nprod*(pagina+1) && i<w; i++){
                            out.println(gnc.get(i));
                        }
                    }
                    
                    else{
                    out.println("\ninsira uma pagina valida\n");
                    out.println("ir para outra pagina(S/N):");
                        c1=lerS.next().charAt(0);
                        if(c1=='N'||c1=='n'){ct=0;}
                        
                    }}
               
            
                }
            
               out.println("Elapsed time:"+Crono.print()+"s");
             break;
             
          case (2):    
            Crono.start();    
          for(String x: gest.getNaoCompraram())
                 out.println(x);
             out.println(" NºTotal:"+gest.getNaoCompraram().size());
             out.println("Elapsed time:"+Crono.print()+"s");
             break;   
            case (3):
                int m;    
                out.println("Insira um mês");
                m=lerI.nextInt();
                Crono.start();    
                out.println("Total de clientes diferentes:" + gest.QtdClientesCompraramMes(m));
                out.println("Nº total de compras:"+gest.getNumeroComprasMes(m));
                out.println("Elapsed time:"+Crono.print()+"s");
                break;
            
            case (4): 
              double tot=0;
              String cd="";
             
              out.println("Insira o codigo de  cliente");
              cd=lerS.next();
              TRIOcompfatuprod tr= new TRIOcompfatuprod() ;
              Crono.start();     
              for(int i=1;i<13;i++){
                out.println("..........Mes " + i+"..........");
                 try{
                      tr=gest.getInfoMesCliente(cd,i);
                }
                catch(ClienteNaoExiste e){out.println("Cliente Nao Existe");
                }
                
                out.println("Nº total de compras:" + tr.getNcomp());
                out.println("Total de produtos distintos:"+tr.getNprods());
                out.println("Faturação mensal:" + tr.getFat());
                tot+= tr.getFat();
            }
                    
                out.println("Faturação Anual" +tot);
               
               out.println("Elapsed time:"+Crono.print()+"s");
                break;
            case (5):
               
                String cdp1="";
                out.println("Insira o codigo de  produto");
                cdp1=lerS.next();
                Crono.start();    
                TRIOcompfatuprod tr2= new TRIOcompfatuprod();
               for(int i=1;i<13;i++){
                out.println("\n..........Mes " + i+"..........");
                try{
                tr2 = gest.getInfoMesProduto(cdp1,i);
                
                }
                catch (ProdutoNaoExiste e){
                    out.println("Produto Não Existe");
                }
                out.println("Nº total de compras:" + tr2.getNcomp());
                out.println("Total de clientes distintos:"+tr2.getNprods());
                out.println("Faturação mensal:" + tr2.getFat());
               
            }
           out.println("Elapsed time:"+Crono.print()+"s");
            break;
            case (6):
            
              cdp2="";
                out.println("Insira o codigo de  produto");
                cdp2=lerS.next();
               Crono.start();    
                Contabilidade x;
try{
               for(int i=1;i<13;i++){
                out.println("\n..........Mes " + i+"..........");
                x = gest.getContabilidadeMensal(cdp2,i);
                // Por em toString da Contabilidade?????? 
                out.println("Nº de Compras em modo N:" + x.getNcomp());
                out.println("Faturação em modo N:" + x.getFatuN());
                out.println("Nº de Compras em modo P:"+x.getPcomp());
                out.println("Faturação em modo P:" + x.getFatuP());
               
            
            }
        }
catch (ProdutoNaoExiste e){
out.println("Produto não existe");
}        
            out.println("Elapsed time:"+Crono.print()+"s");
            break;
           case (7):
              out.println("Insira o codigo de  cliente");
              cdp2=lerS.next();  
              Crono.start();    
              int i=0;
try{
              for(ParCodInt pr: gest.ProdutosMaisCompradosCliente(cdp2)){
                out.println(pr);
                i++;
                }
             out.println(" Nº de Produtos diferentes comprados:"+ i);
            }
catch (ClienteNaoExiste e){
    out.println("Cliente não existe");
}
            out.println("Elapsed time:"+Crono.print()+"s");
        
             break;
             
            case(8):
               out.println("Insira o nº de elementos que quer ver ");
               int tt=lerI.nextInt();
                    Crono.start(); 
              for(TrioCodIntInt c: gest.getProdutosMaisVendidos()){
                     if(tt<=0)break; 
                     out.println(c);
                      tt--;
                    }    
            
            out.println("Elapsed time:"+Crono.print()+"s");
                break;
            case(9): 
               out.println("Insira o nº de elementos que quer ver ");
               int t1=lerI.nextInt();
                    Crono.start(); 
              for(ParCodStrings c: gest.getOsMaioresCompradoress()){
                     if(t1<=0)break; 
                     out.println(c);
                      t1--;
                    }    
              out.println("Elapsed time:"+Crono.print()+"s");
                    break;
             
              case (10):
              out.println("Insira o codigo de  produto");
              cdp2=lerS.next();
              out.println("Insira o nº de elementos que quer ver ");
              rp= lerI.nextInt();
                  Crono.start(); 
    try{  
              for(TrioCodIntDouble c: gest.getMaisCompraramProduto(cdp2)){
                     if(rp<=0)break; 
                     out.println(c);
                      rp--;
                    }    
                }
catch(ProdutoNaoExiste e){
    out.println("Produto não existe");
}
              out.println("Elapsed time:"+Crono.print()+"s");
                    break;
              
              default: break;
        
    }
    }while(cont!=11);



}


}
