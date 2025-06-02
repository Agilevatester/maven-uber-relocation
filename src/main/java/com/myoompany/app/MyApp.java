package com.mycompany.app;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import java.util.ArrayList;
import java.util.List;

public class MyApp {
    public static void main(String[] args) {
        System.out.println("Starting application with Commons Collections usage...");

        List<String> originalList = new ArrayList<>();
        originalList.add("apple");
        originalList.add("banana");
        originalList.add("orange");
        originalList.add("grape");

        // Use CollectionUtils from commons-collections
        List<String> filteredList = (List<String>) CollectionUtils.select(originalList, new Predicate() {
            @Override
            public boolean evaluate(Object object) {
                return ((String) object).contains("a");
            }
        });

        System.out.println("Original List: " + originalList);
        System.out.println("Filtered List (contains 'a'): " + filteredList);

        // This is where you might add some code to verify the actual package at runtime
        // This is for demonstration only; you wouldn't typically do this in production
        try {
            Class<?> collectionUtilsClass = Class.forName("com.mycompany.app.shaded.collections.CollectionUtils");
            System.out.println("Shaded CollectionUtils class found at: " + collectionUtilsClass.getName());
        } catch (ClassNotFoundException e) {
            System.err.println("Shaded CollectionUtils class NOT found at expected relocated package.");
        }

        System.out.println("Application finished.");
    }
}