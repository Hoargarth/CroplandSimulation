package geometry;

public class Point3D<T> extends Point2D<T> {
    private T z;

    public Point3D() {
    }

    public Point3D(T x, T y) {
        super(x, y);
    }

    public Point3D(T x, T y, T z) {
        super(x, y);
        this.z = z;
    }

    public T getZ() {
        return z;
    }

    public void setZ(T z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point3D)) return false;
        if (!super.equals(o)) return false;

        Point3D<?> point3D = (Point3D<?>) o;

        return z != null ? z.equals(point3D.z) : point3D.z == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (z != null ? z.hashCode() : 0);
        return result;
    }
}
