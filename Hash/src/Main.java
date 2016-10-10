import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
 
public class Main {
 
	public static long alocaHash(long cep){
		return cep % 512;
	}
	
    public static void main(String[] args) throws Exception 
    {
    	System.out.println("Processando...");
        RandomAccessFile f = new RandomAccessFile("cep.dat", "r");
        int numeroRegistros = (int)(f.length() / 300);
        ArrayList<ElementoHash> ceps = new ArrayList<ElementoHash>(numeroRegistros);
 
        Endereco e = new Endereco();
       
        while( f.getFilePointer() < f.length() ) 
        {
        	ElementoHash eh = new ElementoHash();
            e.leEndereco(f);
            eh.setCep(Long.valueOf(e.getCep()));
            eh.setHashvalue(alocaHash(eh.getCep()));
            ceps.add(eh);
        }       
        f.close();
 
        System.out.println("Ordenando...");
        Collections.sort(ceps);
 
        System.out.println("Salvando hash.dat...");
        RandomAccessFile hashes = new RandomAccessFile("hash.dat", "rw");
        for(int i=0; i<ceps.size(); i++)
        {
            ceps.get(i).escreve(hashes);
        }
        hashes.close();
       
        System.out.println("Arquivo hash.dat criado com sucesso.");
    } 	
}