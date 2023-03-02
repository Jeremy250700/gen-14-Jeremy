/**
 * 
 */
package prodemy;
import prodemy.barang;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * @author Jeremy
 *
 */
public class create_file {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException{
		barang b1 = new barang ("Oreo",5000,10);
		barang b2 = new barang ("Tanggo",7000,12);
		barang b3 = new barang ("Aqua",3000,27);
		barang b4 = new barang ("Tim Tam",9000,5);
		
	    try {
	    	FileOutputStream daftar_barang_output = new FileOutputStream(new File("D:\\Aplikasi\\daftar_barang.txt"));
	    	ObjectOutputStream output= new ObjectOutputStream(daftar_barang_output);
	    	
	    	output.writeObject(b1);
	    	output.writeObject(b2);
	    	output.writeObject(b3);
	    	output.writeObject(b4);
	    	
	    
	    	FileInputStream daftar_barang_input = new FileInputStream(new File("D:\\Aplikasi\\daftar_barang.txt"));
			ObjectInputStream input = new ObjectInputStream(daftar_barang_input);
			
			barang b1_read = (barang) input.readObject();
			barang b2_read = (barang) input.readObject();
			barang b3_read = (barang) input.readObject();
			barang b4_read = (barang) input.readObject();
			
			System.out.println(b1_read.printBarang());
			System.out.println();
			System.out.println(b2_read.printBarang());
			System.out.println();
			System.out.println(b3_read.printBarang());
			System.out.println();
			System.out.println(b4_read.printBarang());
			System.out.println();
            
            
            output.close();
            input.close();
            
			
	    } catch (IOException e) {
	      System.out.println("Error");
	      e.printStackTrace();
	    }
	  }

}
