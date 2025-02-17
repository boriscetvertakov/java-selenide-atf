package com.utilities;

import com.annotations.ATFPage;
import org.reflections.Reflections;

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
                                             .findAny().orElseThrow(() -> new RuntimeException("No page found"));

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

}
