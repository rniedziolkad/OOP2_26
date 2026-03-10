public class Segment {
    public Point a, b;

    public double length() {
        double dx = b.x - a.x;
        double dy = b.y - a.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    @Override
    public String toString() {
        return "Segment{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public String toSvg() {
        return "<line x1=\"" + a.x + "\" y1=\""+ a.y + "\"" +
                " x2=\"" + b.x + "\" y2=\"" + b.y + "\"" +
                " style=\"stroke:red;stroke-width:2\" />";
    }

    public static Segment maxLength(Segment[] segments) {
        if(segments == null || segments.length == 0) return null;

        Segment max = segments[0];
        for(int i = 1; i < segments.length; i++) {
            Segment seg = segments[i];
            if(seg == null) continue;

            if(seg.length() > max.length())
                max = seg;
        }

        return max;
    }
}
