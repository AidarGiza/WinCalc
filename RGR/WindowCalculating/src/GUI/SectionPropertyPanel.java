package GUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SectionPropertyPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8240584799077267979L;

	// �������� "������ ������ ����"
	private int SectionWidth;
	public int getSectionWidth() {
		return SectionWidth;
	}
	public void setSectionWidth(int sectionWidth) {
		SectionWidth = sectionWidth;
	}

	// �������� "��� ������ ����" 
	private String SectionType;
	public String getSectionType() {
		return SectionType;
	}
	public void setSectionType(String sectionType) {
		switch (sectTypeCB.getSelectedIndex()) {
			case 0: 
				sectTypeRate = 0;
				break;
			case 1:
			case 3:
				sectTypeRate = 0.193f;
				break;
			case 2:
			case 4:
				sectTypeRate = 0.493f;
				break;
		}
		SectionType = sectionType;
	}
	
	// ���� "��������� ��� ���������� ���� ������"
	public float sectTypeRate;
	
	String items[] = {
			"������",
			"���������� �����",
			"���������/�������� �����",
			"���������� ������",
			"���������/�������� ������"
	};
	JComboBox<String> sectTypeCB = new JComboBox<String>(items);
	JTextField sectWidthTF = new JTextField();
	
	// ����������� ������ ������ ���������� ������
	public SectionPropertyPanel(String name) {
		super();
		setBorder(BorderFactory.createTitledBorder(name));
		setLayout(new GridBagLayout());
		
		// ���� ����� ������ ������
		add(sectWidthTF, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.EAST, 
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 5, 10), 0, 0));
		sectWidthTF.setText("500");
		
		// ���������� ������ ����� ������
		add(sectTypeCB, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.EAST, 
				GridBagConstraints.HORIZONTAL, new Insets(5, 10, 10, 10), 0, 0));
		
		UpdateWidth();
	}

	// �������� ��������� ������ ������
	public void UpdateWidth() {
		try {
			setSectionWidth(Integer.parseInt(sectWidthTF.getText()));
			sectWidthTF.setBackground(Color.white);
			// ���� ������ ������ 500 ������� ������
			if (SectionWidth < 500) {
				sectWidthTF.setBackground(Color.red);
			}
		} catch (NumberFormatException e) {
			// ���� ���� ������, ������ ����� 0
			if (sectWidthTF.getText().isEmpty()) {
				setSectionWidth(0);
			}
			sectWidthTF.setBackground(Color.red);
		}
	}
	
}
