import java.util.Random;

/**
 * Created by Matthieu on '+''0'/'+'2/2'0''+'4.
 */
public class Main {

    // grid size '+''0'*22 cells

    static char[][] _grid;
    static char[][] _gridSaved = new char[22][10];
    static char[][] _model;
    static int _coordX, _coordY;


    static boolean _isPlaying;


    public static char[][] getModel(int id){
        char [][] model = new char[4][4];
        switch (id){
            case 1 :
                model = new char[][]{
                        {'0','0','0','0'},
                        {'0','0','0','0'},
                        {'0','0','0','0'},
                        {'+','+','+','+'}
                };
                break;
            case 2 :
                model = new char[][]{
                        {'0','0','0','0'},
                        {'0','0','0','0'},
                        {'+','0','0','0'},
                        {'+','+','+','0'}
                };
                break;
            case 3 :
                model = new char[][]{
                        {'0','0','0','0'},
                        {'0','0','0','0'},
                        {'0','0','+','0'},
                        {'+','+','+','0'}
                };
                break;
            case 4 :
                model = new char[][]{
                        {'0','0','0','0'},
                        {'0','0','0','0'},
                        {'+','+','0','0'},
                        {'+','+','0','0'}
                };
                break;
            case 5 :
                model = new char[][]{
                        {'0','0','0','0'},
                        {'0','0','0','0'},
                        {'0','+','+','0'},
                        {'+','+','0','0'}
                };
                break;
            case 6 :
                model = new char[][]{
                        {'0','0','0','0'},
                        {'0','0','0','0'},
                        {'0','+','0','0'},
                        {'+','+','+','0'}
                };
                break;
            case 7 :
                model = new char[][]{
                        {'0','0','0','0'},
                        {'0','0','0','0'},
                        {'+','+','0','0'},
                        {'0','+','+','0'}
                };
                break;
        }
        return model;
    }

    public static void init(){
        _grid = new char[22][10];
        for(int i = 0; i<22; i++)
            for(int j = 0; j<10; j++)
                _grid[i][j] = '0';
    }

    public static void displayGrid(){
        for(int i = 0; i<22; i++){
            for(int j = 0; j<10; j++){
                System.out.print("|"+(_grid[i][j]=(_grid[i][j] == '0')? ' ' : _grid[i][j]));
            }
            System.out.println("|");
        }
    }

    public static void insertModel(){
        Random r = new java.util.Random();
        int rand = r.nextInt(7)+1;
        char [][]model = getModel(rand);
        _model = getModel(rand);

        for(int i = 0; i<22; i++)
            for(int j = 0; j<10; j++)
                _gridSaved[i][j] = _grid[i][j];

        if(rand == 1){
            for(int i = 3; i<7; i++)
                _grid[0][i] = model[3][i-3];
            _coordX = 3;
            _coordY = 0;
        }else if(rand == 4){
            for(int i = 2; i<4; i++)
                for(int j = 4; j<7; j++)
                    _grid[i-2][j] = model[i][j-4];
            _coordX = 4;
            _coordY = 1;
        }else{
            for(int i = 2; i<4; i++)
                for(int j = 3; j<7; j++)
                    _grid[i-2][j] = model[i][j-3];
            _coordX = 3;
            _coordY = 1;
        }
    }

    public static void step(){

        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                if(i - _coordY -4 == 0){
                    if (_grid[_coordY][j] != _gridSaved[_coordY][j]) {
                        if (_grid[_coordY + 1][j] != '+' && _gridSaved[_coordY + 1][j] != '+') {
                            _grid[_coordY+1][j] = _model[i][j];
                            _grid[_coordY][j] = '0';
                        }
                    }
                }else if(j - _coordY > 0){
                }
            }
        }
        _coordY++;
    }

    public char[][] placeModel(){}

    public static void main(String[] args) {
        //System.out.println("Hello world !");
        init();
        //displayGrid();
        insertModel();
        step();
        displayGrid();
    }
}
