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
 * A metric based instrument is a concrete description how to collect the data
 * for a measure using a tool that calculates a numerical metric. Examples are
 * lines of code or clone coverage.
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class MetricBasedInstrument extends ToolBasedInstrument {

    /**
     * Constructs a new MetricBasedInstrument with the given name and associated
     * with the given tool.
     * 
     * @param name
     *            The name of this instrument, representing the exact
     *            capitalization of the metric provided by the tool to which
     *            this instrument is associated.
     * @param tool
     *            The tool associated with this instrument
     */
    public MetricBasedInstrument(String name, Tool tool)
    {
        super(name, tool);
    }

    /**
     * Constructs a new MetricBasedInstrument with the given name and associated
     * with the given tool.
     * 
     * @param name
     *            The name of this instrument, representing the exact
     *            capitalization of the metric provided by the tool to which
     *            this instrument is associated.
     * @param tool
     *            The tool associated with this instrument
     * @param identifier
     *            the unique identifier of this MetricBasedInstrument
     */
    public MetricBasedInstrument(String name, Tool tool, String identifier)
    {
        super(name, tool);
    }

    /**
     * Creates a new Builder for a Instrument with the given simple name and
     * associated with the given tool.
     * 
     * @param name
     *            Simple Name
     * @param tool
     *            The tool associated with instrument under construction.
     * @return the Instrument.Builder instance
     */
    public static Builder builder(String name, Tool tool)
    {
        return new Builder(name, tool);
    }

    /**
     * Creates a new Builder for a Instrument with the given simple name and
     * associated with the given tool and given the unique identifier.
     * 
     * @param name
     *            Simple Name
     * @param tool
     *            The tool associated with instrument under construction.
     * @param identifier
     *            The unique identifier
     * @return the Instrument.Builder instance
     */
    public static Builder builder(String name, Tool tool, String identifier)
    {
        return new Builder(name, tool, identifier);
    }

    /**
     * Builder for Instruments implemented using the fluent interface and method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {

        /**
         * Instrument element under construction
         */
        private MetricBasedInstrument element;

        /**
         * Creates a new Builder for a Instrument with the given simple name and
         * associated with the given tool.
         * 
         * @param name
         *            Simple Name
         * @param tool
         *            The tool associated with instrument under construction.
         * @return the Instrument.Builder instance
         */
        private Builder(String name, Tool tool)
        {
            element = new MetricBasedInstrument(name, tool);
        }

        /**
         * Creates a new Builder for a Instrument with the given simple name and
         * associated with the given tool and has the given unique identifier.
         * 
         * @param name
         *            Simple Name
         * @param tool
         *            The tool associated with instrument under construction.
         * @param identifier
         *            The unique identifier
         * @return the Instrument.Builder instance
         */
        private Builder(String name, Tool tool, String identifier)
        {
            element = new MetricBasedInstrument(name, tool);
        }

        /**
         * @return The newly constructed Instrument element
         */
        @Nonnull
        public MetricBasedInstrument create()
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
         * Sets the tool associated with the Instrument under construction
         * 
         * @param tool
         *            The tool
         * @return this
         */
        @Nonnull
        public Builder tool(Tool tool)
        {
            element.setTool(tool);

            return this;
        }
    }
}
