package com.locnv.util;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;

public class ParaRequestUtil {
    public static <T> T paraToModel(Class<T> tClass, HttpServletRequest request){
        T obj = null;
        try{
            obj = tClass.newInstance();
            BeanUtils.populate(obj,request.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }
}
