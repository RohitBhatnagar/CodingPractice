package linkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LinkedListImpl {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static Node head;
	static Node tail = head;

	public static void insertBeforeHead(int data) {
		if (head == null) {
			head = new Node(data);
			tail = head;
			return;
		}
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public static void insertAfterHead(int data) {
		if (head == null) {
			head = new Node(data);
			tail = head;
			return;
		}
		Node newNode = new Node(data);
		tail.next = newNode;
		tail = newNode;
	}

	public static void insertAtIndex(int data, int index) {
		Node newNode = new Node(data);
		Node temp = head;
		int i = 0;
		if (temp == null) {
			head = newNode;
			tail = head;
			return;
		}
		if(index == 0) {
			newNode.next = temp;
			head = newNode;
			return;
		}
		while (i < index - 1 && temp != null) {
			temp = temp.next;
			i++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}

	public static String printList() {
		StringBuilder sb = new StringBuilder();
		Node temp = head;
		while (temp != null) {
			sb.append(temp.data + ", ");
			temp = temp.next;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		String[] ar;
		try {
			n = Integer.parseInt(br.readLine());
			ar = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				int val = Integer.parseInt(ar[i]);
				insertBeforeHead(val);
			}
			insertAfterHead(56);
			insertAtIndex(299, 5);
			System.out.println(printList());
		} catch (Exception e) {
			System.out.println("Error logged");
		}
	}

}
