class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list = new ArrayList<>();
        int frow = 0;
        int fcol = 0;
        int lrow = matrix.length-1;
        int lcol = matrix[0].length-1;

        while (frow <= lrow && fcol <= lcol) {

    for (int i = fcol; i <= lcol; i++) {
        list.add(matrix[frow][i]);
    }

    for (int i = frow + 1; i <= lrow; i++) {
        list.add(matrix[i][lcol]);
    }

    if (frow < lrow) {
        for (int i = lcol - 1; i >= fcol; i--) {
            list.add(matrix[lrow][i]);
        }
    }

    if (fcol < lcol) {
        for (int i = lrow - 1; i > frow; i--) {
            list.add(matrix[i][fcol]);
        }
    }

    frow++;
    fcol++;
    lrow--;
    lcol--;
}
    return list;
    }
}