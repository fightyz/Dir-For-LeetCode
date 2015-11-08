/**
 * 构造一个二维数组将Zig后的造型填进去
 * 然后再横向遍历这个二维数组
 */

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        int numCols = 0;
        int len = s.length();
        
        int i = len / (numRows + numRows - 2);
        int j = len % (numRows + numRows - 2);
        
        numCols = (j / numRows == 0 ? 1 : j % numRows + 1) + i * (numRows - 1);
        
        char[][] matrix = new char[numRows][numCols];
        
        int indexCol = 0;
        int indexRow = 0;
        
        for (i = 0; i < len;) {
            
            for (indexRow = 0; indexRow < numRows & i < len; indexRow++, i++) {
                matrix[indexRow][indexCol] = s.charAt(i);
            }
            
            indexRow--;
            //indexCol++;
            
            for (;indexRow > 1 & i < len; i++) {
                indexRow--;
                indexCol++;
                matrix[indexRow][indexCol] = s.charAt(i);
            }
            indexCol++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < numRows; i++) {
            for (j = 0; j < numCols; j++) {
                if (matrix[i][j] != '\0') {
                    sb.append(matrix[i][j]);
                }
            }
        }
        return sb.toString();
    }
}