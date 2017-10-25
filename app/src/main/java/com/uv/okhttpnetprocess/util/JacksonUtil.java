package com.uv.okhttpnetprocess.util;

import android.text.TextUtils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JacksonUtil {

    private static JacksonUtil instance;
    private ObjectMapper objectMapper;

    public JacksonUtil() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        // 忽略不需要的字段
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }



    public static JacksonUtil getInstance() {
        if (instance == null)
            instance = new JacksonUtil();
        return instance;
    }

    /**
     * 读取 json string 转为 List
     */
    public List readValue(String paramString, JavaType javaType) {

        List<Object> objList = null;

        try {

            objList = objectMapper.readValue(paramString, javaType);

        } catch (Exception localException) {
            localException.getMessage();
            localException.printStackTrace();
        }

        return objList;
    }


    public synchronized <T> T readValue(String paramString, Class<T> paramClass) {
        T localObject1 = null;
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
            return null;
        }
        try {
            localObject1 = this.objectMapper.readValue(paramString, paramClass);

        } catch (JsonParseException localJsonParseException) {
            localJsonParseException.getMessage();
        } catch (JsonMappingException localJsonMappingException) {
            localJsonMappingException.getMessage();
        } catch (IOException localIOException) {
            localIOException.getMessage();
        } catch (Exception localException) {
            localException.getMessage();
        }
        return localObject1;
    }


    public synchronized String writeValueAsString(Object paramObject) {
        if (paramObject == null) {
            return null;
        }
        String result = null;
        try {
            result = objectMapper.writeValueAsString(paramObject);

        } catch (JsonGenerationException localJsonParseException) {
            localJsonParseException.getMessage();
        } catch (JsonMappingException localJsonMappingException) {
            localJsonMappingException.getMessage();
        } catch (IOException localIOException) {
            localIOException.getMessage();
        } catch (Exception localException) {
            localException.getMessage();
        }

        return result;
    }

    /**
     * 获取子节点 json 字符串
     */
    public synchronized String readTree(String jsonString, String nodeKey) {

        try {
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            JsonNode node = jsonNode.get(nodeKey);
            if (null != node) {
                return node.toString();
            }

            return null;

        } catch (Exception localException) {
            localException.getMessage();
            localException.printStackTrace();
        }

        return null;
    }

    /**
    * jsonString -> List<Mode>
    */
    public synchronized Object readValue(String jsonString, Class<?> parametrized, Class... parameterClasses){

        Object obj  = null;

        try {
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
            obj = objectMapper.readValue(jsonString, javaType);

        } catch (Exception localException) {
            localException.getMessage();
            localException.printStackTrace();
        }

        return obj;

    }
}
