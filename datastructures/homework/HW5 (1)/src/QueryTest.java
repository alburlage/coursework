import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Set;

public class QueryTest {
    @Test
    public void test0A() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights1990.csv");
            int result = Query.Query0(input);
            Assert.assertEquals(2, result);
        }
    }
    @Test
    public void test0B() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights2020.csv");
            int result = Query.Query0(input);
            Assert.assertEquals(6, result);
        }
    }
    @Test
    public void test1A() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights1990.csv");
            int total = Query.Query1(input);
            Assert.assertEquals(275, total);
        }
    }

    @Test
    public void test1B() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights2020.csv");
            int total = Query.Query1(input);
            Assert.assertEquals(444, total);
        }
    }

    @Test
    public void test2A() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights1990.csv");
            Iterable<String> results = Query.Query2(input);
            Set<String> expected = TestUtilities.getExpectedResults2Col("queries/query2_1990.txt");
            TestUtilities.checkUnordered(expected, results);
        }
    }

    @Test
    public void test2B() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights2020.csv");
            Iterable<String> results = Query.Query2(input);
            Set<String> expected = TestUtilities.getExpectedResults2Col("queries/query2_2020.txt");
            TestUtilities.checkUnordered(expected, results);
        }
    }

    @Test
    public void test3A() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights1990.csv");
            int result = Query.Query3(input);
            Assert.assertEquals(57, result);
        }
    }

    @Test
    public void test3B() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights2020.csv");
            int result = Query.Query3(input);
            Assert.assertEquals(63, result);
        }
    }

    @Test
    public void test4A() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights1990.csv");
            Iterable<String> results = Query.Query4(input);
            Set<String> expected = TestUtilities.getExpectedResults1Col("queries/query4_1990.txt");
            TestUtilities.checkUnordered(expected, results);
        }
    }
    @Test
    public void test4B() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights2020.csv");
            Iterable<String> results = Query.Query4(input);
            Set<String> expected = TestUtilities.getExpectedResults1Col("queries/query4_2020.txt");
            TestUtilities.checkUnordered(expected, results);
        }
    }

    @Test
    public void test5A() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights1990.csv");
            String result = Query.Query5(input);
            Assert.assertEquals("9 had 13832 flights", result);
        }
    }
    @Test
    public void test5B() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights2020.csv");
            String result = Query.Query5(input);
            Assert.assertEquals("1 had 21945 flights", result);
        }
    }
    @Test
    public void test6A() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights1990.csv");
            String result = Query.Query6(input);
            Assert.assertEquals("(CA,CA)", result);
        }
    }
    @Test
    public void test6B() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights2020.csv");
            String result = Query.Query6(input);
            Assert.assertEquals("(AK,AK)", result);
        }
    }
    @Test
    public void test7A() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights2020.csv");
            Iterable<String> results = Query.Query7(input);
            Set<String> expected = TestUtilities.getExpectedResults1Col("queries/query7_2020.txt");
            TestUtilities.checkUnordered(expected, results);
        }
    }

    @Test
    public void test7B() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights2020.csv");
            Iterable<String> results = Query.Query7(input);
            Set<String> expected = TestUtilities.getExpectedResults1Col("queries/query7_2020.txt");
            TestUtilities.checkUnordered(expected, results);
        }
    }

    @Test
    public void test7C() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights2020.csv");
            Iterable<String> results = Query.Query7(input);
            Set<String> expected = TestUtilities.getExpectedResults1Col("queries/query7_2020.txt");
            TestUtilities.checkUnordered(expected, results);
        }
    }

    @Test
    public void test7D() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights2020.csv");
            Iterable<String> results = Query.Query7(input);
            Set<String> expected = TestUtilities.getExpectedResults1Col("queries/query7_2020.txt");
            TestUtilities.checkUnordered(expected, results);
        }

    }

    @Test
    public void test7E() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights2020.csv");
            Iterable<String> results = Query.Query7(input);
            Set<String> expected = TestUtilities.getExpectedResults1Col("queries/query7_2020.txt");
            TestUtilities.checkUnordered(expected, results);
        }
    }

    @Test
    public void test7F() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights1990.csv");
            Iterable<String> results = Query.Query7(input);
            Set<String> expected = TestUtilities.getExpectedResults1Col("queries/query7_1990.txt");
            TestUtilities.checkUnordered(expected, results);
        }
    }
    @Test
    public void test8A() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights2020.csv");
            Iterable<String> results = Query.Query8(input);
            Set<String> expected = TestUtilities.getExpectedResults1Col("queries/query8_2020.txt");
            TestUtilities.checkUnordered(expected, results);
        }
    }
    @Test
    public void test8B() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights1990.csv");
            Iterable<String> results = Query.Query8(input);
            Set<String> expected = TestUtilities.getExpectedResults1Col("queries/query8_1990.txt");
            TestUtilities.checkUnordered(expected, results);
        }
    }
    @Test
    public void test9A() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights2020.csv");
            Iterable<String> results = Query.Query9(input);
            Set<String> expected = TestUtilities.getExpectedResults2Col("queries/query9_2020.txt");
            try {
                TestUtilities.checkUnordered(expected, results);
            } catch (AssertionError e) {
                expected.remove("VI,American Airlines Inc.");
                expected.add("VI,Cape Air");
                TestUtilities.checkUnordered(expected, results);
            }
        }
    }
    @Test
    public void test9B() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights1990.csv");
            Iterable<String> results = Query.Query9(input);
            Set<String> expected = TestUtilities.getExpectedResults2Col("queries/query9_1990.txt");
            TestUtilities.checkUnordered(expected, results);
        }
    }
    @Test
    public void test10A() throws IOException {
        {
            Iterable<FlightRecord> input = DataImporter.getData("flights/flights2020.csv");
            Iterable<String> results = Query.Query10(input);
            Set<String> expected = TestUtilities.getExpectedResults1Col("queries/query10_2020.txt");
            TestUtilities.checkUnordered(expected, results);
        }
    }

    @Test
    public void test10B() throws IOException {
        {
            {
                Iterable<FlightRecord> input = DataImporter.getData("flights/flights1990.csv");
                Iterable<String> results = Query.Query10(input);
                Set<String> expected = TestUtilities.getExpectedResults1Col("queries/query10_1990.txt");
                TestUtilities.checkUnordered(expected, results);
            }
        }
    }
}
