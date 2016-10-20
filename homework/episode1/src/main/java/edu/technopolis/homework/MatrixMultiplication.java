package main.java.edu.technopolis.homework;


/**
 * Matrix multiplication home task.
 * <br/>
 * Matrix dimension and elements are passed as CLI arguments.
 */
public class MatrixMultiplication {

    private static int FillMatrix(int Matrix[][], int k, String... args){
        int strings=Matrix.length;
        int columns=Matrix[0].length;
        for(int i=0;i<strings;i++){
            for(int j=0;j<columns;j++){
                Matrix[i][j]=Integer.parseInt(args[k++]);
            }
        }
        return k;
    }

    private static void Multiply(int A[][], int B[][]){
        int stringsA=A.length;
        int columnsA=A[0].length;
        int stringsB=B.length;
        int columnsB=B[0].length;
        int C[][]=new int [stringsA][columnsB];
        for(int i=0;i<stringsA;i++){
            for(int j=0;j<columnsB;j++){
                C[i][j]=0;
                for(int k=0;k<columnsA;k++){
                    C[i][j]+=A[i][k]*B[k][j];
                }
                System.out.print(C[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String... args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        int X = Integer.parseInt(args[2]);
        int Y = Integer.parseInt(args[3]);
        if(M!=X){
            System.out.println("Error. The number of columns in A does not match the number of strings in B.");
        } else {
            int A[][]=new int[N][M];
            int B[][]=new int[X][Y];
            int k=4;
            //fill A
            k=FillMatrix(A,k,args);
            //fill B
            FillMatrix(B,k,args);
            //multiply A*B
            Multiply(A,B);

        }

    }
}
