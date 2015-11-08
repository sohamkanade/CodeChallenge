package com.leetcode.questions;

import java.util.StringJoiner;

public class ChrunchifyLinkedList {

	private Node head;
	private int listCount;

	public ChrunchifyLinkedList() {
		head = new Node(null);
		listCount = 0;
	}

	public void add(Object data) {
		Node temp = new Node(data);
		Node current = head;

		while(current.getNext() != null) {
			current = current.getNext();
		}

		current.setNext(temp);
		listCount++;
	}

	public void add(Object data, int index) {
		Node temp = new Node(data);
		Node current = head;

		for(int i = 1; i < index && current.getNext() != null; i++) {
			current = current.getNext();
		}

		temp.setNext(current.getNext());
		current.setNext(temp);
		listCount++;
	}

	public Object get(int index) {
		if(index <=0) {
			return null;
		}

		Node current = head.getNext();
		for(int i = 1; i < index; i++) {
			if(current.getNext() == null) {
				return null;
			}
			current = current.getNext();
		}
		return current.getData();
	}

	public int size() {
		return listCount;
	}

	public boolean remove(int index) {
		if(index < 1 || index > size()) {
			return false;
		}

		Node current = head;
		for(int i = 1; i < index; i++) {
			if(current.getNext() == null) {
				return false;
			}
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		listCount--;
		return true;
	}

	public String toString() {
		Node current = head.getNext();
		StringJoiner sj = new StringJoiner(", ", "[", "]");
		while(current != null) {
			sj.add(current.getData().toString());
			current = current.getNext();
		}
		return sj.toString();
	}

	public static void main(String[] args) {
		ChrunchifyLinkedList linkedList = new ChrunchifyLinkedList();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);

		System.out.println("list - print linkedlist: " + linkedList);
		System.out.println("list.size() - print linkedlist size: " + linkedList.size());
		System.out.println("list.get(3) - get 3rd element: " + linkedList.get(3));
		System.out.println("list.remove(2) - remove 2nd element: " + linkedList.remove(2));
		System.out.println("list.get(3) - get 3rd element: " + linkedList.get(3));
		System.out.println("list.size() - print linkedlist size: " + linkedList.size());
		System.out.println("list - print linkedlist: " + linkedList);
	}
}
