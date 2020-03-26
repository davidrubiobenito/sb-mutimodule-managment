package com.drbotro.common.converter;

public interface Converter<T, K>{

    K convert(T object);

}
