package org.msx.software.edu.system.business.util;

import org.msx.software.edu.system.business.exception.CommonException;
import org.msx.software.edu.system.business.common.codes.ExceptionMessageCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class GenericUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericUtil.class);
    private final static Map<Class<?>, Map<String, Method>> CLASS_METHOD_MAP = new HashMap<>();

    public static Object invokeMethodByClass(
            Class<?> clazz, Object enumElement, String methodName) throws CommonException {
        try {
            Method method;
            if (CLASS_METHOD_MAP.containsKey(clazz)) {
                Map<String, Method> methodMap = CLASS_METHOD_MAP.get(clazz);
                if (methodMap.containsKey(methodName)) {
                    method = methodMap.get(methodName);
                } else {
                    method = clazz.getDeclaredMethod(methodName);
                    methodMap.put(methodName, method);
                }
            } else {
                Map<String, Method> methodMap = new HashMap<>();
                method = clazz.getDeclaredMethod(methodName);
                methodMap.put(methodName, method);
                CLASS_METHOD_MAP.put(clazz, methodMap);
            }
            return method.invoke(enumElement);
        } catch (NoSuchMethodException ex) {
            throw new CommonException(ExceptionMessageCode.
                    PRS_NO_SUCH_METHOD_EXCEPTION, clazz.getSimpleName(), methodName);
        } catch (IllegalAccessException ex) {
            throw new CommonException(ExceptionMessageCode.
                    PRS_ILLEGAL_ACCESS_EXCEPTION, clazz.getSimpleName(), methodName);
        } catch (InvocationTargetException ex) {
            throw new CommonException(ExceptionMessageCode.
                    PRS_INVOCATION_TARGET_EXCEPTION, clazz.getSimpleName(), methodName);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new CommonException(ExceptionMessageCode.
                    PRS_INVOKE_ENUM_GENERAL_EXCEPTION, clazz.getSimpleName());
        }
    }
}
