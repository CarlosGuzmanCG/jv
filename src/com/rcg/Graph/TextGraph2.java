package com.rcg.Graph;

public class TextGraph2 {
    private char canvas[][];

    public TextGraph2(int cols,int rows){
        canvas = new char[rows][cols];
        clear();
    }

    private void clear(){
        //System.out.println(canvas.length);
        //System.out.println();
        for(int r=0;r<canvas.length;r++){
            for(int c=0;c<canvas[r].length;c++){
                canvas[r][c] = ' ';
            }
        }
    }

    public void setCharAt(int col,int row,char value){
        if((col < 0)  || (col >= canvas[0].length) || (row < 0) || (row >= canvas.length))
            return;
        canvas[row][col]=value;
    }

    public void rectangle(int x,int y,int width,int height){
        for(int row=y;row<(y+height);row++){
            setCharAt(x, row, '|');
            setCharAt(x+width, row, '|');
        }

        for(int col=x;col<(x+width);col++){
            setCharAt(col, y, '-');
            setCharAt(col, y+height, '-');
        }

        setCharAt(x, y, '+');
        setCharAt(x+width, y, '+');
        setCharAt(x, y+height, '+');
        setCharAt(x+width, y+height, '+');

    }

    public void println(){
        for(int row=0;row<canvas.length;row++)
            System.out.println(canvas[row]);
        System.out.println();
    }

    public int getWidth(){
        return canvas[0].length;
    }

    public int getHeight(){
        return canvas.length;
    }

    public static void main(String[] args) {
        TextGraph2 graph = new TextGraph2(100, 15);
        /*graph.rectangle(10, 10, 15, 10);
        graph.rectangle(20, 5, 15, 10);*/
        graph.rectangle(0, 0, graph.getWidth()-1, graph.getHeight()-1);
        for(int x=0;x<graph.getWidth();x++){
            double value = Math.sin(Math.toRadians((2*360.0/graph.getWidth())*x));
            value=(value)*(graph.getHeight()/2-2);
            graph.setCharAt(x, (int)((graph.getHeight()/2)-value), '*');
        }
        graph.println();
    }
}