
package rccms.client;

/**
 * @author gwiza
 */

import javax.swing.SwingUtilities;
import rccms.client.view.LoginForm;

public class RCCMS {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
            }
        });
    }

}
