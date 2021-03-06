// Copyright (C) 2021 Jarmo Hurri

// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <https://www.gnu.org/licenses/>.

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame
{
  public GUI (Application application)
  {
    super ("Complex event demo");
    this.application = application;

    setSize (400, 300);

    menuBar = new JMenuBar ();
    JMenu fileMenu = new JMenu ("File");
    JMenuItem quitItem = new JMenuItem ("Quit");
    quitItem.addActionListener ((ActionEvent e) ->
                                System.exit (0));
    fileMenu.add (quitItem);
    menuBar.add (fileMenu);
    setJMenuBar (menuBar);

    // text field
    textField = new JTextField (10);
    add (textField, BorderLayout.PAGE_START);

    // a label for showing whether focus is in or out
    focusLabel = new JLabel ();
    showFocus ();
    add (focusLabel, BorderLayout.LINE_START);

    // a label for showing length of text
    textLengthLabel = new JLabel ();
    showTextLength ();
    add (textLengthLabel, BorderLayout.LINE_END);

    setVisible (true);
  }

  void showTextLength ()
  {
    textLengthLabel.setText (application.textLength + "");
  }

  void showFocus ()
  {
    focusLabel.setText (application.hasFocus + "");
  }
  
  private Application application;
  private JMenuBar menuBar;
  private JLabel focusLabel, textLengthLabel;
  private JTextField textField;
}