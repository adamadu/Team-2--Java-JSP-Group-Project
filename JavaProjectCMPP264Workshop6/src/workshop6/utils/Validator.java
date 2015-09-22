
package workshop6.utils;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import com.toedter.calendar.JDateChooser;
/**
 * @author Adam
 * Date: Sept 16 2015
 * Purpose: Validation of all the forms in the application.
 */
public class Validator {
    
    //Function to make sure that in provided object has values in the fields or if the object is selectable, there is atleast one selection
    public static boolean hasTextOrIsSelected(Object input)
    {
        if(input instanceof JComboBox) //Our object is a combo box
        {
            JComboBox combobox = (JComboBox) input;
            if(combobox.getSelectedIndex() != -1)
            {
                return true;
            }
            else 
            {
                JOptionPane.showMessageDialog(null, combobox.getName() + " Field cannot have an empty value");
                return false;
            }
            
        }
        else if (input instanceof JTextField) //Our object is a text field
        {
            JTextField textField = (JTextField) input;
            if(!textField.getText().trim().equals(""))
            {             
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, textField.getName() + " Field cannot have an empty value");
                return false;
            }
        }
        else if (input instanceof ButtonGroup) //Our object is a button group
        {
            ButtonGroup buttonGroup = (ButtonGroup) input;
            
            if(buttonGroup.getSelection() != null)
            {
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select a value for Agent Status!");
                return false;
            }
        }
        else if (input instanceof JDateChooser) //Our object is a date chooser
        {
            JDateChooser dateChooser = (JDateChooser) input;
            if(dateChooser.getDate() != null)
            {
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select/enter a valid date for field " + dateChooser.getName());
                return false;
            }
        }
        return false;
    }
    
    //Function to check that the provided string is a valid email address exmaple: name@organization.com
    public static boolean isValidEmail(String input)
    {
        if(!input.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
        {
            JOptionPane.showMessageDialog(null, "Invalid email address format. Please try again");
            return false;
        }
        return true;
    }
    
    //Function to check that the provided textfield input text is a valid double.
    public static boolean isDouble(JTextField input)
    {
        String inputText = input.getText();
        try
        {
            Double.parseDouble(inputText);
            return true;
        }
        catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, "The value entered in the " + input.getName() + " field is not a valid number. Please try again");
            return false;
        }
    }
    
}
