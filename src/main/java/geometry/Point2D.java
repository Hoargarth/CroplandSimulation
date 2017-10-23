package geometry;

public class Point2D<T> {
    private T X;
    private T Y;

    public Point2D() {
    }

    public Point2D(T x, T y) {
        X = x;
        Y = y;
    }

    public T getX() {
        return X;
    }

    public void setX(T x) {
        X = x;
    }

    public T getY() {
        return Y;
    }

    public void setY(T y) {
        Y = y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point2D<?> point2D = (Point2D<?>) o;

        if (X != null ? !X.equals(point2D.X) : point2D.X != null) return false;
        return Y != null ? Y.equals(point2D.Y) : point2D.Y == null;
    }

    @Override
    public int hashCode() {
        int result = X != null ? X.hashCode() : 0;
        result = 31 * result + (Y != null ? Y.hashCode() : 0);
        return result;
    }
}
