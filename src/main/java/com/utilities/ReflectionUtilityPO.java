package com.utilities;

import com.annotations.ATFPage;
import com.annotations.ATFWebElement;
import com.exceptions.ATFRuntimeException;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Set;

import static org.reflections.scanners.Scanners.SubTypes;
import static org.reflections.scanners.Scanners.TypesAnnotated;

public class ReflectionUtilityPO {

    private static final String PO_PATH = "com.pageObjects";
    private static final Reflections reflections = new Reflections(PO_PATH);

    public static Object getPageObjectByBusinessName(String pageName) {
        Set<Class<?>> pageObjects =
                reflections.get(SubTypes.of(TypesAnnotated.with(ATFPage.class)).asClass());

        Class<?> pageObjectType = pageObjects.stream()
                                             .filter(clz -> clz.getAnnotation(ATFPage.class).pageName().equals(pageName))
                                             .findAny().orElseThrow(() -> new ATFRuntimeException(String.format("No page found with name: %s", pageName)));

        Object pageObject;
        try {
            pageObject = pageObjectType.getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
        return pageObject;
    }

    public static String getUriFromPO(Object pageObject) {
        return pageObject.getClass().getAnnotation(ATFPage.class).url();
    }

    public static <T> T getWebElementFromPO(String webElement, Object pageObject) {
        Field field = Arrays.stream(pageObject.getClass().getDeclaredFields())
                            .filter(fld -> fld.getAnnotation(ATFWebElement.class).elementName().equals(webElement))
                            .findFirst().orElseThrow(() -> new ATFRuntimeException(String.format("No webElement found with name: %s", webElement)));
        Object fieldValue;
        try {
            fieldValue = field.get(pageObject);
        } catch (IllegalAccessException e) {
            throw new ATFRuntimeException(e);
        }
        return (T) fieldValue;
    }
}
