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
 * Indicates that the measure should aggregate incoming value sets using
 * histogram comparison
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class NumberHistogramCompMeasureAggregation extends FormBasedMeasureAggregation {

    /**
     * 
     */
    public NumberHistogramCompMeasureAggregation()
    {
        super();
    }

    /**
     * @param identifier
     */
    public NumberHistogramCompMeasureAggregation(String identifier)
    {
        super(identifier);
    }

    /**
     * Creates a new Builder for a NumberHistogramCompMeasureAggregation
     * 
     * @return the NumberHistogramCompMeasureAggregation.Builder instance
     */
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Creates a new Builder for a NumberHistogramCompMeasureAggregation with the
     * given unique identifier
     * 
     * @param identifier
     *            The unique identifier
     * @return the NumberHistogramCompMeasureAggregation.Builder instance
     */
    public static Builder builder(String identifier)
    {
        return new Builder(identifier);
    }

    /**
     * Builder for NumberHistogramCompMeasureAggregations implemented using the fluent
     * interface and method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {

        /**
         * NumberHistogramCompMeasureAggregation element under construction
         */
        private NumberHistogramCompMeasureAggregation element;

        /**
         * Constructs a new Builder for a NumberHistogramCompMeasureAggregation
         */
        private Builder()
        {
            element = new NumberHistogramCompMeasureAggregation();
        }

        /**
         * Constructs a new Builder for a NumberHistogramCompMeasureAggregation with
         * the given unique identifier
         * 
         * @param name
         *            The unique identifier
         */
        private Builder(String identifier)
        {
            element = new NumberHistogramCompMeasureAggregation(identifier);
        }

        /**
         * @return The newly constructed NumberHistogramCompMeasureAggregation element
         */
        @Nonnull
        public NumberHistogramCompMeasureAggregation create()
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
         * Sets the optional title of the NumberHistogramCompMeasureAggregation under
         * construction
         * 
         * @param title
         *            Title of the NumberHistogramCompMeasureAggregation
         * @return this
         */
        @Nonnull
        public Builder title(String title)
        {
            element.setTitle(title);

            return this;
        }

        /**
         * Adds a measure for aggregation to the
         * NumberHistogramCompMeasureAggregation
         * 
         * @param measure
         *            The measure to add to the list of aggregates for the
         *            NumberHistogramCompMeasureAggregation under construction.
         * @return this
         */
        @Nonnull
        public Builder aggregates(Measure measure)
        {
            element.addAggregate(measure);

            return this;
        }
    }
}
