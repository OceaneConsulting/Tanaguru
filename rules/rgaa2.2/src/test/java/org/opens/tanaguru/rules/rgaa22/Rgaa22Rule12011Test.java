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
import org.opens.tanaguru.entity.audit.*;
import org.opens.tanaguru.rules.keystore.EvidenceStore;
import org.opens.tanaguru.rules.keystore.HtmlElementStore;
import org.opens.tanaguru.rules.keystore.RemarkMessageStore;
import org.opens.tanaguru.rules.rgaa22.test.Rgaa22RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 12.1 of the referential RGAA 2.2.
 *
 * @author jkowalczyk
 */
public class Rgaa22Rule12011Test extends Rgaa22RuleImplementationTestCase {

    /**
     * Default constructor
     */
    public Rgaa22Rule12011Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.opens.tanaguru.rules.rgaa22.Rgaa22Rule12011");
    }

    @Override
    protected void setUpWebResourceMap() {
        getWebResourceMap().put("RGAA22.Test.12.1-1Passed-01",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-1Passed-01.html"));
        getWebResourceMap().put("RGAA22.Test.12.1-1Passed-02",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-1Passed-02.html"));
        getWebResourceMap().put("RGAA22.Test.12.1-1Passed-03",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-1Passed-03.html"));
        getWebResourceMap().put("RGAA22.Test.12.1-1Passed-04",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-1Passed-04.html"));
        getWebResourceMap().put("RGAA22.Test.12.1-1Passed-05",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-1Passed-05.html"));
        getWebResourceMap().put("RGAA22.Test.12.1-2Failed-01",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-2Failed-01.html"));
        getWebResourceMap().put("RGAA22.Test.12.1-2Failed-02",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-2Failed-02.html"));
        getWebResourceMap().put("RGAA22.Test.12.1-2Failed-03",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-2Failed-03.html"));
        getWebResourceMap().put("RGAA22.Test.12.1-2Failed-04",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-2Failed-04.html"));
        getWebResourceMap().put("RGAA22.Test.12.1-2Failed-05",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-2Failed-05.html"));
        getWebResourceMap().put("RGAA22.Test.12.1-2Failed-06",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-2Failed-06.html"));
        getWebResourceMap().put("RGAA22.Test.12.1-2Failed-07",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-2Failed-07.html"));
        getWebResourceMap().put("RGAA22.Test.12.1-3NMI-01",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-3NMI-01.html"));
        getWebResourceMap().put("RGAA22.Test.12.1-3NMI-02",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-3NMI-02.html"));
        getWebResourceMap().put("RGAA22.Test.12.1-3NMI-03",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-3NMI-03.html"));
        getWebResourceMap().put("RGAA22.Test.12.1-3NMI-04",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-3NMI-04.html"));
        getWebResourceMap().put("RGAA22.Test.12.1-4NA-01",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-4NA-01.html"));
        getWebResourceMap().put("RGAA22.Test.12.1-4NA-02",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-4NA-02.html"));
        getWebResourceMap().put("RGAA22.Test.12.1-4NA-03",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-4NA-03.html"));
        getWebResourceMap().put("RGAA22.Test.12.1-4NA-04",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "rgaa22/Rgaa22Rule12011/RGAA22.Test.12.1-4NA-04.html"));
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //---------------------------1Passed-01---------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("RGAA22.Test.12.1-1Passed-01");
        // check number of elements in the page
        assertEquals(6, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.PASSED, processResult.getValue());
        // check number of remarks and their value
        assertNull(processResult.getRemarkSet());
        
        
        //----------------------------------------------------------------------
        //---------------------------1Passed-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.12.1-1Passed-02");
        // check number of elements in the page
        assertEquals(6, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.PASSED, processResult.getValue());
        // check number of remarks and their value
        assertNull(processResult.getRemarkSet());

        
        //----------------------------------------------------------------------
        //---------------------------1Passed-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.12.1-1Passed-03");
        // check number of elements in the page
        assertEquals(6, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.PASSED, processResult.getValue());
        // check number of remarks and their value
        assertNull(processResult.getRemarkSet());

        
        //----------------------------------------------------------------------
        //---------------------------1Passed-04---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.12.1-1Passed-04");
        // check number of elements in the page
        assertEquals(6, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.PASSED, processResult.getValue());
        // check number of remarks and their value
        assertNull(processResult.getRemarkSet());

        
        //----------------------------------------------------------------------
        //---------------------------1Passed-05---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.12.1-1Passed-05");
        // check number of elements in the page
        assertEquals(6, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.PASSED, processResult.getValue());
        // check number of remarks and their value
        assertNull(processResult.getRemarkSet());

        
        //----------------------------------------------------------------------
        //---------------------------2Failed-01---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.12.1-2Failed-01");
        // check number of elements in the page
        assertEquals(6, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.FAILED, processResult.getValue());
        // check number of remarks and their value
        assertEquals(1, processResult.getRemarkSet().size());
        Iterator<ProcessRemark> sIter = processResult.getRemarkSet().iterator();
        SourceCodeRemark sourceCodeRemark = (SourceCodeRemark)sIter.next();
        assertEquals(TestSolution.FAILED, sourceCodeRemark.getIssue());
        assertEquals(RemarkMessageStore.LANGUAGE_CHANGE_MISSING_MSG, sourceCodeRemark.getMessageCode());
        assertEquals(HtmlElementStore.P_ELEMENT, sourceCodeRemark.getTarget());
        assertNotNull(sourceCodeRemark.getSnippet());
        // check number of evidence elements and their value
        assertEquals(3, sourceCodeRemark.getElementList().size());
        Iterator<EvidenceElement> pIter = sourceCodeRemark.getElementList().iterator();
        EvidenceElement ee = pIter.next();
        assertEquals("en",ee.getValue());
        assertEquals(EvidenceStore.LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertEquals("fr",ee.getValue());
        assertEquals(EvidenceStore.DETECTED_LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertTrue(ee.getValue().contains("L'accessibilité du web est la problématique de l'accès aux"));
        assertEquals(EvidenceStore.EXTRACTED_TEXT_EE, ee.getEvidence().getCode());
        
        //----------------------------------------------------------------------
        //---------------------------2Failed-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.12.1-2Failed-02");
        // check number of elements in the page
        assertEquals(6, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.FAILED, processResult.getValue());
        // check number of remarks and their value
        assertEquals(1, processResult.getRemarkSet().size());
        sIter = processResult.getRemarkSet().iterator();
        sourceCodeRemark = (SourceCodeRemark)sIter.next();
        assertEquals(TestSolution.FAILED, sourceCodeRemark.getIssue());
        assertEquals(RemarkMessageStore.LANGUAGE_CHANGE_MISSING_MSG, sourceCodeRemark.getMessageCode());
        assertEquals(HtmlElementStore.P_ELEMENT, sourceCodeRemark.getTarget());
        assertNotNull(sourceCodeRemark.getSnippet());
        // check number of evidence elements and their value
        assertEquals(4, sourceCodeRemark.getElementList().size());
        pIter = sourceCodeRemark.getElementList().iterator();
        ee = pIter.next();
        assertEquals("en",ee.getValue());
        assertEquals(EvidenceStore.DEFAULT_LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertEquals("fr",ee.getValue());
        assertEquals(EvidenceStore.CURRENT_LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertEquals("en",ee.getValue());
        assertEquals(EvidenceStore.DETECTED_LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertTrue(ee.getValue().contains("Web accessibility refers to the inclusive practice of making "));
        assertEquals(EvidenceStore.EXTRACTED_TEXT_EE, ee.getEvidence().getCode());
 
        
        //----------------------------------------------------------------------
        //---------------------------2Failed-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.12.1-2Failed-03");
        // check number of elements in the page
        assertEquals(6, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.FAILED, processResult.getValue());
        // check number of remarks and their value
        assertEquals(1, processResult.getRemarkSet().size());
        sIter = processResult.getRemarkSet().iterator();
        sourceCodeRemark = (SourceCodeRemark)sIter.next();
        assertEquals(TestSolution.FAILED, sourceCodeRemark.getIssue());
        assertEquals(RemarkMessageStore.LANGUAGE_CHANGE_MISSING_MSG, sourceCodeRemark.getMessageCode());
        assertEquals(HtmlElementStore.SPAN_ELEMENT, sourceCodeRemark.getTarget());
        assertNotNull(sourceCodeRemark.getSnippet());
        // check number of evidence elements and their value
        assertEquals(4, sourceCodeRemark.getElementList().size());
        pIter = sourceCodeRemark.getElementList().iterator();
        ee = pIter.next();
        assertEquals("en",ee.getValue());
        assertEquals(EvidenceStore.DEFAULT_LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertEquals("fr",ee.getValue());
        assertEquals(EvidenceStore.CURRENT_LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertEquals("en",ee.getValue());
        assertEquals(EvidenceStore.DETECTED_LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertTrue(ee.getValue().contains("Web accessibility refers to the inclusive practice of making"));
        assertEquals(EvidenceStore.EXTRACTED_TEXT_EE, ee.getEvidence().getCode());
        
        
        //----------------------------------------------------------------------
        //---------------------------2Failed-04---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.12.1-2Failed-04");
        // check number of elements in the page
        assertEquals(6, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.FAILED, processResult.getValue());
        // check number of remarks and their value
        assertEquals(1, processResult.getRemarkSet().size());
        sIter = processResult.getRemarkSet().iterator();
        sourceCodeRemark = (SourceCodeRemark)sIter.next();
        assertEquals(TestSolution.FAILED, sourceCodeRemark.getIssue());
        assertEquals(RemarkMessageStore.LANGUAGE_CHANGE_MISSING_MSG, sourceCodeRemark.getMessageCode());
        assertEquals(HtmlElementStore.P_ELEMENT, sourceCodeRemark.getTarget());
        assertNotNull(sourceCodeRemark.getSnippet());
        // check number of evidence elements and their value
        assertEquals(4, sourceCodeRemark.getElementList().size());
        pIter = sourceCodeRemark.getElementList().iterator();
        ee = pIter.next();
        assertEquals("en",ee.getValue());
        assertEquals(EvidenceStore.DEFAULT_LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertEquals("dummy",ee.getValue());
        assertEquals(EvidenceStore.CURRENT_LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertEquals("en",ee.getValue());
        assertEquals(EvidenceStore.DETECTED_LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertTrue(ee.getValue().contains("Web accessibility refers to the inclusive practice of making "));
        assertEquals(EvidenceStore.EXTRACTED_TEXT_EE, ee.getEvidence().getCode());
        
        
        //----------------------------------------------------------------------
        //---------------------------2Failed-05---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.12.1-2Failed-05");
        // check number of elements in the page
        assertEquals(6, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.FAILED, processResult.getValue());
        // check number of remarks and their value
        assertEquals(1, processResult.getRemarkSet().size());
        sIter = processResult.getRemarkSet().iterator();
        sourceCodeRemark = (SourceCodeRemark)sIter.next();
        assertEquals(TestSolution.FAILED, sourceCodeRemark.getIssue());
        assertEquals(RemarkMessageStore.LANGUAGE_CHANGE_MISSING_MSG, sourceCodeRemark.getMessageCode());
        assertEquals(HtmlElementStore.P_ELEMENT, sourceCodeRemark.getTarget());
        assertNotNull(sourceCodeRemark.getSnippet());
        // check number of evidence elements and their value
        assertEquals(4, sourceCodeRemark.getElementList().size());
        pIter = sourceCodeRemark.getElementList().iterator();
        ee = pIter.next();
        assertEquals("en",ee.getValue());
        assertEquals(EvidenceStore.DEFAULT_LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertEquals("dummy",ee.getValue());
        assertEquals(EvidenceStore.CURRENT_LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertEquals("en",ee.getValue());
        assertEquals(EvidenceStore.DETECTED_LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertTrue(ee.getValue().contains("Web accessibility refers to the inclusive practice of making "));
        assertEquals(EvidenceStore.EXTRACTED_TEXT_EE, ee.getEvidence().getCode());
        
        
        //----------------------------------------------------------------------
        //---------------------------2Failed-06---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.12.1-2Failed-06");
        // check number of elements in the page
        assertEquals(6, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.FAILED, processResult.getValue());
        // check number of remarks and their value
        assertEquals(1, processResult.getRemarkSet().size());
        sIter = processResult.getRemarkSet().iterator();
        sourceCodeRemark = (SourceCodeRemark)sIter.next();
        assertEquals(TestSolution.FAILED, sourceCodeRemark.getIssue());
        assertEquals(RemarkMessageStore.LANGUAGE_CHANGE_MISSING_MSG, sourceCodeRemark.getMessageCode());
        assertEquals(HtmlElementStore.P_ELEMENT, sourceCodeRemark.getTarget());
        assertNotNull(sourceCodeRemark.getSnippet());
        // check number of evidence elements and their value
        assertEquals(4, sourceCodeRemark.getElementList().size());
        pIter = sourceCodeRemark.getElementList().iterator();
        ee = pIter.next();
        assertEquals("en",ee.getValue());
        assertEquals(EvidenceStore.DEFAULT_LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertEquals("dummy",ee.getValue());
        assertEquals(EvidenceStore.CURRENT_LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertEquals("en",ee.getValue());
        assertEquals(EvidenceStore.DETECTED_LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertTrue(ee.getValue().contains("Web accessibility refers to the inclusive practice of making "));
        assertEquals(EvidenceStore.EXTRACTED_TEXT_EE, ee.getEvidence().getCode());
        
        
        //----------------------------------------------------------------------
        //---------------------------2Failed-07---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.12.1-2Failed-07");
        // check number of elements in the page
        assertEquals(6, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.FAILED, processResult.getValue());
        // check number of remarks and their value
        assertEquals(1, processResult.getRemarkSet().size());
        sIter = processResult.getRemarkSet().iterator();
        sourceCodeRemark = (SourceCodeRemark)sIter.next();
        assertEquals(TestSolution.FAILED, sourceCodeRemark.getIssue());
        assertEquals(RemarkMessageStore.LANGUAGE_CHANGE_MISSING_MSG, sourceCodeRemark.getMessageCode());
        assertEquals(HtmlElementStore.SPAN_ELEMENT, sourceCodeRemark.getTarget());
        assertNotNull(sourceCodeRemark.getSnippet());
        // check number of evidence elements and their value
        assertEquals(4, sourceCodeRemark.getElementList().size());
        pIter = sourceCodeRemark.getElementList().iterator();
        ee = pIter.next();
        assertEquals("en",ee.getValue());
        assertEquals(EvidenceStore.DEFAULT_LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertEquals("dummy",ee.getValue());
        assertEquals(EvidenceStore.CURRENT_LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertEquals("en",ee.getValue());
        assertEquals(EvidenceStore.DETECTED_LANGUAGE_EE, ee.getEvidence().getCode());
        ee = pIter.next();
        assertTrue(ee.getValue().contains("Web accessibility refers to the inclusive practice of making "));
        assertEquals(EvidenceStore.EXTRACTED_TEXT_EE, ee.getEvidence().getCode());
        
        
        //----------------------------------------------------------------------
        //---------------------------3NMI-01------------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.12.1-3NMI-01");
        // check number of elements in the page
        assertEquals(6, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.NEED_MORE_INFO, processResult.getValue());
        // check number of remarks and their value
        assertEquals(1, processResult.getRemarkSet().size());
        sIter = processResult.getRemarkSet().iterator();
        ProcessRemark processRemark = sIter.next();
        assertEquals(TestSolution.NEED_MORE_INFO, processRemark.getIssue());
        assertEquals(RemarkMessageStore.CHECK_SHORT_TEST_MSG, processRemark.getMessageCode());
        
        
        //----------------------------------------------------------------------
        //---------------------------3NMI-02------------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.12.1-3NMI-02");
        // check number of elements in the page
        assertEquals(5, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.NEED_MORE_INFO, processResult.getValue());
        // check number of remarks and their value
        assertEquals(1, processResult.getRemarkSet().size());
        sIter = processResult.getRemarkSet().iterator();
        processRemark = sIter.next();
        assertEquals(TestSolution.NEED_MORE_INFO, processRemark.getIssue());
        assertEquals(RemarkMessageStore.CHECK_SHORT_TEST_MSG, processRemark.getMessageCode());
        
        
        //----------------------------------------------------------------------
        //---------------------------3NMI-03------------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.12.1-3NMI-03");
        // check number of elements in the page
        assertEquals(5, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.NEED_MORE_INFO, processResult.getValue());
        // check number of remarks and their value
        assertEquals(1, processResult.getRemarkSet().size());
        sIter = processResult.getRemarkSet().iterator();
        processRemark = sIter.next();
        assertEquals(TestSolution.NEED_MORE_INFO, processRemark.getIssue());
        assertEquals(RemarkMessageStore.CHECK_SHORT_TEST_MSG, processRemark.getMessageCode());
        
        
        //----------------------------------------------------------------------
        //---------------------------3NMI-04------------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.12.1-3NMI-04");
        // check number of elements in the page
        assertEquals(5, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.NEED_MORE_INFO, processResult.getValue());
        // check number of remarks and their value
        assertEquals(1, processResult.getRemarkSet().size());
        sIter = processResult.getRemarkSet().iterator();
        processRemark = sIter.next();
        assertEquals(TestSolution.NEED_MORE_INFO, processRemark.getIssue());
        assertEquals(RemarkMessageStore.CHECK_SHORT_TEST_MSG, processRemark.getMessageCode());
        
        
        //----------------------------------------------------------------------
        //---------------------------4NA-01-------------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.12.1-4NA-01");
        // check test result
        assertEquals(TestSolution.NOT_APPLICABLE, processResult.getValue());
        // check test has no remark
        assertNull(processResult.getRemarkSet());

        
        //----------------------------------------------------------------------
        //---------------------------4NA-02-------------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.12.1-4NA-02");
        // check test result
        assertEquals(TestSolution.NOT_APPLICABLE, processResult.getValue());
        // check test has no remark
        assertNull(processResult.getRemarkSet());

        
        //----------------------------------------------------------------------
        //---------------------------4NA-03-------------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.12.1-4NA-03");
        // check test result
        assertEquals(TestSolution.NOT_APPLICABLE, processResult.getValue());
        // check test has no remark
        assertNull(processResult.getRemarkSet());

        
        //----------------------------------------------------------------------
        //---------------------------4NA-04-------------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("RGAA22.Test.12.1-4NA-04");
        // check test result
        assertEquals(TestSolution.NOT_APPLICABLE, processResult.getValue());
        // check test has no remark
        assertNull(processResult.getRemarkSet());
    }

    @Override
    protected void setConsolidate() {
        assertEquals(TestSolution.PASSED,
                consolidate("RGAA22.Test.12.1-1Passed-01").getValue());
        assertEquals(TestSolution.PASSED,
                consolidate("RGAA22.Test.12.1-1Passed-02").getValue());
        assertEquals(TestSolution.PASSED,
                consolidate("RGAA22.Test.12.1-1Passed-03").getValue());
        assertEquals(TestSolution.PASSED,
                consolidate("RGAA22.Test.12.1-1Passed-04").getValue());
        assertEquals(TestSolution.PASSED,
                consolidate("RGAA22.Test.12.1-1Passed-05").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("RGAA22.Test.12.1-2Failed-01").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("RGAA22.Test.12.1-2Failed-02").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("RGAA22.Test.12.1-2Failed-03").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("RGAA22.Test.12.1-2Failed-04").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("RGAA22.Test.12.1-2Failed-05").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("RGAA22.Test.12.1-2Failed-06").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("RGAA22.Test.12.1-2Failed-07").getValue());
        assertEquals(TestSolution.NEED_MORE_INFO,
                consolidate("RGAA22.Test.12.1-3NMI-01").getValue());
        assertEquals(TestSolution.NEED_MORE_INFO,
                consolidate("RGAA22.Test.12.1-3NMI-02").getValue());
        assertEquals(TestSolution.NEED_MORE_INFO,
                consolidate("RGAA22.Test.12.1-3NMI-03").getValue());
        assertEquals(TestSolution.NEED_MORE_INFO,
                consolidate("RGAA22.Test.12.1-3NMI-04").getValue());
        assertEquals(TestSolution.NOT_APPLICABLE,
                consolidate("RGAA22.Test.12.1-4NA-01").getValue());
        assertEquals(TestSolution.NOT_APPLICABLE,
                consolidate("RGAA22.Test.12.1-4NA-02").getValue());
        assertEquals(TestSolution.NOT_APPLICABLE,
                consolidate("RGAA22.Test.12.1-4NA-03").getValue());
        assertEquals(TestSolution.NOT_APPLICABLE,
                consolidate("RGAA22.Test.12.1-4NA-04").getValue());
    }

}