package Juego;

public class Pos {
	private int x;
	private int y;
	
	public Pos (int e, int i) {
		x=e;
		y=i;
	}
	
	public void actPosX(int n) {
		x+=n;
	}
	
	public void actPosY(int n) {
		y+=n;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
