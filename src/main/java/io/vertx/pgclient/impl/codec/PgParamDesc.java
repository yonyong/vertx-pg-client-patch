//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package io.vertx.pgclient.impl.codec;

import io.vertx.sqlclient.impl.ErrorMessageFactory;
import io.vertx.sqlclient.impl.ParamDesc;
import io.vertx.sqlclient.impl.TupleInternal;

import java.util.Arrays;

class PgParamDesc extends ParamDesc {
    private final DataType[] paramDataTypes;

    PgParamDesc(DataType[] paramDataTypes) {
        this.paramDataTypes = paramDataTypes;
    }

    DataType[] paramDataTypes() {
        return this.paramDataTypes;
    }

    public String prepare(TupleInternal values) {
        int numberOfParams = values.size();
        int paramDescLength = this.paramDataTypes.length;
        if (numberOfParams != paramDescLength) {
            return ErrorMessageFactory.buildWhenArgumentsLengthNotMatched(paramDescLength, numberOfParams);
        } else {
            for(int i = 0; i < paramDescLength; ++i) {
                DataType paramDataType = this.paramDataTypes[i];
                ParamExtractor<?> extractor = paramDataType.paramExtractor;

                Object val;
                try {
                    if (extractor != null) {
                        val = extractor.get(values, i);
                    } else {
                        val = values.get(paramDataType.encodingType, i);
                    }
                } catch (Exception var9) {
//                  return ErrorMessageFactory.buildWhenArgumentsTypeNotMatched(paramDataType.decodingType, i, values.getValue(i));
                  try {
                    paramDataType = DataType.VARCHAR;
                    extractor = paramDataType.paramExtractor;
                    if (extractor != null) {
                      val = extractor.get(values, i);
                    } else {
                      val = values.get(paramDataType.encodingType, i);
                    }
//                    this.paramDataTypes[i] = DataType.VARCHAR;
                  }catch (Exception var10){
                    return ErrorMessageFactory.buildWhenArgumentsTypeNotMatched(paramDataType.decodingType, i, values.getValue(i));
                  }
                }

                values.setValue(i, val);
            }

            return null;
        }
    }

    public String toString() {
        return "PgParamDesc{paramDataTypes=" + Arrays.toString(this.paramDataTypes) + '}';
    }
}
