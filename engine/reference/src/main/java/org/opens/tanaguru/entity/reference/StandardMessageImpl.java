/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2011  Open-S Company
 *
 * This file is part of Tanaguru.
 *
 * Tanaguru is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: open-s AT open-s DOT com
 */
package org.opens.tanaguru.entity.reference;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jkowalczyk
 */
@Entity
@Table(name = "STANDARD_MESSAGE")
@XmlRootElement
public class StandardMessageImpl implements StandardMessage, Serializable {

    @Column(name = "Cd_Standard_Message")
    private String code;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Standard_Message")
    private Long id;
    @Column(name = "Label")
    private String label;
    @Column(name = "Text")
    private String text;

    public StandardMessageImpl() {
        super();
    }

    public StandardMessageImpl(String code, String text) {
        this();
        this.code = code;
        this.text = text;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
