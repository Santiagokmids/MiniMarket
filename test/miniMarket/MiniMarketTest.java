package miniMarket;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.DayNotAvailableException;
import exceptions.UnderAgeException;
import model.Document;
import model.MiniMarket;

public class MiniMarketTest {

	private MiniMarket miniMarket;

	public void setupScenary1() {
		miniMarket = new MiniMarket();
	}

	public void setupScenary2() {
		miniMarket = new MiniMarket();
	}

	public void setupScenary3() {
		miniMarket = new MiniMarket();
	}

	@Test
	public void addPeopleCorrect() throws DayNotAvailableException, UnderAgeException {

		setupScenary1();

		if(miniMarket.getLocalDate() % 2 != 0) {

			Document document = Document.CEDULA;
			String id = "31580623";

			miniMarket.addPeople(document, id);

			assertEquals(document,miniMarket.getArrayPeople().get(0).getDocument());
			assertEquals(id,miniMarket.getArrayPeople().get(0).getId());

			Document document1 = Document.CE;
			String id1 = "3126272365";

			miniMarket.addPeople(document1, id1);

			assertEquals(document1,miniMarket.getArrayPeople().get(1).getDocument());
			assertEquals(id1,miniMarket.getArrayPeople().get(1).getId());
		}
		else {
			Document document = Document.CEDULA;
			String id = "3292342053";

			miniMarket.addPeople(document, id);

			assertEquals(document,miniMarket.getArrayPeople().get(0).getDocument());
			assertEquals(id,miniMarket.getArrayPeople().get(0).getId());

			Document document1 = Document.CE;
			String id1 = "2193433211";

			miniMarket.addPeople(document1, id1);

			assertEquals(document1,miniMarket.getArrayPeople().get(1).getDocument());
			assertEquals(id1,miniMarket.getArrayPeople().get(1).getId());
		}
	}

	@Test
	public void addPeopleCorrect2() throws DayNotAvailableException, UnderAgeException {

		setupScenary2();

		if(miniMarket.getLocalDate() % 2 != 0) {

			Document document = Document.TI;
			String id = "3019210281";
			try {

				miniMarket.addPeople(document, id);

			}catch(UnderAgeException uae) {

			}
			assertTrue(miniMarket.getArrayPeople().isEmpty());
		}
		else {
			Document document = Document.TI;
			String id = "3292342013";

			try {

				miniMarket.addPeople(document, id);

			}catch(UnderAgeException uae) {

			}
			assertTrue(miniMarket.getArrayPeople().isEmpty());
		}

	}
	
	@Test
	public void addPeopleCorrect3() throws DayNotAvailableException, UnderAgeException {

		setupScenary3();

		if(miniMarket.getLocalDate() % 2 != 0) {

			Document document = Document.CE;
			String id = "1196573577";
			try {

				miniMarket.addPeople(document, id);

			}catch(DayNotAvailableException dnae) {

			}
			assertTrue(miniMarket.getArrayPeople().isEmpty());
		}
		else {
			Document document = Document.PP;
			String id = "517861205";

			try {

				miniMarket.addPeople(document, id);

			}catch(DayNotAvailableException dnae) {

			}
			assertTrue(miniMarket.getArrayPeople().isEmpty());
		}

	}
}
