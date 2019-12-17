package searchingTechniques;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BinarySearchRecursive {

	static BufferedReader br;
	static BufferedWriter bw;

	static int n, query;
	static String[] ar;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			n = Integer.parseInt(br.readLine());
			ar = br.readLine().split(" ");
			query = Integer.parseInt(br.readLine());
			bw.write(String.valueOf(binarySearchRecursive(ar, query, 0, n)));
			bw.newLine();
		} finally {
			br.close();
			bw.close();
		}
	}

	public static int binarySearchRecursive(String[] ar, int query, int l, int r) {
		int mid = (l + r) / 2;
		if (l < r) {
			int val = Integer.parseInt(ar[mid]);
			if (val == query)
				return mid;
			if (val < query)
				return binarySearchRecursive(ar, query, mid + 1, r);
			return binarySearchRecursive(ar, query, l, mid - 1);
		}
		return -1;
	}

}
