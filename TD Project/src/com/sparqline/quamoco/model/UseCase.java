/**
 * The MIT License (MIT)
 *
 * SparQLine Quamoco Implementation
 * Copyright (c) 2015-2017 Isaac Griffith, SparQLine Analytics, LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.sparqline.quamoco.model;

import javax.annotation.Nonnull;

/**
 * A use case describes an activity conducted with the system by a stakeholder.
 * If they are characterized by a factors, a Use Case-Factor results
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class UseCase extends Entity {

    /**
     * Constructs a new UseCase with the given name
     * 
     * @param name
     *            The name of the UseCase
     */
    public UseCase(String name)
    {
        super(name);
    }

    /**
     * Constructs a new UseCase with the given name
     * 
     * @param name
     *            The name of the UseCase
     * @param identifier
     *            The unique identifier
     */
    public UseCase(String name, String identifier)
    {
        super(name, identifier);
    }

    /**
     * Creates a new Builder for a Tag with the given simple name
     * 
     * @param name
     *            Simple Name
     * @return the UseCase.Builder instance.
     */
    public static Builder builder(String name)
    {
        return new Builder(name);
    }

    /**
     * Creates a new Builder for a Tag with the given simple name
     * 
     * @param name
     *            Simple Name
     * @Param identifer The unique identifier of the Product part to be created
     *        if it is already known.
     * @return the UseCase.Builder instance.
     */
    public static Builder builder(String name, String identifier)
    {
        return new Builder(name, identifier);
    }

    /**
     * Builder for UseCases implemented using the fluent interface
     * and
     * method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {

        /**
         * Tag element under construction
         */
        private UseCase element;

        /**
         * Constructs a new Builder for a UseCase with the given
         * name
         * 
         * @param name
         *            The name of the tag to construct
         */
        private Builder(String name)
        {
            element = new UseCase(name);
        }

        /**
         * Constructs a new Builder for a UseCase with the given
         * name
         * 
         * @param name
         *            The name of the tag to construct
         * @param identifier
         *            The unique identifier of this entity (if already known)
         */
        private Builder(String name, String identifier)
        {
            element = new UseCase(name, identifier);
        }

        /**
         * @return The newly constructed UseCase element
         */
        @Nonnull
        public UseCase create()
        {
            return element;
        }

        /**
         * Sets the element under construction's description
         * 
         * @param description
         *            the description to set
         * @return this
         */
        @Nonnull
        public Builder description(String description)
        {
            element.setDescription(description);

            return this;
        }

        /**
         * Sets the element under construction's originatesFrom
         * 
         * @param originatesFrom
         *            the originatesFrom to set
         * @return this
         */
        public Builder originatesFrom(Source originatesFrom)
        {
            element.addOriginatesFrom(originatesFrom);

            return this;
        }

        /**
         * Sets the element under contruction's tagged by
         * 
         * @param taggedBy
         *            the taggedBy to set
         * @return this
         */
        @Nonnull
        public Builder taggedBy(Tag taggedBy)
        {
            element.addTaggedBy(taggedBy);

            return this;
        }

        /**
         * Adds the given annotation to the element under construction.
         * 
         * @param ann
         *            Annotation to add
         * @return this
         */
        @Nonnull
        public Builder annotation(Annotation ann)
        {
            element.addAnnotation(ann);

            return this;
        }

        /**
         * Adds an entity to which this entity forms an IS-A relationship with.
         * 
         * @param entity
         *            Entity
         * @return this
         */
        @Nonnull
        public Builder isA(Entity entity)
        {
            element.addIsA(entity);

            return this;
        }

        /**
         * Sets the entity to which this entity is a part of
         * 
         * @param entity
         *            The Entity
         * @return this
         */
        @Nonnull
        public Builder partOf(Entity entity)
        {
            element.setPartOf(entity);

            return this;
        }
    }
}
