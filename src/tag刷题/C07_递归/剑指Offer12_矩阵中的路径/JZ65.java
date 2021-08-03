package tag刷题.C07_递归.剑指Offer12_矩阵中的路径;

public class JZ65 {
    public boolean hasPath(char[][] matrix, String word) {
        char[] cs = word.toCharArray();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dfs(matrix, cs, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] matrix, char[] word, int i, int j, int index) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != word[index]) {
            return false;
        }
        if (index == word.length - 1) {
            return true;
        }
        matrix[i][j] = '\0';
        boolean res = dfs(matrix, word, i + 1, j, index + 1)
                || dfs(matrix, word, i - 1, j, index + 1)
                || dfs(matrix, word, i, j + 1, index + 1)
                || dfs(matrix, word, i, j - 1, index + 1);
        matrix[i][j] = word[index];
        return res;
    }
}
