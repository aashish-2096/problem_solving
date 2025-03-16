class Solution {
    public:
        int rowMax, colMax;
        void floodFillRecur(vector<vector<int>>& image, vector<vector<int>>& status,
                            int srcRow, int srcCol, int color, int currentPixel) {
            if (srcRow >= rowMax || srcCol >= colMax || srcCol < 0 || srcRow < 0)
                return;
            if (image[srcRow][srcCol] != currentPixel)
                return;
            if (status[srcRow][srcCol] == 1)
                return;
            status[srcRow][srcCol] = 1;
            floodFillRecur(image, status, srcRow + 1, srcCol, color, currentPixel);
            floodFillRecur(image, status, srcRow - 1, srcCol, color, currentPixel);
            floodFillRecur(image, status, srcRow, srcCol + 1, color, currentPixel);
            floodFillRecur(image, status, srcRow, srcCol - 1, color, currentPixel);
            image[srcRow][srcCol] = color;
        }
        vector<vector<int>> floodFill(vector<vector<int>>& image, int srcRow,
                                      int srcCol, int color) {
            rowMax = image.size();
            colMax = image[0].size();
            if (srcRow >= rowMax || srcCol >= colMax)
                return image;
            vector<vector<int>> status(rowMax, vector<int>(colMax, 0));
            floodFillRecur(image, status, srcRow, srcCol, color,
                           image[srcRow][srcCol]);
            image[srcRow][srcCol] = color;
            return image;
        }
    };