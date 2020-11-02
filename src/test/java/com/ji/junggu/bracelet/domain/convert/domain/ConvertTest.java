package com.ji.junggu.bracelet.domain.convert.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertTest {

    private Convert test;

    @BeforeEach
    void setUp() {
        test = new Convert();
    }

    @Test
    void convertContent() {
        test.setType("string");

        assertEquals("\"qwe\", \"asd\"}, {\"asd\", \"asd\"", test.convertContent("[[\"qwe\", \"asd\"],[\"asd\", \"asd\"]]"));
        assertEquals("\"leo\", \"kiki\", \"eden\"", test.convertContent("[\"leo\", \"kiki\", \"eden\"]"));
        assertEquals("\"marina\", \"josipa\", \"nikola\", \"vinko\", \"filipa\"", test.convertContent("[\"marina\", \"josipa\", \"nikola\", \"vinko\", \"filipa\"]"));
        assertEquals("\"Enter uid1234 Muzi\", \"Enter uid4567 Prodo\", \"Leave uid1234\", \"Enter uid1234 Prodo\", \"Change uid4567 Ryan\"", test.convertContent("[\"Enter uid1234 Muzi\", \"Enter uid4567 Prodo\", \"Leave uid1234\", \"Enter uid1234 Prodo\", \"Change uid4567 Ryan\"]"));
        assertEquals("\"100\", \"ryan\", \"music\", \"2\"}, {\"200\", \"apeach\", \"math\", \"2\"}, {\"300\", \"tube\", \"computer\", \"3\"}, {\"400\", \"con\", \"computer\", \"4\"}, {\"500\", \"muzi\", \"music\", \"3\"}, {\"600\", \"apeach\", \"music\", \"2\"", test.convertContent("[[\"100\", \"ryan\", \"music\", \"2\"],[\"200\", \"apeach\", \"math\", \"2\"],[\"300\", \"tube\", \"computer\", \"3\"],[\"400\", \"con\", \"computer\", \"4\"],[\"500\", \"muzi\", \"music\", \"3\"],[\"600\", \"apeach\", \"music\", \"2\"]]"));
    }

    @Test
    void prefix() {
        test.setDimension(1);
        test.setType("string");

        assertEquals("new String[] {", test.prefix());
    }

    @Test
    void suffix() {
        test.setDimension(1);
        test.setType("string");

        assertEquals("}", test.suffix());
    }
}