package mountain;

public class Side {
	private Point p1, p2, m;
	
	public Side(Point p1, Point p2, Point m) {
		this.p1 = p1;
		this.p2 = p2;
		this.m = m;
	}
	
	public Point getP1() {
		return p1;
	}
	
	public Point getP2() {
		return p2;
	}
	
	public Point getMid() {
		return m;
	}
	
	public boolean equals(Side other) {
		if((other.getP1().equals(p1) && other.getP2().equals(p2)) || (other.getP2().equals(p1) && other.getP1().equals(p2)))
			return true;
		return false;
	}
}