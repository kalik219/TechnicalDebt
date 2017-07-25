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

import java.util.List;

import javax.annotation.Nonnull;

import com.google.common.collect.Lists;

/**
 * Indicates that the factor should aggregate incoming measures using
 * the weighted summation operator
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class WeightedSumMultiMeasureEvaluation extends MultiMeasureEvaluation {

    private List<MeasureRanking> rankings;

    /**
     * 
     */
    public WeightedSumMultiMeasureEvaluation()
    {
        super();
        rankings = Lists.newArrayList();
    }

    /**
     * @param identifier
     */
    public WeightedSumMultiMeasureEvaluation(String identifier)
    {
        super(identifier);
        rankings = Lists.newArrayList();
    }

    public void addRanking(MeasureRanking rank)
    {
        if (rank == null || rankings.contains(rank))
            return;

        rankings.remove(rank);
    }

    public void removeRanking(MeasureRanking rank)
    {
        if (rank == null || rankings.contains(rank))
            return;

        rankings.remove(rank);
    }

    public List<MeasureRanking> getRankings()
    {
        return rankings;
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
     * Creates a new Builder for a WeightedSumMultiMeasureEvaluation
     * 
     * @return the WeightedSumMultiMeasureEvaluation.Builder instance
     */
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Creates a new Builder for a WeightedSumMultiMeasureEvaluation with the
     * given
     * unique identifier
     * 
     * @param identifier
     *            Unique identifier
     * @return the WeightedSumMultiMeasureEvaluation.Builder instance
     */
    public static Builder builder(String identifier)
    {
        return new Builder(identifier);
    }

    /**
     * Builder for WeightedSumMultiMeasureEvaluations implemented using the
     * fluent
     * interface and method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {

        /**
         * WeightedSumMultiMeasureEvaluation element under construction
         */
        private WeightedSumMultiMeasureEvaluation element;

        /**
         * Constructs a new Builder for a WeightedSumMultiMeasureEvaluation
         */
        private Builder()
        {
            element = new WeightedSumMultiMeasureEvaluation();
        }

        /**
         * Constructs a new Builder for a WeightedSumMultiMeasureEvaluation with
         * the
         * given
         * identifier
         * 
         * @param identifier
         *            The identifier of the tool to construct
         */
        private Builder(String identifier)
        {
            element = new WeightedSumMultiMeasureEvaluation(identifier);
        }

        /**
         * @return The newly constructed WeightedSumMultiMeasureEvaluation
         *         element
         */
        @Nonnull
        public WeightedSumMultiMeasureEvaluation create()
        {
            return (WeightedSumMultiMeasureEvaluation) element;
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
         * Sets the optional title of the WeightedSumMultiMeasureEvaluation
         * under
         * construction
         * 
         * @param title
         *            Title of the WeightedSumMultiMeasureEvaluation
         * @return this
         */
        @Nonnull
        public Builder title(String title)
        {
            element.setTitle(title);

            return this;
        }

        /**
         * Adds the given MeasureRanking to this evaluation
         * 
         * @param ranking
         *            MeasureRanking to add
         * @return this
         */
        @Nonnull
        public Builder ranking(MeasureRanking rank)
        {
            element.addRanking(rank);

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
