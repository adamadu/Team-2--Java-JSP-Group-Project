
package workshop6.utils;
import workshop6.GUI.*;

/**
 * @author Adam
 * Date: Sept 16 2015
 * Purpose: Validation of all the forms in the application.
 */
public class Validator {
    
    public static boolean isEmptyOrNonSelected(Object input)
    {
        if(input instanceof javax.swing.JComboBox)
        {
           javax.swing.JComboBox combobox = (javax.swing.JComboBox) input;
           if(combobox.getSelectedIndex() == -1)
           {
               javax.swing.JOptionPane.showMessageDialog(null, combobox.getName() + " Field cannot have an empty value");
               return true;
           }
            
        }
        else if (input instanceof javax.swing.JTextField)
        {
            javax.swing.JTextField textField = (javax.swing.JTextField) input;
            if(textField.getText().trim().equals(""))
            {
                javax.swing.JOptionPane.showMessageDialog(null, textField.getName() + " Field cannot have an empty value");
                return true;
            }
        }
        else if (input instanceof javax.swing.ButtonGroup)
        {
            //TODO: Code for checked if they selected active or inactive.
        }
        return false;
    }
    
    public static boolean isValidEmail(String input)
    {
        if(!input.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
        {
            javax.swing.JOptionPane.showMessageDialog(null, "Invalid email address format. Please try again");
            return false;
        }
        return true;
    }
    
}
