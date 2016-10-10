import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class Main2 { //leitura da lista encadeada
public static void main(String[] args) throws Exception {
			RandomAccessFile f = new RandomAccessFile("indice.dat","r");
			ElementoIndice ei = new ElementoIndice();
			long cep = 25520610L;
			
			long p = alocaHash(cep);
			f.seek(p * 24);
			
			ei.le(f);
			
			while (ei.getCep() != cep && ei.getProx() != -1L) {
				f.seek(ei.getProx());
				ei.le(f);
			}
			
			if (ei.getCep() == cep){
				System.out.println(ei.getIndice());
			}
			System.out.println("Compilacao finalizada.");
		}

		public static long alocaHash(long cep){
			return cep % 900001;
		}


}

