package threeBitGrayCodeCounter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table {

	JFrame frame;

	Table() {

		frame = new JFrame();
		String column[] = { "Decimal", "Gray" };
		HashMap<Integer, String> hashmapGray = new HashMap<Integer, String>();

		for (int i = 0; i < 8; i++) {
			hashmapGray.put(i, String.format("%03d", DecimalToGray.toGray(i)).substring(0));
		}

		Object[][] arrayDecimalGary = new Object[hashmapGray.size()][2];

		Set<?> entries = hashmapGray.entrySet();
		Iterator<?> entriesIterator = entries.iterator();

		int j = 0;
		while (entriesIterator.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry mapping = (Map.Entry) entriesIterator.next();
			arrayDecimalGary[j][0] = mapping.getKey();
			arrayDecimalGary[j][1] = mapping.getValue();
			j++;
		}

		JTable jtable = new JTable(arrayDecimalGary, column);
		jtable.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(jtable);
		frame.add(sp);
		frame.setSize(300, 400);
		frame.setVisible(true);
	}

	public static void main(String[] args) throws InterruptedException {
		new Table();
	}
}
