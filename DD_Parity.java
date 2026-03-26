import java.util.*;

public class DD_Parity{
    public static void main(String[] args) {
        int rows=2, cols=3;
        int[][] sData={{1,1,1}, {0,0,0}};
        int[][] rData={{1,0,1}, {0,0,0}};
        int[][] sPar=genParMat(sData, rows, cols);
        int[][] rPar=genParMat(rData, rows, cols);

        printMat(sPar);
        printMat(rPar);
        int eR=-1,eC=-1;
        // rows
        for(int i=0; i<rows; i++){
            if(sPar[i][cols]!=rPar[i][cols])
                eR=i;
        }
        // cols
        for(int i=0; i<cols; i++){
            if(sPar[rows][i]!=rPar[rows][i])
                eC=i;
        }
        if(eR==-1){
            System.out.println("No Error");
        } else { 
            System.out.printf("[%d][%d]\n",eR,eC);
        }

    }
    static int[][] genParMat(int[][] mat, int r, int c){
        int[][] newMat= new int[r+1][c+1];
        for(int i=0;i<r;i++){
            for (int j = 0; j < c; j++) {
                newMat[i][j]=mat[i][j];
            }
        }
        // rows
        for (int i = 0; i < r; i++) {
            int sum=0;
            for (int j = 0; j < c; j++) {
                sum+=newMat[i][j];
            }
            newMat[i][c]=sum%2;
        }
        // cols
        for (int i = 0; i < c+1; i++) {
            int sum=0;
            for (int j = 0; j < r; j++) {
                sum+=newMat[j][i];
            }
            newMat[r][i]=sum%2;
        }

        return newMat;
    }
    static void printMat(int[][] mat){
    for (int i = 0; i < mat.length; i++) {
        for (int j = 0; j < mat[0].length; j++) {
            System.out.print(mat[i][j] + " ");
        }
        System.out.println();
    }
    System.out.println();
}
}