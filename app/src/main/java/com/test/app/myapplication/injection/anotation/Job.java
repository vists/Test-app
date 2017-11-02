package com.test.app.myapplication.injection.anotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Qualifier;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Vist on 09.09.2016.
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface Job {
}