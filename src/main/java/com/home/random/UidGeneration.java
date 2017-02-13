package com.home.random;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UidGeneration {

	public static void main(String[] args) {
		List<String> uidList = new ArrayList<>();
		for(int i=0; i < 10000; i++) {
			String uid = UUID.randomUUID().toString();
			uidList.add(uid);
			System.out.println(uid);
		}
		System.out.println("no duplication so far? "+ (uidList.stream().distinct().count() == 10000));
	}
}
