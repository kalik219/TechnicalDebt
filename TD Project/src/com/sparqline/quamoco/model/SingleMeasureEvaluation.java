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
 * An evaluation by applying pre-defined operations on a single measure.
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class SingleMeasureEvaluation extends MeasureEvaluation {

    /**
     * 
     */
    public SingleMeasureEvaluation()
    {
        super();
    }

    /**
     * @param identifier
     */
    public SingleMeasureEvaluation(String identifier)
    {
        super(identifier);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double evaluate()
    {
        throw new RuntimeException("Not yet implemented");
    }

    /**
     * Creates a new Builder for a SingleMeasureEvaluation
     * 
     * @return the SingleMeasureEvaluation.Builder instance
     */
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Creates a new Builder for a SingleMeasureEvaluation with the given
     * unique identifier
     * 
     * @param identifier
     *            Unique identifier
     * @return the SingleMeasureEvaluation.Builder instance
     */
    public static Builder builder(String identifier)
    {
        return new Builder(identifier);
    }

    /**
     * Builder for SingleMeasureEvaluations implemented using the fluent
     * interface and method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {

        /**
         * SingleMeasureEvaluation element under construction
         */
        private SingleMeasureEvaluation element;

        /**
         * Constructs a new Builder for a SingleMeasureEvaluation
         */
        private Builder()
        {
            element = new SingleMeasureEvaluation();
        }

        /**
         * Constructs a new Builder for a SingleMeasureEvaluation with the given
         * identifier
         * 
         * @param identifier
         *            The identifier of the tool to construct
         */
        private Builder(String identifier)
        {
            element = new SingleMeasureEvaluation(identifier);
        }

        /**
         * @return The newly constructed SingleMeasureEvaluation element
         */
        @Nonnull
        public SingleMeasureEvaluation create()
        {
            return (SingleMeasureEvaluation) element;
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
         * Sets the optional title of the SingleMeasureEvaluation under
         * construction
         * 
         * @param title
         *            Title of the SingleMeasureEvaluation
         * @return this
         */
        @Nonnull
        public Builder title(String title)
        {
            element.setTitle(title);

            return this;
        }

        /**
         * Sets the range of the SingleMeasureEvaluation
         * 
         * @param range
         *            Normalization Range
         * @return this
         */
        @Nonnull
        public Builder range(NormalizationRange range)
        {
            element.setRange(range);

            return this;
        }

        /**
         * Sets the function associated with the SingleMeasureEvaluation
         * 
         * @param function
         *            Function
         * @return this
         */
        @Nonnull
        public Builder function(Function function)
        {
            element.setFunction(function);

            return this;
        }

        /**
         * Sets the normalization measure associated with the
         * SingleMeasureEvaluation
         * 
         * @param norm
         *            NormalizationMeasure
         * @return this
         */
        @Nonnull
        public Builder normalization(NormalizationMeasure norm)
        {
            element.setNormalization(norm);

            return this;
        }

        /**
         * Sets the factor this evaluation determines
         * 
         * @param eval
         *            Factor to determine
         * @return this
         */
        @Nonnull
        public Builder evaluates(Factor eval)
        {
            element.setEvaluates(eval);

            return this;
        }

        /**
         * Sets the measure used during evaluation
         * 
         * @param meas
         *            Measure
         * @return this
         */
        @Nonnull
        public Builder basedOn(Measure meas)
        {
            element.setBasedOn(meas);

            return this;
        }
    }
}
