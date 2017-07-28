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
 * Product factors are properties of specific parts of the software product.
 * These parts are specified as artifacts or product entities, such as,
 * Conciseness or Appropriateness.
 * <ul>
 * <li>Use product factors to characterize parts of the software.
 * A product factor must make sense, without referring to the impact.
 * <b>Positive example:</b> [Structuredness @Expression].
 * The structuredness is defined, independent of the impact it has on
 * understandability.</li>
 * <b>Negative example:</b> [Efficiency @Expression].
 * You should not introduce this factor and use it to collect all measures that
 * have an impact on performance. Not doing so, assures that a new measure can
 * be uniquely assigned to a factor, without having in mind its impact.
 * <li>An impact of a product-factor to a product quality attribute or a quality
 * in use factor should point to a leaf in the hierarchy.
 * This way it is assured that a justification is given for each of the impacted
 * factors.
 * Example: Instead of modeling an impact to [Maintainability] you should model
 * two impacts to [Analyzability], [Modifyability] and give a special
 * justification for both of them. If you would only model one impact to
 * [Maintainability] the justification is less clearer.</li>
 * </ul>
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class ProductFactor extends Factor {

    /**
     * Constructs a new ProductFactor with the given name
     * 
     * @param name
     *            The name
     */
    public ProductFactor(String name)
    {
        super(name);
    }

    /**
     * @param name
     * @param identifier
     */
    public ProductFactor(String name, String identifier)
    {
        super(name, identifier);
    }

    /**
     * Creates a new Builder for a ProductFactor with the given simple name
     * 
     * @param name
     *            Simple Name
     * @return the ProductFactor.Builder instance.
     */
    public static Builder builder(String name)
    {
        return new Builder(name);
    }

    /**
     * Creates a new Builder for a ProductFactor with the given simple name and
     * unique
     * identifier.
     * 
     * @param name
     *            Simple Name
     * @param identifier
     *            The unique identifier
     * @return the ProductFactor.Builder instance.
     */
    public static Builder builder(String name, String identifier)
    {
        return new Builder(name, identifier);
    }

    /**
     * Builder for ProductFactors implemented using the fluent interface
     * and method chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {

        /**
         * ProductFactor element under construction
         */
        private ProductFactor element;

        /**
         * Constructs a new Builder for a ProductFactor with the given
         * name
         * 
         * @param name
         *            The name of the ProductFactor to construct
         */
        private Builder(String name)
        {
            element = new ProductFactor(name);
        }

        /**
         * Constructs a new Builder for a ProductFactor with the given
         * name and unique identifier
         * 
         * @param name
         *            The name of the ProductFactor to construct
         * @param identifier
         *            The unique identifier
         */
        private Builder(String name, String identifier)
        {
            element = new ProductFactor(name, identifier);
        }

        /**
         * @return The newly constructed ProductFactor element
         */
        @Nonnull
        public ProductFactor create()
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
