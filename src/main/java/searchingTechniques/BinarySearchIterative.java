package searchingTechniques;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BinarySearchIterative {

	static BufferedReader br;
	static BufferedWriter bw;

	static int n, query;
	static String[] str;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			n = Integer.parseInt(br.readLine());
			str = br.readLine().split(" ");
			query = Integer.parseInt(br.readLine());
			bw.write(String.valueOf(binarySearch(str, n, query)));
		} catch (Exception e) {
		} finally {
			br.close();
			bw.close();
		}
	}

	public static int binarySearch(String[] ar, int n, int query) {
		int l = 0, r = n, mid = -1;
		while (l < r) {
			mid = (l + r) / 2;
			int val = Integer.parseInt(ar[mid]);
			if (val == query)
				return mid;
			else if (val < query)
				l = mid + 1;
			else
				r = mid - 1;
		}
		return -1;
	}

}
