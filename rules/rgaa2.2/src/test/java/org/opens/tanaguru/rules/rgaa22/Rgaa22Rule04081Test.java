/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2013  Open-S Company
 *
 * This program is free software: you can redistribute it and/or modify
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
package org.opens.tanaguru.rules.rgaa22;

import java.util.Iterator;
import java.util.LinkedHashSet;
import org.opens.tanaguru.entity.audit.*;
import static org.opens.tanaguru.rules.keystore.AttributeStore.ALT_ATTR;
import static org.opens.tanaguru.rules.keystore.AttributeStore.SRC_ATTR;
import org.opens.tanaguru.rules.keystore.HtmlElementStore;
import org.opens.tanaguru.rules.keystore.RemarkMessageStore;
import org.opens.tanaguru.rules.rgaa22.test.Rgaa22RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 4.8 of the referential RGAA 2.2.
 *
 * @author jkowalczyk
 */
public class Rgaa22Rule04081Test extends Rgaa22RuleImplementationTestCase {

    /**
     * Default constructor
     */
    public Rgaa22Rule04081Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.opens.tanaguru.rules.rgaa22.Rgaa22Rule04081");
    }

    @Override
    protected void setUpWebResourceMap() {
        getWebResourceMap().put("RGAA22.Test.4.8-3NMI-01",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "rgaa22/Rgaa22Rule04081/RGAA22.Test.4.8-3NMI-01.html"));
        getWebResourceMap().put("RGAA22.Test.4.8-3NMI-02",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "rgaa22/Rgaa22Rule04081/RGAA22.Test.4.8-3NMI-02.html"));
        addParameterToParameterMap("RGAA22.Test.4.8-3NMI-02", createParameter("Rules", "INFORMATIVE_IMAGE_MARKER", "id-informative-image"));
        addParameterToParameterMap("RGAA22.Test.4.8-3NMI-02", createParameter("Rules", "DECORATIVE_IMAGE_MARKER", "id-decorative-image"));
        getWebResourceMap().put("RGAA22.Test.4.8-4NA-01",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "rgaa22/Rgaa22Rule04081/RGAA22.Test.4.8-4NA-01.html"));
        getWebResourceMap().put("RGAA22.Test.4.8-4NA-02",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "rgaa22/Rgaa22Rule04081/RGAA22.Test.4.8-4NA-02.html"));
        getWebResourceMap().put("RGAA22.Test.4.8-4NA-03",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "rgaa22/Rgaa22Rule04081/RGAA22.Test.4.8-4NA-03.html"));
        addParameterToParameterMap("RGAA22.Test.4.8-4NA-03", createParameter("Rules", "DECORATIVE_IMAGE_MARKER", "class-decorative-image"));
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //-------------------------------3NMI-01--------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("RGAA22.Test.4.8-3NMI-01");
        // check number of elements in the page
        assertEquals(1, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.NEED_MORE_INFO, processResult.getValue());
        // check number of remarks and their value
        assertEquals(1, processResult.getRemarkSet().size());
        SourceCodeRemark processRemark = ((SourceCodeRemark)((LinkedHashSet)processResult.getRemarkSet()).iterator().next());
        assertEquals(TestSolution.NEED_MORE_INFO, processRemark.getIssue());
        assertEquals(RemarkMessageStore.CHECK_NATURE_OF_IMAGE_AND_DESC_PERTINENCE_MSG, processRemark.getMessageCode());
        assertEquals(HtmlElementStore.IMG_ELEMENT, processRemark.getTarget());
        // check number of evidence elements and their value
        assertEquals(2, processRemark.getElementList().size());
        Iterator<EvidenceElement> pIter = processRemark.getElementList().iterator();
        EvidenceElement ee = pIter.next();
        assertEquals("", ee.getValue());
        assertEquals(ALT_ATTR, ee.getEvidence().getCode());
        ee = pIter.next();
        assertTrue(ee.getValue().contains("mock_image.jpg"));
        assertEquals(SRC_ATTR, ee.getEvidence().getCode());
        
        
        //----------------------------------------------------------------------
        //-------------------------------3NMI-02--------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.4.8-3NMI-02");
        // check number of elements in the page
        assertEquals(2, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.NEED_MORE_INFO, processResult.getValue());
        // check number of remarks and their value
        assertEquals(2, processResult.getRemarkSet().size());
        Iterator<ProcessRemark> iter = processResult.getRemarkSet().iterator();
        
        processRemark = (SourceCodeRemark)iter.next();
        assertEquals(TestSolution.NEED_MORE_INFO, processRemark.getIssue());
        assertEquals(RemarkMessageStore.CHECK_DESC_PERTINENCE_OF_INFORMATIVE_IMG_MSG, processRemark.getMessageCode());
        assertEquals(HtmlElementStore.IMG_ELEMENT, processRemark.getTarget());
        // check number of evidence elements and their value
        assertEquals(2, processRemark.getElementList().size());
        pIter = processRemark.getElementList().iterator();
        ee = pIter.next();
        assertEquals("", ee.getValue());
        assertEquals(ALT_ATTR, ee.getEvidence().getCode());
        ee = pIter.next();
        assertTrue(ee.getValue().contains("mock_image1.jpg"));
        assertEquals(SRC_ATTR, ee.getEvidence().getCode());
        
        processRemark = (SourceCodeRemark)iter.next();
        assertEquals(TestSolution.NEED_MORE_INFO, processRemark.getIssue());
        assertEquals(RemarkMessageStore.CHECK_NATURE_OF_IMAGE_AND_DESC_PERTINENCE_MSG, processRemark.getMessageCode());
        assertEquals(HtmlElementStore.IMG_ELEMENT, processRemark.getTarget());
        // check number of evidence elements and their value
        assertEquals(2, processRemark.getElementList().size());
        pIter = processRemark.getElementList().iterator();
        ee = pIter.next();
        assertEquals("", ee.getValue());
        assertEquals(ALT_ATTR, ee.getEvidence().getCode());
        ee = pIter.next();
        assertTrue(ee.getValue().contains("mock_image2.jpg"));
        assertEquals(SRC_ATTR, ee.getEvidence().getCode());

        
        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.4.8-4NA-01");
        // check test result
        assertEquals(TestSolution.NOT_APPLICABLE, processResult.getValue());
        // check test has no remark
        assertNull(processResult.getRemarkSet());
        // check number of elements in the page
        assertEquals(0, processResult.getElementCounter());
        

        //----------------------------------------------------------------------
        //------------------------------4NA-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.4.8-4NA-02");
        // check test result
        assertEquals(TestSolution.NOT_APPLICABLE, processResult.getValue());
        // check test has no remark
        assertNull(processResult.getRemarkSet());
        // check number of elements in the page
        assertEquals(0, processResult.getElementCounter());
        

        //----------------------------------------------------------------------
        //------------------------------4NA-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.4.8-4NA-03");
        // check test result
        assertEquals(TestSolution.NOT_APPLICABLE, processResult.getValue());
        // check test has no remark
        assertNull(processResult.getRemarkSet());
        // check number of elements in the page
        assertEquals(0, processResult.getElementCounter());
        

    }

    @Override
    protected void setConsolidate() {
        assertEquals(TestSolution.NEED_MORE_INFO,
                consolidate("RGAA22.Test.4.8-3NMI-01").getValue());
        assertEquals(TestSolution.NEED_MORE_INFO,
                consolidate("RGAA22.Test.4.8-3NMI-02").getValue());
        assertEquals(TestSolution.NOT_APPLICABLE,
                consolidate("RGAA22.Test.4.8-4NA-01").getValue());
        assertEquals(TestSolution.NOT_APPLICABLE,
                consolidate("RGAA22.Test.4.8-4NA-02").getValue());
        assertEquals(TestSolution.NOT_APPLICABLE,
                consolidate("RGAA22.Test.4.8-4NA-03").getValue());
    }

}