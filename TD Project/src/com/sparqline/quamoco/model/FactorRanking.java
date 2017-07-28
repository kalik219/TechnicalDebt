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
 * A class providing the ability to rank and weight the factors affecting the
 * evaluation of another Factor
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class FactorRanking extends QMElement implements Ranking {

    /**
     * Factor associated with this ranking
     */
    private Factor basedOn;
    /**
     * Rank associated with the measure or factor
     */
    private int    rank;
    /**
     * Weight associated with the measure or factor
     */
    private double weight;

    /**
     * Constructs a new Factor ranking
     * 
     * @param factor
     *            The factor for which this is a ranking
     */
    public FactorRanking(Factor factor)
    {
        super();
        this.basedOn = factor;
    }

    /**
     * @param identifier
     * @param factor
     */
    public FactorRanking(String identifier, Factor factor)
    {
        super(identifier);
        this.basedOn = factor;
    }

    /**
     * @return the factor
     */
    public Factor getFactor()
    {
        return basedOn;
    }

    /**
     * @param factor
     *            the factor to set
     */
    public void setFactor(Factor factor)
    {
        this.basedOn = factor;
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
     * Constructs and returns a new instance of a ranking builder
     * 
     * @param factor
     *            The factor for the ranking
     * @return The ranking builder instance
     */
    public static Builder builder(Factor factor)
    {
        return new Builder(factor);
    }

    /**
     * Constructs and returns a new instance of a ranking builder
     * 
     * @param identifier
     *            the unique identifier
     * @param factor
     *            The factor for the ranking
     * @return The ranking builder instance
     */
    public static Builder builder(String identifier, Factor factor)
    {
        return new Builder(identifier, factor);
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
        private FactorRanking ranking;

        /**
         * Constructs a new Builder for a ranking for the given factor
         * 
         * @param factor
         *            The factor
         */
        public Builder(Factor factor)
        {
            ranking = new FactorRanking(factor);
        }

        /**
         * Constructs a new Builder for a ranking for the given factor
         * 
         * @param identifier
         *            The unique identifier
         * @param factor
         *            The factor
         */
        public Builder(String identifier, Factor factor)
        {
            ranking = new FactorRanking(identifier, factor);
        }

        /**
         * @return The instance under construction
         */
        public FactorRanking create()
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
    }
}
