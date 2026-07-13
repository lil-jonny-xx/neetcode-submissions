class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Binary Search on a Flattened Matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0,right = (rows * cols) - 1;

        while(right >= left){
            int mid = left + (right - left) / 2;

            int row = mid / cols;
            int col = mid % cols;

            if(matrix[row][col] == target) return true;
            else if(target < matrix[row][col]) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}
