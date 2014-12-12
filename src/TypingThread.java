import java.util.Scanner;

/**
 * Created by Matthieu on 12/12/2014.
 */
public class TypingThread extends Thread{

    private String _string = "";

    public void run(){
        // keyboard reading
        Scanner s = new Scanner(System.in);
        _string = s.nextLine();
        /*try {
            _string = ""+(char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*BufferedReader in = new BufferedReader(new InputStreamReader( System.in ) );
        try {
            _string = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public String getString(){return this._string;}

}
