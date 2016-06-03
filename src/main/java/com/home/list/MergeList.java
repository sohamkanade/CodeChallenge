package com.home.list;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class MergeList {

	public static void main(String[] args) {
		File path = new File("/Users/spark/workspace");
		List<String> remoteDependency = new ArrayList<>();
		remoteDependency.add("remote1");
		remoteDependency.add("remote2");
		List<String> dependencies = remoteDependency;
		dependencies.addAll(Arrays.asList(ArrayUtils.nullToEmpty(path.list())));
	}
}
