import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;



public class ElementoIndice { 
		private long cep;
		private long indice;
		private long prox;
		public void escreve(DataOutput dout) throws IOException
		{
			dout.writeLong(this.cep);
			dout.writeLong(this.indice);
			dout.writeLong(this.prox);
		}
		public void le(DataInput din) throws IOException
		{
			this.cep = din.readLong();
			this.indice = din.readLong();
			this.prox = din.readLong();
		}
		
		public long getCep() {
			return cep;
		}
		public void setCep(long cep) {
			this.cep = cep;
		}
		public long getIndice() {
			return indice;
		}
		public void setIndice(long indice) {
			this.indice = indice;
		}
		public long getProx() {
			return prox;
		}
		public void setProx(long prox) {
			this.prox = prox;
		}
		
		public ElementoIndice mock(){
			this.cep = -1L;
			this.indice = -1L;
			this.prox = -1L;
			return this;
		}
}
