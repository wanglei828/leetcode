/*
Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.

The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.

Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

Example:
Given width = 3, height = 2, and food = [[1,2],[0,1]].

Snake snake = new Snake(width, height, food);

Initially the snake appears at position (0,0) and the food at (1,2).

|S| | |
| | |F|

snake.move("R"); -> Returns 0

| |S| |
| | |F|

snake.move("D"); -> Returns 0

| | | |
| |S|F|

snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

| |F| |
| |S|S|

snake.move("U"); -> Returns 1

| |F|S|
| | |S|

snake.move("L"); -> Returns 2 (Snake eats the second food)

| |S|S|
| | |S|

snake.move("U"); -> Returns -1 (Game over because snake collides with border)
*/

class Pair {
    int x;
    int y;
    public Pair(int i, int j) {x=i; y=j;}
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Pair)) return false;
        Pair tmp = (Pair)o;
        return tmp.x == this.x && tmp.y == this.y;
    }
}

public class SnakeGame {

    Queue<Pair> fQ = new LinkedList<Pair>();
    LinkedList<Pair> snake = new LinkedList<Pair>();
    int score = 0;
    int width = 0;
    int height = 0;
    int fx = -1;
    int fy = -1;
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        if(food != null && food.length != 0) {
            for(int i=0; i<food.length; i++) {
                fQ.add(new Pair(food[i][0], food[i][1]));
            }
        }

        snake.add(new Pair(0,0));
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        char c = direction.charAt(0);
        Pair newHead = null;
        Pair head = snake.peek();
        switch(c) {
            case 'U':
                if(head.x == 0) break;
                newHead = new Pair(head.x-1, head.y);
                break;
            case 'D':
                if(head.x == height-1) break;
                newHead = new Pair(head.x+1, head.y);
                break;
            case 'L':
                if(head.y == 0) break;
                newHead = new Pair(head.x, head.y-1);
                break;
            case 'R':
                if(head.y == width-1) break;
                newHead = new Pair(head.x, head.y+1);
                break;
        }
        if(newHead == null) return -1;
        if(fx == -1 && fy == -1) {
            while(!fQ.isEmpty()) {
                Pair f = fQ.poll();
                if(f.x >= 0 && f.x < height && f.y >= 0 && f.y < width) {
                    fx = f.x;
                    fy = f.y;
                    break;
                }
            }
        }
        if(newHead.x == fx && newHead.y == fy) {
            score++;
            fx = -1;
            fy = -1;
            snake.addFirst(newHead);
        } else {
            snake.pollLast();
            if(snake.contains(newHead)) return -1;
            snake.addFirst(newHead);
        }
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
