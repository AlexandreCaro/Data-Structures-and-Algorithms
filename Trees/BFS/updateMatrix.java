class Solution {

    Queue<Point> queue = new LinkedList<Point>();

    Set<Point> seen = new HashSet<Point>();

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;

        int n = mat[0].length;

        int[][] distanceMat = new int[m][n];

        initializeQueue(mat);

        System.out.println("HERE");

        int distance = 0;

        int[][] neighbors = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!queue.isEmpty())
        {
            int currLength = queue.size();

            System.out.println("Length " + currLength);

            for(int i = 0; i < currLength; i++)
            {
                Point current = queue.remove();

                if(current.valid == 0)
                {
                    distanceMat[current.x][current.y] = 0;
                }
                else distanceMat[current.x][current.y] = distance;

                for(int[] neighbor: neighbors)
                {
                    int currRow = current.x + neighbor[0];
                    int currCol = current.y + neighbor[1];

                    if(isValid(currRow, currCol, mat))
                    {
                        Point node = new Point(currRow, currCol, mat[currRow][currCol]);

                        if(!seen.contains(node))
                        {
                            queue.add(node);
                            seen.add(node);
                        }
                    }
                }

                System.out.println("2 " + distance);

            }

            System.out.println("1 " + distance);

            distance++;
        }

    return distanceMat;
        
    }

    public boolean isValid(int row, int col, int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;

        return 0 <= row && row < m && 0 <= col && col < n;
    }

    public void initializeQueue(int[][] mat)
    {
        int m = mat.length;

        int n = mat[0].length;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(mat[i][j] == 0)
                {
                    System.out.println(i + " " + j);
                    Point curr = new Point(i, j, 0);
                    seen.add(curr);
                    queue.add(curr);
                }
            }
        }

        System.out.println("Over here");
    }
}

class Point
{
    int x;
    int y;
    int valid;

    Point(int x, int y, int valid)
    {
        this.x = x;
        this.y = y;
        this.valid = valid;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;

        if(o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        return x == point.x && y == point.y && valid == point.valid;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y, valid);
    }
}