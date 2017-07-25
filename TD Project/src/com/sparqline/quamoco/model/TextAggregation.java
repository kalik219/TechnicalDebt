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
 * An aggregation where the specification is a semi-formal text.
 * <br>
 * General Rules
 * <ul>
 * <li>Within one model, the textual specification should be used consistently
 * and marked out by a telling name.</li>
 * </ul>
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class TextAggregation extends MeasureAggregation {

    /**
     * The textual specification can be used for writing any syntax; thus the
     * text will not be evaluated.
     */
    protected String specification;
    List<Measure> aggregates;

    /**
     * Constructs a new TextAggregation.
     */
    public TextAggregation()
    {
        super();
        aggregates = Lists.newArrayList();
    }

    /**
     * Constructs a new TextAggregation with the given unique
     * identifier.
     * 
     * @param identifier
     *            The unique identifier
     */
    public TextAggregation(String identifier)
    {
        super(identifier);
        aggregates = Lists.newArrayList();
    }

    /**
     * @return the specification
     */
    public String getSpecification()
    {
        return specification;
    }

    /**
     * @param specification
     *            the specification to set
     */
    public void setSpecification(String specification)
    {
        this.specification = specification;
    }
    
    public void addAggregate(Measure aggr) {
        if (aggr == null || aggregates.contains(aggr))
            return;
        
        aggregates.add(aggr);
    }
    
    public void removeAggregate(Measure aggr) {
        if (aggr == null || !aggregates.contains(aggr)) {
            return;
        }
        
        aggregates.remove(aggr);
    }
    
    public List<Measure> getAggregates() {
        return aggregates;
    }

    /**
     * Creates a new Builder for a TextAggregation
     * 
     * @return the TextAggregation.Builder instance
     */
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Creates a new Builder for a TextAggregation with the
     * given unique identifier
     * 
     * @param identifier
     *            The unique identifier
     * @return the TextAggregation.Builder instance
     */
    public static Builder builder(String identifier)
    {
        return new Builder(identifier);
    }

    /**
     * Builder for TextAggregations implemented using the fluent
     * interface and method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {

        /**
         * TextAggregation element under construction
         */
        private TextAggregation element;

        /**
         * Constructs a new Builder for a TextAggregation
         */
        private Builder()
        {
            element = new TextAggregation();
        }

        /**
         * Constructs a new Builder for a TextAggregation with
         * the given unique identifier
         * 
         * @param name
         *            The unique identifier
         */
        private Builder(String identifier)
        {
            element = new TextAggregation(identifier);
        }

        /**
         * @return The newly constructed TextAggregation element
         */
        @Nonnull
        public TextAggregation create()
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
         * Sets the optional title of the TextAggregation under
         * construction
         * 
         * @param title
         *            Title of the TextAggregation
         * @return this
         */
        @Nonnull
        public Builder title(String title)
        {
            element.setTitle(title);

            return this;
        }

        /**
         * Adds a measure for aggregation to the TextAggregation
         * 
         * @param measure
         *            The measure to add to the list of aggregates for the
         *            TextAggregation under construction.
         * @return this
         */
        @Nonnull
        public Builder aggregates(Measure measure)
        {
            element.addAggregate(measure);

            return this;
        }
    
        /**
         * Sets the specification associated with the TextAggregation under
         * construction
         * 
         * @param spec
         *            Specification
         * @return this
         */
        @Nonnull
        public Builder specification(String spec)
        {
            element.setSpecification(spec);

            return this;
        }
    }
}
