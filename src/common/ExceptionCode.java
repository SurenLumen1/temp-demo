package com.lumen.dssh.orchestrator.common;

import java.io.Serializable;

public class ExceptionCode implements Serializable {

        private static final long serialVersionUID = 1001L;

        private String code;
        private String desc;
        private ExceptionCategory category;

        @SuppressWarnings("unused")
        private ExceptionCode() {
            // Don't allow to create ExceptionCode with out any parameters.
        }

        public ExceptionCode(String code, ExceptionCategory category) {
            this.code = code;
            this.desc = "";
            this.category = category;
        }

        public ExceptionCode(String code, String desc) {
            super();
            this.code = code;
            this.desc = desc;
        }
        public ExceptionCode(String code, String desc, ExceptionCategory category) {
            this.code = code;
            this.desc = desc;
            this.category = category;
        }

        /**
         * Get the code.
         *
         * @return Returns the code.
         */
        public String getCode() {
            return code;
        }

        public String toString() {
            return code;
        }

        public boolean equals(Object arg0) {
            if (arg0 instanceof ExceptionCode) {
                ExceptionCode tmpValue = (ExceptionCode) arg0;
                return code.equals(tmpValue.code);
            }
            return false;
        }

        public int hashCode() {
            return code.hashCode();
        }

        /**
         * Get desc.
         *
         * @return Returns the desc.
         */
        public String getDesc() {
            if (desc == null) {
                return "";
            }
            return desc;
        }

        /**
         * Get the category.
         *
         * @return Returns the category.
         */
        public ExceptionCategory getCategory() {
            return category;
        }

        /**
         * Sets the category.
         * <p>
         * Note: Should only be used by factory classes.
         *
         * @param category The value to set.
         */
        public void setCategory(ExceptionCategory category) {
            this.category = category;
        }
    }