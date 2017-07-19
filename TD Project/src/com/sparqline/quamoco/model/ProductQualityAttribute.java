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
 * Product quality attributes define one way to decompose the abstract concept
 * software quality. These quality attributes, as given in ISO 25010, relate to
 * the quality of the product without explicitly considering its use. These
 * quality attributes are colloquially called -illities, because they contain,
 * for example, reliability or maintainability. In the standard, the top level
 * attributes are refined by so-called quality characteristics.
 * <ul>
 * <li>Product quality attributes model the -ilities of the ISO 25010.</li>
 * <li>These factors do characterize the entity Product.</li>
 * </ul>
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class ProductQualityAttribute extends QualityAspect {

    /**
     * Constructs a new ProductQualityAttribute with the given name
     * 
     * @param name
     *            The name
     */
    public ProductQualityAttribute(String name)
    {
        super(name);
    }

    /**
     * @param name
     * @param identifier
     */
    public ProductQualityAttribute(String name, String identifier)
    {
        super(name, identifier);
    }

    /**
     * Creates a new Builder for a ProductQualityAttribute with the given simple name
     * 
     * @param name
     *            Simple Name
     * @return the ProductQualityAttribute.Builder instance.
     */
    public static Builder builder(String name)
    {
        return new Builder(name);
    }

    /**
     * Creates a new Builder for a ProductQualityAttribute with the given simple name and
     * unique
     * identifier.
     * 
     * @param name
     *            Simple Name
     * @param identifier
     *            The unique identifier
     * @return the ProductQualityAttribute.Builder instance.
     */
    public static Builder builder(String name, String identifier)
    {
        return new Builder(name, identifier);
    }

    /**
     * Builder for ProductQualityAttributes implemented using the fluent interface
     * and method chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {

        /**
         * ProductQualityAttribute element under construction
         */
        private ProductQualityAttribute element;

        /**
         * Constructs a new Builder for a ProductQualityAttribute with the given
         * name
         * 
         * @param name
         *            The name of the ProductQualityAttribute to construct
         */
        private Builder(String name)
        {
            element = new ProductQualityAttribute(name);
        }

        /**
         * Constructs a new Builder for a ProductQualityAttribute with the given
         * name and unique identifier
         * 
         * @param name
         *            The name of the ProductQualityAttribute to construct
         * @param identifier
         *            The unique identifier
         */
        private Builder(String name, String identifier)
        {
            element = new ProductQualityAttribute(name, identifier);
        }

        /**
         * @return The newly constructed ProductQualityAttribute element
         */
        @Nonnull
        public ProductQualityAttribute create()
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
         * Adds a factor which the factor under construction refines
         * 
         * @param factor
         *            Factor
         * @return this
         */
        @Nonnull
        public Builder refines(Factor factor)
        {
            element.addRefines(factor);

            return this;
        }
    }
}
