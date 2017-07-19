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

/**
 * @author Isaac Griffith
 * @version 1.1.1
 */
public abstract class MeasureEvaluation extends FormBasedEvaluation {

    /**
     * There should be typically only one measure available. If the factor is
     * measured by more than one measure, select the measure that shall be used
     * for this evaluation.
     */
    protected Measure              basedOn;
    /**
     * Define a normalization measure for normalizing the measure that is used
     * for evaluation.
     */
    protected NormalizationMeasure normalization;
    /**
     * Normalize a measure of type finding by the suitable entity. Available
     * ranges are methodRange, classRange, and fileRange.
     */
    protected NormalizationRange   range;
    /**
     * Select the function (Linear Increasing Points or Linear Decreasing
     * Points) and define upper and lower bounds.
     */
    protected Function       function;

    /**
     * 
     */
    public MeasureEvaluation()
    {
        super();
    }
    
    public MeasureEvaluation(String identifier) {
        super(identifier);
    }

    /**
     * @return the range
     */
    public NormalizationRange getRange()
    {
        return range;
    }

    /**
     * @param range
     *            the range to set
     */
    public void setRange(NormalizationRange range)
    {
        this.range = range;
    }

    /**
     * @return the normalize
     */
    public NormalizationMeasure getNormalization()
    {
        return normalization;
    }

    /**
     * @param normalize
     *            the normalize to set
     */
    public void setNormalization(NormalizationMeasure normalize)
    {
        this.normalization = normalize;
    }

    /**
     * @return the function
     */
    public Function getFunction()
    {
        return function;
    }

    /**
     * @param function
     *            the function to set
     */
    public void setFunction(Function function)
    {
        this.function = function;
    }

    /**
     * @return the evaluate
     */
    public Measure getBasedOn()
    {
        return basedOn;
    }

    /**
     * @param evaluate
     *            the evaluate to set
     */
    public void setBasedOn(Measure evaluate)
    {
        this.basedOn = evaluate;
    }
}
