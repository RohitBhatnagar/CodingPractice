package linkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class SortingAbsoluteValues {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		String[] ar;
		LinkedList<Integer> list = new LinkedList<>();
		try {
			n = Integer.parseInt(br.readLine());
			ar = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				int val = Integer.parseInt(ar[i]);
				if (list.isEmpty())
					list.add(val);
				else if (list.peek() < val)
					list.add(val);
				else
					list.addFirst(val);
			}
			bw.write(list.toString());
			br.close();
			bw.close();
		} catch (IOException e) {
			System.out.println("Exception logged");
		}
	}

}
