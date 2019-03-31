public class SudokuBox {

    public SudokuField [][] BoxOfSudokuFields = new SudokuField[3][3];

    void show(){
for(int i=0; i<3;i++)
{for(int j=0;j<3;j++){
    System.out.println(BoxOfSudokuFields[i][j].getFieldValue());
}}


        }


    void setBoxOfSudokuFields(int x,int y,SudokuField CopiedSudokuField)
    {
        BoxOfSudokuFields[y][x] = CopiedSudokuField;
    };


    boolean verify(){
return false;
    };


}
