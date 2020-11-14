package spiral;

public class SpiralMatrix {

	private int n;
	private int m;

	public SpiralMatrix(int n, int m) {
		this.n = n;
		this.m = m;
	}
	public SpiralMatrix(int n) {
		this.m = this.n = n;
	}

	public int[][] calculate() {
		int[][] t = new int[n][m];
		build(t, 0, 0);
		return t;
	}

	private void build(int[][] t, int n, int m) {
		if (t[n][m] == 0) {
			int[] p = right(t, n, m);
			if (t.length > 1 && t[p[0] + 1][p[1]] == 0) {
				p = down(t, p[0] + 1, p[1]);
				p = left(t, p[0], p[1] - 1);
				if (t.length > 2) {
					p = up(t, p[0] - 1, p[1]);
					if (p[0] > 0 && p[0] < t[0].length - 1 && p[1] < t.length - 1) {
						if (t[p[0]][p[1]] == 0)
							build(t, p[0], p[1]);
					}
				}
			}
		}
	}

	private int[] up(int[][] t, int n, int m) {
		if (t[n][m] == 0) {
			t[n][m] = t[n + 1][m] + 1;
			return up(t, n - 1, m);
		} else
			return new int[] { n + 1, m + 1 };
	}

	private int[] left(int[][] t, int n, int m) {
		if (m >= 0 && t[n][m] == 0) {
			t[n][m] = t[n][m + 1] + 1;
			return left(t, n, m - 1);
		}
		return new int[] { n, m + 1 };
	}

	private int[] right(int[][] t, int n, int m) {
		if (n == 0 && m == 0) {
			t[0][0] = 1;
			return right(t, 0, 1);
		}
		if (m < this.m - 1) {
			if (m > 0 && t[n][m - 1] != 0) {
				t[n][m] = t[n][m - 1] + 1;
			} else if (n > 0)
				t[n][m] = t[n - 1][m] + 1;
			if (t[n][m + 1] == 0)
				return right(t, n, m + 1);
		}
		if (m == this.m - 1) {
			this.n--;
			t[n][m] = t[n][m - 1] + 1;
			return right(t, n, m + 1);
		}
		return new int[] { n, m - 1 };
	}

	private int[] down(int[][] t, int n, int m) {
		//if (t[n][m] != 0);
		if (n < this.n && t[n][m] == 0) {
			t[n][m] = t[n - 1][m] + 1;
			return down(t, n + 1, m);
		}
		t[n][m] = t[n - 1][m] + 1;
		this.m--;
		return new int[] { n, m };
	}

}
