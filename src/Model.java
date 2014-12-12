import java.util.Random;

/**
 * Created by Matthieu on 12/12/2014.
 */
public class Model {

    private int _size;
    private char[][] _model;

    public Model(){
        Random r = new java.util.Random();
        int rand = r.nextInt(7)+1;
        createModel(rand);
        rand = r.nextInt(3);
        for(int i = 0; i<rand; i++)
            rotate();
    }

    public void rotate(){
        char[][] modelTemp = new char[this._size][this._size];

        for(int i = 0; i<this._size; i++)
            for(int j = 0; j<this._size; j++)
                modelTemp[this._size-1-j][i] = this._model[i][j];

        for(int i = 0; i<this._size; i++)
            for(int j = 0; j<this._size; j++)
                this._model[i][j] = modelTemp[i][j];
    }

    /**
     * Create a model depending on the id sent.
     * @param id model id.
     */
    public void createModel(int id){
        switch (id){
            case 1 :
                this._model = new char[][]{
                        {'0','+','0','0'},
                        {'0','+','0','0'},
                        {'0','+','0','0'},
                        {'0','+','0','0'}
                };
                this._size = 4;
                break;
            case 2 :
                this._model = new char[][]{
                        {'0','+','0'},
                        {'0','+','0'},
                        {'+','+','0'}
                };
                this._size = 3;
                break;
            case 3 :
                this._model = new char[][]{
                        {'+','+','0'},
                        {'0','+','0'},
                        {'0','+','0'}
                };
                this._size = 3;
                break;
            case 4 :
                this._model = new char[][]{
                        {'+','+'},
                        {'+','+'}
                };
                this._size = 2;
                break;
            case 5 :
                this._model = new char[][]{
                        {'+','0','0'},
                        {'+','+','0'},
                        {'0','+','0'}
                };
                this._size = 3;
                break;
            case 6 :
                this._model = new char[][]{
                        {'0','+','0'},
                        {'+','+','0'},
                        {'0','+','0'}
                };
                this._size = 3;
                break;
            case 7 :
                this._model = new char[][]{
                        {'0','+','0'},
                        {'+','+','0'},
                        {'+','0','0'}
                };
                this._size = 3;
                break;
        }
    }


    /**
     * Get the size of the model.
     * @return a size between 2 and 4.
     */
    public int getSize(){return this._size;}

    /**
     * Get the model.
     * @return a model.
     */
    public char[][] getModel(){return this._model;}
}
