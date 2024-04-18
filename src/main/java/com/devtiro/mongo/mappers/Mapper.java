package com.devtiro.mongo.mappers;

/**
 * Simple interface to define mapping from an object of one type (A) to another (B).
 */
public interface Mapper<A, B> {

    /**
     * Converts an object from type A to type B.
     */
    B mapTo(A a);

    /**
     * Converts an object from type B to type A.
     */
    A mapFrom(B b);

}
