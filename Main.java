import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static final String SEPARADOR =",";
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:/Users/Jose Buzani/Downloads/codigos_postales_hmoex.txt"));
            String line = br.readLine();
            HashMap<String,Integer> contador = new HashMap<>();
            while (line != null) {
                String[] cells = line.split(SEPARADOR);

                for (String s: cells){
                    String sevenChars = s.substring(1, Math.min(7, s.length()));
                    contador.put(sevenChars, contador.getOrDefault(sevenChars,0)+1);
                }
                line = br.readLine();
            }
            for (String s : contador.keySet()){
                int cantidad = contador.get(s);
                if (cantidad>1){
                    System.out.println("Codigo postal: "+ s +" Cantidad: " + cantidad);
                }
            }
        } finally {
            if (br != null){
                try{
                    br.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}