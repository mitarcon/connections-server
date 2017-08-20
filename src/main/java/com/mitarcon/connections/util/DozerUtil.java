package com.mitarcon.connections.util;

import java.util.Collection;
import java.util.HashSet;

import org.dozer.DozerBeanMapper;

public class DozerUtil {

	public static <T, U> Collection<U> mapCollection(final DozerBeanMapper mapper, final Collection<T> source, final Class<U> destType) {

	    final Collection<U> dest = new HashSet<U>();

	    for (T element : source) {
	    	dest.add(mapper.map(element, destType));
	    }

	    return dest;
	}
}
