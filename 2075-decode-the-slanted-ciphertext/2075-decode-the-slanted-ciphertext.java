class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows == 1)
            return encodedText;
        int cols = encodedText.length() / rows;
        char[][] board = new char[rows][cols];
        for(int i=0; i<encodedText.length(); i++){
            int r = i / cols;
            board[r][i%cols] = encodedText.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<cols; j++){
            int c=j;
            for(int i=0; i<rows && c<cols; i++)
                sb.append(""+board[i][c++]);
        }
        return sb.toString().stripTrailing();
    }
}