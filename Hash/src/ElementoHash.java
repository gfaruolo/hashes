import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ElementoHash implements Comparable<ElementoHash>{
	private long cep;
	private long hashvalue;
	public long getCep() {
		return cep;
	}
	public void setCep(long cep) {
		this.cep = cep;
	}
	public long getHashvalue() {
		return hashvalue;
	}
	public void setHashvalue(long hashvalue) {
		this.hashvalue = hashvalue;
	}

	public int compareTo(ElementoHash outro) {
		if(this.cep == outro.cep)
		{
			return 0;
		}
		if(this.cep > outro.cep)
		{
			return 1;
		}
		return -1;
	}
	public void escreve(DataOutput dout) throws IOException
	{
		dout.writeLong(this.cep);
		dout.writeLong(this.hashvalue);
	}
	public void le(DataInput din) throws IOException
	{
		this.cep = din.readLong();
		this.hashvalue = din.readLong();
	}

}
