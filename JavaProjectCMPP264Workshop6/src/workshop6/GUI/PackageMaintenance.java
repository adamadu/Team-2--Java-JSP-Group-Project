package workshop6.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import workshop6.DBClasses.*;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import workshop6.Entity.Package;
import javax.swing.JScrollPane;

public class PackageMaintenance extends JFrame {

	private JPanel contentPane;
	private JComboBox cbPackageId;
	private DefaultComboBoxModel cbPackageModelId;
	private JTextField txtPkgName;
	private JTextArea txtPkgDesc;
	private JTextField txtPkgStartDate;
	private JTextField txtPkgEndDate;
	private JTextField txtPkgBasePrice;
	private JTextField txtAgencyCommission;
	Package pkg;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PackageMaintenance frame = new PackageMaintenance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PackageMaintenance() {
		setTitle("Package Maintenance");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPackageid = new JLabel("PackageId");
		lblPackageid.setBounds(31, 68, 103, 16);
		contentPane.add(lblPackageid);
		
		JLabel lblPkgName = new JLabel("Package Name");
		lblPkgName.setBounds(31, 110, 103, 16);
		contentPane.add(lblPkgName);
		
		JLabel lblPkgStartDate = new JLabel("Package Start Date");
		lblPkgStartDate.setBounds(31, 157, 137, 16);
		contentPane.add(lblPkgStartDate);
		
		JLabel lblPkgEndDate = new JLabel("Package End Date");
		lblPkgEndDate.setBounds(31, 197, 117, 16);
		contentPane.add(lblPkgEndDate);
		
		JLabel lblPackageDescription = new JLabel("Package Description");
		lblPackageDescription.setBounds(31, 241, 117, 16);
		contentPane.add(lblPackageDescription);
		
		JLabel lblPackageBasePrice = new JLabel("Package Base Price");
		lblPackageBasePrice.setBounds(31, 285, 117, 16);
		contentPane.add(lblPackageBasePrice);
		
		JLabel lblAgencyCommission = new JLabel("Agency Commission");
		lblAgencyCommission.setBounds(31, 326, 117, 16);
		contentPane.add(lblAgencyCommission);

		cbPackageModelId = new DefaultComboBoxModel(PackageDB.getPackageIDs());
		cbPackageId = new JComboBox();
		cbPackageId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String packageId = (String) cbPackageId.getSelectedItem();
				pkg = PackageDB.getPackage(packageId);
				txtPkgName.setText(pkg.getPkgName());
				//txtPkgStartDate.setText((String)pkg.getPkgStartDate().getDate());
				//txtPkgStartDate.setText(getDate(pkg.getPkgStartDate()));
				//txtPkgEndDate.setText(getDate(pkg.getPkgEndDate()));
				txtPkgDesc.setText(pkg.getPkgDesc());
				//txtPkgBasePrice.setText(pkg.getPkgBasePrice());
				//txtAgencyCommission.setText(pkg.getPkgAgencyCommission());
			}

			private String getDate(Date pkgDate) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.CANADA);
		    	LocalDate date = LocalDate.parse((CharSequence) pkgDate, formatter);

		    	int year = date.getYear();
		    	int day = date.getDayOfMonth();
		    	int month = date.getMonthValue();
		    	String startDate = day+"/"+month+"/"+year;
				return startDate;
			}
		});
		cbPackageId.setBounds(188, 65, 156, 22);
		cbPackageId.setModel(cbPackageModelId);
		contentPane.add(cbPackageId);
		
		txtPkgName = new JTextField();
		txtPkgName.setBounds(188, 107, 156, 22);
		contentPane.add(txtPkgName);
		txtPkgName.setColumns(10);
		
		txtPkgStartDate = new JTextField();
		txtPkgStartDate.setBounds(188, 154, 156, 22);
		contentPane.add(txtPkgStartDate);
		txtPkgStartDate.setColumns(10);
		
		txtPkgEndDate = new JTextField();
		txtPkgEndDate.setBounds(188, 194, 156, 22);
		contentPane.add(txtPkgEndDate);
		txtPkgEndDate.setColumns(10);
		
		txtPkgDesc = new JTextArea();
		txtPkgDesc.setRows(3);
		txtPkgDesc.setColumns(20);
		txtPkgDesc.setBounds(188, 241, 156, 26);
		contentPane.add(txtPkgDesc);
		
		txtPkgBasePrice = new JTextField();
		txtPkgBasePrice.setBounds(188, 282, 156, 22);
		contentPane.add(txtPkgBasePrice);
		txtPkgBasePrice.setColumns(10);
		
		txtAgencyCommission = new JTextField();
		txtAgencyCommission.setBounds(188, 323, 156, 22);
		contentPane.add(txtAgencyCommission);
		txtAgencyCommission.setColumns(10);
		
		/*JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(337, 80, 210, 252);
		contentPane.add(scrollPane);*/
		
		
	}
}
