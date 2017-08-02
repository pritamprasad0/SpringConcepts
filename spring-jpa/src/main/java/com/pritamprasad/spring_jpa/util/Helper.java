package com.pritamprasad.spring_jpa.util;

import java.util.Collections;

public class Helper {
	
	public static <T> Iterable<T> emptyIfNull(Iterable<T> iterable) {
        return iterable == null ? Collections.<T> emptyList() : iterable;
    }

}
