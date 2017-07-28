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
 * A tool-based instrument is an instrument that is calculated by a tool.
 * This model element is just the super-class of Rule Based Instrument and
 * Metric Based Instrument. It is not supposed to be used.
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public abstract class ToolBasedInstrument extends Instrument {

    /**
     * The tool providing measurements.
     */
    private Tool tool;

    /**
     * Constructs a new ToolBasedInstrument with the given name and associated
     * with the given Tool.
     */
    public ToolBasedInstrument(String name, Tool tool)
    {
        super(name);
        this.tool = tool;
    }

    public ToolBasedInstrument(String name, Tool tool, String identifier)
    {
        super(name, identifier);
        this.tool = tool;
    }

    /**
     * @return the tool associated with this instrument
     */
    public Tool getTool()
    {
        return tool;
    }

    /**
     * @param tool
     *            the new tool associated with this instrument
     */
    public void setTool(Tool tool)
    {
        this.tool = tool;
    }

}
