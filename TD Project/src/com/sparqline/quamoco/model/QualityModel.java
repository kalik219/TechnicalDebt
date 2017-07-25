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
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * A quality model is the basic module of Quamoco quality models. A quality
 * model contains entities, factors, measures, evaluations, aggregations, tools,
 * and tags. It is a means for structuring the complete model into sensible
 * parts. Usually, a quality model defines a quality model for a specific
 * technology and depends on the root model.
 * <br>
 * General Rules:
 * <ul>
 * <li>Build a separate quality model for each technology.</li>
 * <li>Set a dependency on the root model and other appropriate models. For
 * example, a quality model for Java should also depend on the object-oriented
 * quality model.</li>
 * </ul>
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class QualityModel {

    /**
     * A textual explanation what the model contains.
     */
    private String                  description;
    /**
     * The name of a model should represent the content of the model. For
     * example, if it describes factors for the programming language Java, it
     * should be called Java.
     * If there is no specific reason to do otherwise, only captialise the first
     * word in the name.
     */
    private String                  name;
    /**
     * The title is a more elaborated/detailed name for the model.
     * This is optional.
     * If there is no specific reason to do otherwise, only capitalize the first
     * word in the title.
     */
    private String                  title;
    /**
     * 
     */
    private Source                  originatesFrom;
    /**
     * 
     */
    private List<Tag>               taggedBy;
    /**
     * 
     */
    private Map<String, Entity>     entities;
    /**
     * 
     */
    private Map<String, Factor>     factors;
    /**
     * 
     */
    private List<Evaluation>        evaluations;
    /**
     * 
     */
    private Map<String, Measure>    measures;
    /**
     * 
     */
    private Map<String, Instrument> instruments;
    /**
     * 
     */
    private Map<String, Tool>       tools;
    /**
     * 
     */
    private List<Tag>               tags;
    /**
     * 
     */
    private List<Source>            sources;
    /**
     * The quality models the current quality model depends on. These models
     * will be loaded together with the current model
     * You can only link in any way from the current model to models that are in
     * this requires list.
     */
    private List<QualityModel>      requires;

    public QualityModel(String name)
    {
        this.name = name;
        entities = Maps.newHashMap();
        tools = Maps.newHashMap();
        measures = Maps.newHashMap();
        factors = Maps.newHashMap();
        instruments = Maps.newHashMap();
        requires = Lists.newArrayList();
        sources = Lists.newArrayList();
        tags = Lists.newArrayList();
        taggedBy = Lists.newArrayList();
        evaluations = Lists.newArrayList();
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the originatesFrom
     */
    public Source getOriginatesFrom()
    {
        return originatesFrom;
    }

    /**
     * @param originatesFrom
     *            the originatesFrom to set
     */
    public void setOriginatesFrom(Source originatesFrom)
    {
        this.originatesFrom = originatesFrom;
    }

    /**
     * @return the sources
     */
    public List<Source> getSources()
    {
        return sources;
    }

    /**
     * @param sources
     *            the sources to set
     */
    public void setSources(List<Source> sources)
    {
        this.sources = sources;
    }

    public void addTool(Tool tool)
    {
        if (tool == null)
        {
            return;
        }

        tools.put(tool.getName(), tool);
    }

    public boolean hasTool(String name)
    {
        return tools.containsKey(name);
    }

    public Tool getTool(String name)
    {
        return tools.get(name);
    }

    public void addEntity(Entity ent)
    {
        if (ent == null)
            return;

        entities.put(ent.getName(), ent);
    }

    public boolean hasEntity(String name)
    {
        return entities.containsKey(name);
    }

    public Entity getEntity(String name)
    {
        return entities.get(name);
    }

    public void addInstrument(Instrument inst)
    {
        if (inst == null)
            return;

        instruments.put(inst.getName(), inst);
    }

    public boolean hasInstrument(String name)
    {
        return instruments.containsKey(name);
    }

    public Instrument getInstrument(String name)
    {
        return instruments.get(name);
    }

    public void addMeasure(Measure meas)
    {
        if (meas == null)
            return;

        measures.put(meas.getName(), meas);
    }

    public boolean hasMeasure(String name)
    {
        return measures.containsKey(name);
    }

    public Measure getMeasure(String name)
    {
        return measures.get(name);
    }

    public boolean hasNormalizationMeasure(String name)
    {
        return measures.containsKey(name) && measures.get(name) instanceof NormalizationMeasure;
    }

    public Measure getNormalizationMeasure(String name)
    {
        if (measures.get(name) instanceof NormalizationMeasure)
            return measures.get(name);
        else
            return null;
    }

    public void addFactor(Factor fac)
    {
        if (fac == null)
            return;

        factors.put(fac.getName(), fac);
    }

    public boolean hasFactor(String name)
    {
        return factors.containsKey(name);
    }

    public Factor getFactor(String name)
    {
        return factors.get(name);
    }

    public List<Factor> getFactors() //**
    {
        return Lists.newArrayList(factors.values());
    }

    public void addRequires(QualityModel model)
    {
        if (model == null || requires.contains(model))
            return;

        requires.add(model);
    }

    public void removeRequires(QualityModel model)
    {
        if (model == null || !requires.contains(model))
            return;

        requires.remove(model);
    }

    public List<QualityModel> getRequires()
    {
        return requires;
    }

    public void addTag(Tag tag)
    {
        if (tag == null || tags.contains(tag))
            return;

        tags.add(tag);
    }

    public void removeTag(Tag tag)
    {
        if (tag == null || !tags.contains(tag))
            return;

        tags.remove(tag);
    }

    public List<Tag> getTags()
    {
        return tags;
    }

    public void addTaggedBy(Tag tag)
    {
        if (tag == null || taggedBy.contains(tag))
            return;

        taggedBy.add(tag);
    }

    public void removeTaggedBy(Tag tag)
    {
        if (tag == null || !taggedBy.contains(tag))
            return;

        taggedBy.remove(tag);
    }

    public List<Tag> getTaggedBy()
    {
        return taggedBy;
    }

    public void addEvaluation(Evaluation eval)
    {
        if (eval == null || evaluations.contains(eval))
            return;

        evaluations.add(eval);
    }

    public void removeEvaluation(Evaluation eval)
    {
        if (eval == null || !evaluations.contains(eval))
            return;

        evaluations.remove(eval);
    }

    public List<Evaluation> getEvaluations()
    {
        return evaluations;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
}
