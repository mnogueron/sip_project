/**
 * Created by Matthieu on 12/12/2014.
 */
public class Grid {

    private char[][] _grid;
    private char[][] _gridSaved;
    private Model _model;
    private int _coordX, _coordY;

    public Grid(){
        init();
        displayGrid();
    }

    public void init(){
        this._grid = new char[22][10];
        this._gridSaved = new char[22][10];
        for(int i = 0; i<22; i++)
            for(int j = 0; j<10; j++){
                this._grid[i][j] = '0';
                this._gridSaved[i][j] = '0';
            }

    }

    public void displayGrid(){
        for(int i = 0; i<22; i++){
            for(int j = 0; j<10; j++){
                System.out.print("|"+(_grid[i][j]=(_grid[i][j] == '0')? ' ' : _grid[i][j]));
            }
            System.out.println("|");
        }
    }

    public void insertModel(){

        this._model = new Model();

        //TODO model 1 and 6 for rotation

        for(int i = 0; i<22; i++)
            for(int j = 0; j<10; j++)
                _gridSaved[i][j] = _grid[i][j];


        if(_model.getSize() == 2)
            _coordX = 4;
        else
            _coordX = 3;

        for(int i = 0; i<_model.getSize(); i++) {
            for (int j = 0; j < _model.getSize(); j++) {
                _grid[i][j + _coordX] = _model.getModel()[i][j];
            }
        }
        _coordY = _model.getSize()-1;
    }

    // TODO to test
    public boolean collision(){
        boolean out = (_coordY == 22);
        if(!out) {
            for (int j = 0; j < _model.getSize(); j++)
                out = out || ((_model.getModel()[_model.getSize() - 1][j] == _gridSaved[_coordY][j])
                        && (_model.getModel()[_model.getSize() - 1][j] == '+'));
        }
        return out;
    }

    public void step(){
        _coordY++;
        if(!collision()){
            for(int i = 0; i<22; i++)
                for(int j = 0; j<10; j++)
                    _grid[i][j] = _gridSaved[i][j];

            for(int i = 0; i<_model.getSize(); i++){
                if(_coordY-_model.getSize()+1+i >= 0) {
                    for (int j = 0; j < _model.getSize(); j++) {
                        _grid[_coordY - _model.getSize() + 1 + i][_coordX + j] = _model.getModel()[i][j];
                    }
                }
            }
        }
    }
}
