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
 * Indicates that the factor should aggregate incoming factors using
 * the median operator
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class MedianFactorAggregation extends FactorAggregation {

    /**
     * 
     */
    public MedianFactorAggregation()
    {
        super();
    }

    public MedianFactorAggregation(String identifier)
    {
        super(identifier);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double evaluate()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Creates a new Builder for a MedianFactorAggregation with the given
     * unique identifier
     * 
     * @param identifier
     *            Unique identifier
     * @return the MedianFactorAggregation.Builder instance
     */
    public static Builder builder(String identifier)
    {
        return new Builder(identifier);
    }

    /**
     * Builder for MedianFactorAggregations implemented using the fluent
     * interface and method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {

        /**
         * MedianFactorAggregation element under construction
         */
        private MedianFactorAggregation element;

        /**
         * Constructs a new Builder for a MedianFactorAggregation
         */
        private Builder()
        {
            element = new MedianFactorAggregation();
        }

        /**
         * Constructs a new Builder for a MedianFactorAggregation with the
         * given
         * identifier
         * 
         * @param identifier
         *            The identifier of the tool to construct
         */
        private Builder(String identifier)
        {
            element = new MedianFactorAggregation(identifier);
        }

        /**
         * @return The newly constructed MedianFactorAggregation element
         */
        @Nonnull
        public MedianFactorAggregation create()
        {
            return (MedianFactorAggregation) element;
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
         * Sets the optional title of the MedianFactorAggregation under
         * construction
         * 
         * @param title
         *            Title of the MedianFactorAggregation
         * @return this
         */
        @Nonnull
        public Builder title(String title)
        {
            element.setTitle(title);

            return this;
        }

        /**
         * Sets the maximum points for this Evaluation
         * 
         * @param maximumPoints
         *            Max Points
         * @return this
         */
        @Nonnull
        public Builder maxPts(double maximumPoints)
        {
            element.setMaximumPoints(maximumPoints);

            return this;
        }

        /**
         * Sets the percentage (0.0 - 1.0) of completeness for this evaluation
         * of the given factor.
         * 
         * @param complete
         *            Percentage complete
         * @return this
         */
        @Nonnull
        public Builder completeness(double complete)
        {
            element.setCompleteness(complete);

            return this;
        }

        /**
         * Sets the factor evaluated by this evaluation
         * 
         * @param factor
         *            Factor to be evaluated
         * @return this
         */
        @Nonnull
        public Builder evaluates(Factor factor)
        {
            element.setEvaluates(factor);

            return this;
        }
    }
}
