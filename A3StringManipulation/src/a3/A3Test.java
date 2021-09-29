package a3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class A3Test {

    @Test
    void testAreMidsDiff() {
        assertEquals(false, A3.areMidsDiff(""));
        assertEquals(false, A3.areMidsDiff("$"));
        assertEquals(true, A3.areMidsDiff("23"));
        assertEquals(false, A3.areMidsDiff("44"));
        assertEquals(true, A3.areMidsDiff("22AB"));
        assertEquals(false, A3.areMidsDiff("2AAB"));
        assertEquals(false, A3.areMidsDiff("A22"));
        assertEquals(false, A3.areMidsDiff("AAA"));
        assertEquals(true, A3.areMidsDiff("AABC"));
        assertEquals(false, A3.areMidsDiff("abcdefaabcdefg"));
        assertEquals(true, A3.areMidsDiff("abcdef$abcdefg"));
        assertEquals(false, A3.areMidsDiff("aaaaaaaaaaaaaaaa"));
        assertEquals(true, A3.areMidsDiff("aaaaaaa$aaaaaaaa"));
        assertEquals(false, A3.areMidsDiff("aaaaaaa$aaaaaaaaa"));
        assertEquals(false, A3.areMidsDiff("abcdefgAAAabcdefg"));
    }

    @Test
    void testProtectLittles() {
        assertEquals("", A3.protectLittles(""));
        assertEquals("Bb", A3.protectLittles("b"));
        assertEquals("B", A3.protectLittles("B"));
        assertEquals("å", A3.protectLittles("å"));
        assertEquals("$", A3.protectLittles("$"));
        assertEquals("1ABCDEFXx", A3.protectLittles("1ABCDEFx"));
        assertEquals("1ZzZ$BBbYy", A3.protectLittles("1zZ$Bby"));
        assertEquals("AaBbCcDdEeFfGgHhIiJjKk",
            A3.protectLittles("abcdefghijk"));
        assertEquals("LlMmNnOoPpQqRrSsTt",
            A3.protectLittles("lmnopqrst"));
        assertEquals("UuVvWwXxYyZz",
            A3.protectLittles("uvwxyz"));
    }

    @Test
    void testPutCapsLast() {
        assertEquals("", A3.putCapsLast(""));

        assertEquals("$", A3.putCapsLast("$"));
        assertEquals("cA", A3.putCapsLast("Ac"));
        assertEquals("Åc", A3.putCapsLast("Åc"));
        assertEquals("abcdxy$zABCDXZ", A3.putCapsLast("aAbBcCdDxXy$zZ"));
        assertEquals("mnopqrst", A3.putCapsLast("mnopqrst"));
        assertEquals("1z$aàēĤƀ", A3.putCapsLast("1z$aàēĤƀ"));
        assertEquals(".$%!ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            A3.putCapsLast("ABCDE.FGHIJKLMNO$PQ%RSTUV!WXYZ"));
    }

    @Test
    void testMoreThan1() {
        assertEquals(false, A3.moreThan1("", ""));
        assertEquals(true, A3.moreThan1("a", ""));
        assertEquals(false, A3.moreThan1("", "a"));
        assertEquals(false, A3.moreThan1("abcb", "c"));
        assertEquals(true, A3.moreThan1("acbcb", "c"));
        assertEquals(false, A3.moreThan1("abbb", "c"));
        assertEquals(true, A3.moreThan1("aaa", "aa"));
        assertEquals(false, A3.moreThan1("abbc", "ab"));
        assertEquals(true, A3.moreThan1("aaa", "a"));
        assertEquals(true, A3.moreThan1("abbbabc", "ab"));
        assertEquals(true, A3.moreThan1("what if what if what", "what"));
        assertEquals(true, A3.moreThan1("what if what if what", "what if"));
        assertEquals(true, A3.moreThan1("what if what if what", "what if what"));
        assertEquals(false, A3.moreThan1("what if what if what", "what if what if"));
    }

    @Test
    void testExpand() {
        assertEquals("", A3.expand(" b0 "));
        assertEquals("c", A3.expand("        c1"));
        assertEquals("$$$$$$$$", A3.expand("$8        "));
        assertEquals("33333", A3.expand("35"));
    }

    @Test
    void testAreAnagrams() {
//        assertEquals(true, A3.areAnagrams("", ""));
//        assertEquals(true, A3.areAnagrams("noon", "noon"));
//        assertEquals(true, A3.areAnagrams("mary", "army"));
//        assertEquals(true, A3.areAnagrams("tom marvolo riddle", "i am lordvoldemort"));
//        assertEquals(false, A3.areAnagrams("tommarvoloriddle", "i am lordvoldemort"));
        assertEquals(false, A3.areAnagrams("world", "hello"));
//        assertEquals(false, A3.areAnagrams("a", "A"));
    }

}
