package com.cognizant.nitish.auditchecklist.Audit_CheckList.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class QuestionTest {
    /**
     * Method under test: {@link Question#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Question()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Question#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Question question = new Question();

        Question question1 = new Question();
        question1.setAuditType("Audit Type");
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setResponse("Response");
        assertTrue(question.canEqual(question1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Question}
     *   <li>{@link Question#setAuditType(String)}
     *   <li>{@link Question#setQuestion(String)}
     *   <li>{@link Question#setQuestionId(int)}
     *   <li>{@link Question#setResponse(String)}
     *   <li>{@link Question#toString()}
     *   <li>{@link Question#getAuditType()}
     *   <li>{@link Question#getQuestion()}
     *   <li>{@link Question#getQuestionId()}
     *   <li>{@link Question#getResponse()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Question actualQuestion = new Question();
        actualQuestion.setAuditType("Audit Type");
        actualQuestion.setQuestion("Question");
        actualQuestion.setQuestionId(123);
        actualQuestion.setResponse("Response");
        String actualToStringResult = actualQuestion.toString();
        assertEquals("Audit Type", actualQuestion.getAuditType());
        assertEquals("Question", actualQuestion.getQuestion());
        assertEquals(123, actualQuestion.getQuestionId());
        assertEquals("Response", actualQuestion.getResponse());
        assertEquals("Question(questionId=123, question=Question, auditType=Audit Type, response=Response)",
                actualToStringResult);
    }

    /**
     * Method under test: {@link Question#equals(Object)}
     */
    @Test
    void testEquals() {
        Question question = new Question();
        question.setAuditType("Audit Type");
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setResponse("Response");
        assertNotEquals(question, null);
    }

    /**
     * Method under test: {@link Question#equals(Object)}
     */
    @Test
    void testEquals2() {
        Question question = new Question();
        question.setAuditType("Audit Type");
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setResponse("Response");
        assertNotEquals(question, "Different type to Question");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Question#equals(Object)}
     *   <li>{@link Question#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Question question = new Question();
        question.setAuditType("Audit Type");
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setResponse("Response");
        assertEquals(question, question);
        int expectedHashCodeResult = question.hashCode();
        assertEquals(expectedHashCodeResult, question.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Question#equals(Object)}
     *   <li>{@link Question#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        Question question = new Question();
        question.setAuditType("Audit Type");
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setResponse("Response");

        Question question1 = new Question();
        question1.setAuditType("Audit Type");
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setResponse("Response");
        assertEquals(question, question1);
        int expectedHashCodeResult = question.hashCode();
        assertEquals(expectedHashCodeResult, question1.hashCode());
    }

    /**
     * Method under test: {@link Question#equals(Object)}
     */
    @Test
    void testEquals5() {
        Question question = new Question();
        question.setAuditType("Question");
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setResponse("Response");

        Question question1 = new Question();
        question1.setAuditType("Audit Type");
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setResponse("Response");
        assertNotEquals(question, question1);
    }

    /**
     * Method under test: {@link Question#equals(Object)}
     */
    @Test
    void testEquals6() {
        Question question = new Question();
        question.setAuditType(null);
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setResponse("Response");

        Question question1 = new Question();
        question1.setAuditType("Audit Type");
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setResponse("Response");
        assertNotEquals(question, question1);
    }

    /**
     * Method under test: {@link Question#equals(Object)}
     */
    @Test
    void testEquals7() {
        Question question = new Question();
        question.setAuditType("Audit Type");
        question.setQuestion("Audit Type");
        question.setQuestionId(123);
        question.setResponse("Response");

        Question question1 = new Question();
        question1.setAuditType("Audit Type");
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setResponse("Response");
        assertNotEquals(question, question1);
    }

    /**
     * Method under test: {@link Question#equals(Object)}
     */
    @Test
    void testEquals8() {
        Question question = new Question();
        question.setAuditType("Audit Type");
        question.setQuestion(null);
        question.setQuestionId(123);
        question.setResponse("Response");

        Question question1 = new Question();
        question1.setAuditType("Audit Type");
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setResponse("Response");
        assertNotEquals(question, question1);
    }

    /**
     * Method under test: {@link Question#equals(Object)}
     */
    @Test
    void testEquals9() {
        Question question = new Question();
        question.setAuditType("Audit Type");
        question.setQuestion("Question");
        question.setQuestionId(1);
        question.setResponse("Response");

        Question question1 = new Question();
        question1.setAuditType("Audit Type");
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setResponse("Response");
        assertNotEquals(question, question1);
    }

    /**
     * Method under test: {@link Question#equals(Object)}
     */
    @Test
    void testEquals10() {
        Question question = new Question();
        question.setAuditType("Audit Type");
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setResponse("Question");

        Question question1 = new Question();
        question1.setAuditType("Audit Type");
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setResponse("Response");
        assertNotEquals(question, question1);
    }

    /**
     * Method under test: {@link Question#equals(Object)}
     */
    @Test
    void testEquals11() {
        Question question = new Question();
        question.setAuditType("Audit Type");
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setResponse(null);

        Question question1 = new Question();
        question1.setAuditType("Audit Type");
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setResponse("Response");
        assertNotEquals(question, question1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Question#equals(Object)}
     *   <li>{@link Question#hashCode()}
     * </ul>
     */
    @Test
    void testEquals12() {
        Question question = new Question();
        question.setAuditType(null);
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setResponse("Response");

        Question question1 = new Question();
        question1.setAuditType(null);
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setResponse("Response");
        assertEquals(question, question1);
        int expectedHashCodeResult = question.hashCode();
        assertEquals(expectedHashCodeResult, question1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Question#equals(Object)}
     *   <li>{@link Question#hashCode()}
     * </ul>
     */
    @Test
    void testEquals13() {
        Question question = new Question();
        question.setAuditType("Audit Type");
        question.setQuestion(null);
        question.setQuestionId(123);
        question.setResponse("Response");

        Question question1 = new Question();
        question1.setAuditType("Audit Type");
        question1.setQuestion(null);
        question1.setQuestionId(123);
        question1.setResponse("Response");
        assertEquals(question, question1);
        int expectedHashCodeResult = question.hashCode();
        assertEquals(expectedHashCodeResult, question1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Question#equals(Object)}
     *   <li>{@link Question#hashCode()}
     * </ul>
     */
    @Test
    void testEquals14() {
        Question question = new Question();
        question.setAuditType("Audit Type");
        question.setQuestion("Question");
        question.setQuestionId(123);
        question.setResponse(null);

        Question question1 = new Question();
        question1.setAuditType("Audit Type");
        question1.setQuestion("Question");
        question1.setQuestionId(123);
        question1.setResponse(null);
        assertEquals(question, question1);
        int expectedHashCodeResult = question.hashCode();
        assertEquals(expectedHashCodeResult, question1.hashCode());
    }
}

