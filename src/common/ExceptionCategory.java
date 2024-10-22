package com.lumen.dssh.orchestrator.common;

import java.io.Serializable;

public class ExceptionCategory implements Serializable {

    private static final long serialVersionUID = 1001L;

    private String category;

    @SuppressWarnings("unused")
    private ExceptionCategory() {
        // Don't allow to create ExceptionCategory instance with out any parameters.
    }

    ExceptionCategory(String category) {
        this.category = category;
    }

    /**
     * Get the category.
     *
     * @return Returns the category.
     */
    public String getCategory() {
        return category;
    }

    public String toString() {
        return category;
    }

    public boolean equals(Object arg0) {
        if (arg0 instanceof ExceptionCategory) {
            ExceptionCategory tmpValue = (ExceptionCategory) arg0;
            return category.equals(tmpValue.category);
        }
        return false;
    }

    public int hashCode() {
        return category.hashCode();
    }
}
