import java.io.IOException;
import java.util.Random;

/**
 * Created by Matthieu on '+''0'/'+'2/2'0''+'4.
 */
public class Main {

    // grid size '+''0'*22 cells

    private static final int PAGE_SIZE = 22;

    static char[][] _grid;
    static char[][] _gridSaved = new char[22][10];
    static char[][] _model;
    static int _modelSize;
    static int _coordX, _coordY;

    static boolean _isPlaying;

    // TODO to test
    public static boolean collision(){
        boolean out = false;
        for(int j = 0; j<_modelSize; j++)
            out = out || ((_model[_modelSize-1][j] == _gridSaved[_coordY][j]) && (_model[_modelSize-1][j] == '+'));
        out = out || (_coordY == 22);
        return out;
    }

    // Done
    public static void rotate(){
        char[][] modelTemp = new char[_modelSize][_modelSize];

        /*for(int i = 0; i<_modelSize; i++) {
            for (int j = 0; j < _modelSize; j++) {
                System.out.print(" "+(_model[i][j]=(_model[i][j] == '0')? ' ' : _model[i][j]));
            }
            System.out.println();
        }*/

        for(int i = 0; i<_modelSize; i++)
            for(int j = 0; j<_modelSize; j++)
                modelTemp[_modelSize-1-j][i] = _model[i][j];

        for(int i = 0; i<_modelSize; i++)
            for(int j = 0; j<_modelSize; j++)
                _model[i][j] = modelTemp[i][j];

        /*for(int i = 0; i<_modelSize; i++) {
            for (int j = 0; j < _modelSize; j++) {
                System.out.print(" "+(modelTemp[i][j]=(modelTemp[i][j] == '0')? ' ' : modelTemp[i][j]));
            }
            System.out.println();
        }*/
    }

    // Done
    public static void getModel(int id){
        switch (id){
            case 1 :
                _model = new char[][]{
                        {'0','+','0','0'},
                        {'0','+','0','0'},
                        {'0','+','0','0'},
                        {'0','+','0','0'}
                };
                _modelSize = 4;
                break;
            case 2 :
                _model = new char[][]{
                        {'0','+','0'},
                        {'0','+','0'},
                        {'+','+','0'}
                };
                _modelSize = 3;
                break;
            case 3 :
                _model = new char[][]{
                        {'+','+','0'},
                        {'0','+','0'},
                        {'0','+','0'}
                };
                _modelSize = 3;
                break;
            case 4 :
                _model = new char[][]{
                        {'+','+'},
                        {'+','+'}
                };
                _modelSize = 2;
                break;
            case 5 :
                _model = new char[][]{
                        {'+','0','0'},
                        {'+','+','0'},
                        {'0','+','0'}
                };
                _modelSize = 3;
                break;
            case 6 :
                _model = new char[][]{
                        {'0','+','0'},
                        {'+','+','0'},
                        {'0','+','0'}
                };
                _modelSize = 3;
                break;
            case 7 :
                _model = new char[][]{
                        {'0','+','0'},
                        {'+','+','0'},
                        {'+','0','0'}
                };
                _modelSize = 3;
                break;
        }
    }

    // Done
    public static void init(){
        _grid = new char[22][10];
        for(int i = 0; i<22; i++)
            for(int j = 0; j<10; j++)
                _grid[i][j] = '0';
    }

    // Done
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
        getModel(rand);

        //TODO model 1 and 6 for rotation

        for(int i = 0; i<22; i++)
            for(int j = 0; j<10; j++)
                _gridSaved[i][j] = _grid[i][j];


        if(_modelSize == 2)
            _coordX = 4;
        else
            _coordX = 3;

        for(int i = 0; i<_modelSize; i++) {
            for (int j = 0; j < _modelSize; j++) {
                _grid[i][j + _coordX] = _model[i][j];
            }
        }
        _coordY = _modelSize-1;


        /*
        if(_modelSize == 4){
            for(int i = 3; i<7; i++)
                _grid[0][i] = _model[3][i-3];
            _coordX = 3;
            _coordY = 0;
        }else if(_modelSize == 2){
            for(int i = 0; i<2; i++)
                for(int j = 4; j<7; j++)
                    _grid[i][j] = _model[i][j-4];
            _coordX = 4;
            _coordY = 1;
        }else{
            for(int i = 2; i<4; i++)
                for(int j = 3; j<7; j++)
                    _grid[i-2][j] = _model[i][j-3];
            _coordX = 3;
            _coordY = 1;
        }*/
    }

    public static void step(){
        if(!collision()){
            _coordY++;
            for(int i = 0; i<22; i++)
                for(int j = 0; j<10; j++)
                    _grid[i][j] = _gridSaved[i][j];

            for(int i = 0; i<_modelSize; i++){
                if(_coordY-_modelSize+1+i >= 0) {
                    for (int j = 0; j < _modelSize; j++) {
                        _grid[_coordY - _modelSize + 1 + i][_coordX + j] = _model[i][j];
                    }
                }
            }
        }
    }

    public static void clearScreen() {
        for (int i = 0; i < PAGE_SIZE; i++) {
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //System.out.println("Hello world !");
        init();
        clearScreen();
        insertModel();
        displayGrid();

        Thread.sleep(1000);
        clearScreen();

        step();
        displayGrid();

        Thread.sleep(1000);
        clearScreen();

        step();
        displayGrid();

        Thread.sleep(1000);
        clearScreen();

        step();
        displayGrid();
        Thread.sleep(1000);
    }
}
