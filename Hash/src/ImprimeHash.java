
import java.io.RandomAccessFile;
import java.util.ArrayList;
 
public class ImprimeHash {
 
    public static void main(String[] args) throws Exception 
    {
       
        RandomAccessFile hashes = new RandomAccessFile("hash.dat", "r");
        ArrayList<Long> hashesLidos = new ArrayList<Long>();
        int colisao = 0;
        ElementoHash eh = new ElementoHash();
         
        while( hashes.getFilePointer() < hashes.length() ) 
        {
            eh.le(hashes);
            System.out.println(eh.getCep() + " " + eh.getHashvalue());
            if(hashesLidos.contains((Long) eh.getHashvalue())){
            	colisao++;
            }
            else{
            	hashesLidos.add(eh.getHashvalue());
            }
       }
        System.out.println("Colisões encontradas: " + colisao); 
        hashes.close();
    }
 
}