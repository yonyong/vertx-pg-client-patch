package io.vertx.pgclient.impl.codec;

import io.netty.buffer.ByteBuf;
import io.vertx.sqlclient.impl.TupleInternal;

import java.lang.reflect.Array;

/**
 * @author yonyong
 * @date 2024-06-06
 * modify record see:
 * 1. {@link DataTypeCodec#encodeBinary(DataType, Object, ByteBuf)}
 * 2. {@link DataTypeCodec#textEncode(DataType, Object, ByteBuf)}
 * 3. {@link PgParamDesc#prepare(TupleInternal)}
 */
public class ArrayCastHelper {
    public static <T> T[] convert(Object[] array, Class<T> type) {
        if (array == null) {
            return null;
        }

        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(type, array.length);

        for (int i = 0; i < array.length; i++) {
            result[i] = type.cast(array[i]);
        }

        return result;
    }
}
