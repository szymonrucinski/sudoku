package pl.comprog;

public class LevelDifficulty {
    public SudokuBoard selectLevel(SudokuBoard sudoku,int level){
        int amount=20*level;
        switch(level){
            case 4: sudoku=LoadSave(sudoku);
            case 1: RemoveRandomNumbers(amount,sudoku);
            case 2: RemoveRandomNumbers(amount,sudoku);
            case 0: RemoveRandomNumbers(amount,sudoku);
        }
        return sudoku;
    }

    private SudokuBoard RemoveRandomNumbers(int amount,SudokuBoard sudoku){
        int number=0;
        if(amount ==0) amount=10;
        int allfields=81;
        allfields=allfields/amount;


        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                number++;
                if(number%allfields==0){
                    sudoku.set(i,j,0);
                }
            }

        }
        return  sudoku;

    }

    private SudokuBoard LoadSave(SudokuBoard sudoku){
        System.out.println("LOAD SAVE");
        sudoku.display();
        return  sudoku;
    }


}
