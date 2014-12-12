import java.io.IOException;

/**
 * Created by Matthieu on 12/12/2014.
 */
public class Game {

    private final int PAGE_SIZE = 22;

    private Grid _grid;
    static boolean _isPlaying;

    public Game(){
        _grid = new Grid();
    }

    public void play() throws InterruptedException, IOException {
        /**
         *  Jeux :
         *      - On insère une pièce
         *      - on affiche la grille
         *      - le joueur peut commencer à jouer
         *          - récupération des entrées clavier
         *          - analyse des entrées
         *          - à chaque tic d'horloge (1s) le model descend
         *      - on fait descendre la pièce tant qu'elle n'est pas arrivée en bas
         */

        _isPlaying = true;
        clearScreen();
        while(_isPlaying){
            _grid.displayGrid();
            _grid.insertModel();
            while(!_grid.collision()) {
                //Thread.sleep(1000);
                clearScreen();
                // TODO
                _grid.step();
                _grid.displayGrid();

                TypingThread thread = new TypingThread();
                // démarrer le thread où tu attends l'entrée au clavier
                thread.start();
                // attendre 5 secondes max après le thread
                thread.sleep(1000);
                if(!thread.getString().equals(""))
                    System.out.print("Char : " + thread.getString());
                thread.interrupt();
                // continuer qprès la saisie ou le timeout...

                // readKeyboardInput();
            }
            _isPlaying = false;
        }
    }

    public void clearScreen() {
        for (int i = 0; i < PAGE_SIZE; i++) {
            System.out.println();
        }
    }
}
