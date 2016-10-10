import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Main { //criacao do indice/lista encadeada 
		public static void main(String[] args) throws Exception  {
			RandomAccessFile f = new RandomAccessFile("cep.dat", "r");
			RandomAccessFile f2 = new RandomAccessFile("indice.dat", "rw");
			Endereco e = new Endereco();
			long p;
			ElementoIndice ei = new ElementoIndice();
			
			long ii = 0;
			
			for(int i = 0; i<= 900001;i++){
				
				ei.escreve(f2);
			}
			
			while( f.getFilePointer() < f.length() ) 
	        {
	            e.leEndereco(f);
	            p = alocaHash(ei.getCep()); 
	            f2.seek(p*24);
	            ei.le(f2);
	          
	            if(ei.getCep() == -1){
	            	ei.setCep(Long.parseLong(e.getCep()));
	            	ei.setIndice(ii);
	            	ei.setProx(-1L);
	            	ei.escreve(f2);
	            }else{
	            	long prox = ei.getProx();
	            	ei.setProx(f2.length());
	            	f2.seek(p* 24); //seek pra voltar
	            	ei.escreve(f2);
	            	f2.seek(f2.length()); //seek tamanho do arquivo
	            	ei.setCep(Long.parseLong(e.getCep()));
	            	ei.setIndice(ii);
	            	ei.setProx(prox);
	            	ei.escreve(f2);
	            	
	            }
	            ii++;
	        }        
			
			
			f.close();
	        f2.close();
	        System.out.println("Compilacao finalizada.");
		}

		public static long alocaHash(long cep){
			return cep % 900001;
		}
		

}
