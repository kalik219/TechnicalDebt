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
 * A class to provide the capability to rank and weight the evaluation of
 * measures which affect a factor.
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class MeasureRanking extends MeasureEvaluation implements Ranking {

    /**
     * Rank associated with the measure or factor
     */
    private int    rank;
    /**
     * Weight associated with the measure or factor
     */
    private double weight;

    /**
     * Constructs a new Ranking for the given measure
     */
    public MeasureRanking()
    {
        super();
    }

    /**
     * Constructs a new Ranking for the given measure
     * 
     * @param identifier
     *            The unique identifier
     */
    public MeasureRanking(String identifier)
    {
        super(identifier);
    }

    /**
     * @return the measure
     */
    public Measure getMeasure()
    {
        return basedOn;
    }

    /**
     * @param measure
     *            the measure to set
     */
    public void setMeasure(Measure measure)
    {
        this.basedOn = measure;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRank()
    {
        return rank;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setRank(int rank)
    {
        this.rank = rank;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getWeight()
    {
        return weight;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWeight(double weight)
    {
        this.weight = weight;
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
     * Constructs and returns a new instance of a ranking builder
     * 
     * @return The ranking builder instance
     */
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Constructs and returns a new instance of a ranking builder
     * 
     * @param identifier
     *            The unique identifier
     * @return The ranking builder instance
     */
    public static Builder builder(String identifier)
    {
        return new Builder(identifier);
    }

    /**
     * Builder used to construct a ranking.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {

        /**
         * The ranking under construction
         */
        private MeasureRanking ranking;

        /**
         * Constructs a new Builder for a MeasureRanking
         */
        public Builder()
        {
            ranking = new MeasureRanking();
        }

        /**
         * Constructs a new Builder for a MeasureRanking with the given
         * identifier
         */
        public Builder(String identifier)
        {
            ranking = new MeasureRanking(identifier);
        }

        /**
         * @return The instance under construction
         */
        public MeasureRanking create()
        {
            return ranking;
        }

        /**
         * Sets the rank of the ranking under construction to the given value
         * 
         * @param rank
         *            The rank
         * @return this
         */
        @Nonnull
        public Builder rank(int rank)
        {
            ranking.setRank(rank);

            return this;
        }

        /**
         * Sets the weight of the ranking under construction to the given value
         * 
         * @param weight
         *            The weight
         * @return this
         */
        @Nonnull
        public Builder weight(double weight)
        {
            ranking.setWeight(weight);

            return this;
        }

        /**
         * Sets the function associated with the measure
         * 
         * @param function
         *            Linear Distribution function
         * @return this
         */
        @Nonnull
        public Builder function(LinearFunction function)
        {
            ranking.setFunction(function);

            return this;
        }

        /**
         * Sets the normalization measure of the ranking
         * 
         * @param norm
         *            NormalizationMeasure
         * @return this
         */
        @Nonnull
        public Builder normalizer(NormalizationMeasure norm)
        {
            ranking.setNormalization(norm);

            return this;
        }

        /**
         * Sets the normalization range of the ranking
         * 
         * @param range
         *            The Range
         * @return this
         */
        @Nonnull
        public Builder range(NormalizationRange range)
        {
            ranking.setRange(range);

            return this;
        }

        /**
         * Sets the measure this ranking is BasedOn
         * 
         * @param eval
         *            Measure used in evaluation
         * @return this
         */
        @Nonnull
        public Builder basedOn(Measure eval)
        {
            ranking.setBasedOn(eval);

            return this;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double getCompleteness()
    {
        return 0.0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCompleteness(Double completeness)
    {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double getMaximumPoints()
    {
        return 0.0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMaximumPoints(Double maximumPoints)
    {        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Factor getEvaluates()
    {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEvaluates(Factor factor)
    {
    }
}
