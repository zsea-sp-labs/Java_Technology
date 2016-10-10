package com.zsea.javatech.lr4;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by truerall on 10/10/16.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonalInfo {
    String author();
    String date();
    int currentRevision() default 1;
    String lastModified() default "N/A";
    String lastModifiedBy() default "N/A";
    String[] reviewers();
}
