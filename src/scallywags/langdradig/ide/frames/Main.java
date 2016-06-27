package scallywags.langdradig.ide.frames;

import scallywags.langdradig.generate.Checker;
import scallywags.langdradig.generate.exceptions.CheckerException;
import scallywags.langdradig.ide.errors.LANGdradigError;
import scallywags.langdradig.ide.errors.LANGdradigErrorBuilder;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.*;
import javax.swing.text.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.List;

import scallywags.langdradig.ide.Compiler;
import scallywags.langdradig.ide.features.unfinished.AutoCompleter;
import scallywags.langdradig.ide.features.unfinished.Formatter;
import scallywags.langdradig.ide.features.finished.TextLineNumber;
import scallywags.langdradig.ide.features.finished.ProgramStructureOverview;
import scallywags.langdradig.ide.features.finished.SyntaxHighlighter;

/**
 * Created by Jeroen Weener on 15/06/2016.
 * // TODO translate True and False in compiler
 * // TODO add tests for arrays to ParseTest
 * // TODO error highlighting seems off
 * <p>
 * ------Future features------
 * Catch exception if anything goes wrong and give user feedback, don't let application halt without any kind of feedback
 * Support CTRL + F
 * Auto formatting
 * Add warnings (ex. not joining child threads)
 * Syntax highlighting (ex. variables in italics, comments greyed out)
 * Split highlighter to explicit feature
 * Overview of threads
 * For loop
 * add deelbaar door
 * saving file with existing name dialog
 * saving file as file that is already open should merge tabs
 * make variable overview a tree component
 * <p>
 * ------Bugs------
 * Selected text gets whited out when checkContent() is called afterwards
 */

public class Main extends JFrame {
    private static final String EXTENSION = ".langdradig";
    private static final Font font = new Font("Verdana", Font.PLAIN, 16);
    private final JFileChooser fc = new JFileChooser();
    private Process runningProgram;

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 4, new Insets(10, 10, 10, 10), -1, -1));
        startButton = new JButton();
        startButton.setText("Start (CTRL + R)");
        contentPane.add(startButton, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        splitPane = new JSplitPane();
        splitPane.setDividerLocation(32);
        splitPane.setDividerSize(5);
        splitPane.setLastDividerLocation(-1);
        splitPane.setOrientation(0);
        splitPane.setResizeWeight(0.0);
        splitPane.setVerifyInputWhenFocusTarget(false);
        contentPane.add(splitPane, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(200, 200), null, 0, false));
        messagesAreaScrollPane = new JScrollPane();
        messagesAreaScrollPane.setToolTipText("");
        messagesAreaScrollPane.setVisible(true);
        messagesAreaScrollPane.putClientProperty("html.disable", Boolean.FALSE);
        splitPane.setRightComponent(messagesAreaScrollPane);
        messagesAreaScrollPane.setBorder(BorderFactory.createTitledBorder("Berichten"));
        messagesArea = new JTextArea();
        messagesArea.setColumns(0);
        messagesArea.setEditable(false);
        messagesArea.setEnabled(true);
        messagesArea.setFocusable(true);
        messagesArea.setFont(new Font(messagesArea.getFont().getName(), messagesArea.getFont().getStyle(), messagesArea.getFont().getSize()));
        messagesArea.setLineWrap(false);
        messagesAreaScrollPane.setViewportView(messagesArea);
        programmingViews = new JSplitPane();
        programmingViews.setDividerLocation(300);
        programmingViews.setDividerSize(5);
        programmingViews.setOrientation(1);
        splitPane.setLeftComponent(programmingViews);
        programPane = new JTabbedPane();
        programPane.setToolTipText("");
        programmingViews.setLeftComponent(programPane);
        final JScrollPane scrollPane1 = new JScrollPane();
        programmingViews.setRightComponent(scrollPane1);
        variableView = new JTextArea();
        variableView.setEditable(false);
        variableView.setFocusable(false);
        variableView.setTabSize(2);
        variableView.setText("");
        scrollPane1.setViewportView(variableView);
        showHideButton = new JButton();
        showHideButton.setInheritsPopupMenu(false);
        showHideButton.setMargin(new Insets(2, 14, 2, 14));
        showHideButton.setText("Toon/Verstop berichten");
        showHideButton.setVerticalAlignment(0);
        contentPane.add(showHideButton, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        clearButton = new JButton();
        clearButton.setInheritsPopupMenu(false);
        clearButton.setMargin(new Insets(2, 14, 2, 14));
        clearButton.setText("Leeg berichten");
        clearButton.setVerticalAlignment(0);
        clearButton.setVerticalTextPosition(0);
        contentPane.add(clearButton, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        notificationPanel = new JPanel();
        notificationPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        notificationPanel.setVisible(false);
        contentPane.add(notificationPanel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setVerticalScrollBarPolicy(21);
        scrollPane2.setVisible(true);
        notificationPanel.add(scrollPane2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        notificationLabel = new JLabel();
        notificationLabel.setFont(new Font(notificationLabel.getFont().getName(), Font.BOLD, notificationLabel.getFont().getSize()));
        notificationLabel.setText("");
        notificationLabel.setVerticalTextPosition(0);
        notificationLabel.setVisible(true);
        scrollPane2.setViewportView(notificationLabel);
        stopButton = new JButton();
        stopButton.setText("Stop (CTRL + K)");
        contentPane.add(stopButton, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        autoCompleteCheckBox = new JCheckBox();
        autoCompleteCheckBox.setSelected(false);
        autoCompleteCheckBox.setText("Autocomplete (experimental)");
        contentPane.add(autoCompleteCheckBox, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        newButton = new JButton();
        newButton.setRequestFocusEnabled(false);
        newButton.setText("Nieuw (CTRL + N)");
        contentPane.add(newButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        openButton = new JButton();
        openButton.setIcon(new ImageIcon(getClass().getResource("/com/sun/java/swing/plaf/windows/icons/NewFolder.gif")));
        openButton.setText("Open (CTRL + O)");
        contentPane.add(openButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        saveButton = new JButton();
        saveButton.setIcon(new ImageIcon(getClass().getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
        saveButton.setText("Opslaan (CTRL + S)");
        contentPane.add(saveButton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        undoButton = new JButton();
        undoButton.setText("Ongedaan maken (CTRL + Z)");
        contentPane.add(undoButton, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        redoButton = new JButton();
        redoButton.setText("Herhalen (CTRL + Y)");
        contentPane.add(redoButton, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }

    private enum Status {YES, NO, CANCEL}

    private Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.PINK);
    private Map<Integer, Object> highlightTags = new HashMap<>();

    private JPanel contentPane;
    private JButton openButton;
    private JButton saveButton;
    private JButton startButton;
    private JButton newButton;
    private JButton clearButton;
    private JButton showHideButton;
    private JTextArea messagesArea;
    private JScrollPane messagesAreaScrollPane;
    private JPanel messagesPanel;

    private JSplitPane splitPane;
    private JTabbedPane programPane;
    private Map<JTextPane, Boolean> changes = new HashMap<>();
    private Map<JTextPane, UndoManager> undoManagers = new HashMap<>();
    private JLabel notificationLabel;
    private JPanel notificationPanel;
    private JTextArea variableView;
    private JSplitPane programmingViews;
    private JCheckBox autoCompleteCheckBox;
    private JButton stopButton;
    private JButton undoButton;
    private JButton redoButton;
    private JScrollPane notificationScrollPane;
    private int dividerLocation;

    private List<String> filePaths = new ArrayList<>();
    private Timer notificationTimer;
    private Timer contentCheckTimer;
    private boolean autocomplete = false;
    private boolean correctProgram = false;

    public Main() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(openButton);
        newButton.addActionListener(e -> onNew());
        newButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
                    /**
                     * Key shortcuts
                     *      OPEN:   CTRL + O
                     *      NEW:    CTRL + N
                     */
                    switch (e.getKeyCode()) {
                        case 79:    // 'O' key
                            onOpen();
                            break;
                        case 78:    // 'N' key
                            onNew();
                            break;
                        default:
                            break;
                    }
                }
            }
        });

        autoCompleteCheckBox.addChangeListener(e -> autocomplete = !autocomplete);
        openButton.addActionListener(e -> onOpen());
        saveButton.addActionListener(e -> onSave());
        clearButton.addActionListener(e -> clearMessages());
        showHideButton.addActionListener(e -> toggleMessages());
        startButton.addActionListener(e -> onStart());
        stopButton.addActionListener(e -> onStop());
        undoButton.addActionListener(e -> undo());
        redoButton.addActionListener(e -> redo());

        ((DefaultCaret) messagesArea.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        messagesArea.setFont(font);
        variableView.setFont(font);
        programPane.addChangeListener(changeEvent -> {
            if (programPane.getTabCount() > 0) {
                checkContent();
            }
        });

        fc.setFileFilter(new FileNameExtensionFilter("langdradig file", "langdradig"));

        // call onClose() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onClose();
            }
        });

        // call onClose() on ESCAPE
        contentPane.registerKeyboardAction(e -> onClose(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        contentCheckTimer = new Timer(800, f -> checkContent());
        contentCheckTimer.setRepeats(false);

        pack();
        setTitle("LANGdradig IDE");
        setResizable(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        // There is a bug in JSplitPane preventing componentShown() from being called if we don't do this
        programmingViews.setVisible(false);
        programmingViews.setVisible(true);
        splitPane.setVisible(false);
        splitPane.setVisible(true);
    }

    private void onOpen() {
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            String fileName = file.getName();
            if (file.exists()) {
                if (fileName.endsWith(EXTENSION)) {
                    openFile(file);
                } else {
                    JOptionPane.showMessageDialog(this, "Dit bestandstype wordt niet ondersteunt. Open een bestand met de extensdie .langdradig", "Bestandstype niet ondersteunt", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Het door u geselecteerde bestand kan niet worden gevonden", "Bestand niet gevonden", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void onClose() {
        if (changes()) {
            Status s = promptSave("Opslaan?", "Wilt u uw gewijzigde bestanden opslaan?");
            switch (s) {
                case YES:
                    for (int i = 0; i < programPane.getTabCount(); i++) {
                        programPane.setSelectedIndex(i);
                        int result = onSave();
                        if (result == -1) {
                            return;
                        }
                    }
                    break;
                case NO:
                    break;
                case CANCEL:
                default:
                    return;
            }
        }
        onStop();
        dispose();
    }

    private void onNew() {
        openFile(null);
    }

    public int onSave() {
        if (programPane.getTabCount() <= 0) return -1;
        if (changes.get(getCodeArea())) {
            String content = getCode();
            SyntaxHighlighter.colorKeywords(getCodeArea());
            String filePath = getFilePath();
            return save(content, filePath);
        } else {
            return 0;
        }
    }

    public Process onStop() {
        if (runningProgram != null) {
            runningProgram.destroy();
            runningProgram = null;
        }
        return Compiler.killGHC();
    }

    private int forceSave() {
        if (programPane.getTabCount() <= 0) return -1;
        return save(getCode(), getFilePath());
    }

    public int onSave(int tabIndex) {
        if (changes.get(getCodeArea(tabIndex))) {
            String content = getCode(tabIndex);
            String filePath = getFilePath(tabIndex);
            return save(content, filePath);
        } else {
            return 0;
        }
    }

    private int save(String content, String filePath) {
        if (filePath == null) {
            fc.setSelectedFile(new File("NieuwBestand.langdradig"));
            int returnValue = fc.showSaveDialog(this);
            if (returnValue != JFileChooser.APPROVE_OPTION) {
                return -1;
            }
            File f = fc.getSelectedFile();
            filePath = f.getAbsolutePath();
            filePaths.set(programPane.getSelectedIndex(), filePath);
        }
        try (PrintWriter writer = new PrintWriter(filePath, "UTF-8")) {
            writer.write(content);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String name = new File(filePath).getName();
        ((JLabel) ((JPanel) programPane.getTabComponentAt(programPane.getSelectedIndex())).getComponent(0)).setText(name);
        popup(name + " opgeslagen");
        checkContent();
        return 0;
    }


    private void onStart() {
        if (programPane.getTabCount() <= 0) return;
        String filePath = getFilePath();
        int result;
        if (filePath == null) {
            result = forceSave();
        } else {
            result = onSave();
        }
        if (result != 0) return;
        if (!correctProgram) {
            clearMessages();
            messagesArea.setBackground(Color.PINK);
            print("Het programma kan niet gestart worden omdat het fouten bevat.");
            return;
        }
        clearMessages();
        Process killP = onStop();
        if (killP != null) {
            try {
                killP.waitFor();
            } catch (InterruptedException ignore) {
            }
        }
        Compiler c = Compiler.getInstance();
        try {
            runningProgram = c.compileAndRun(getFilePath(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkContent() {
        clearMessages();
        getHighlighter().removeAllHighlights();
        Checker checker = new Checker();
        checker.checkString(getCode());
        if (!checker.getCheckerExceptions().isEmpty() || !checker.getParserExceptions().isEmpty()) {
            correctProgram = false;
            List<LANGdradigError> errors = checker.getParserExceptions();
            List<CheckerException> checkerExceptions = checker.getCheckerExceptions();
            checkerExceptions.forEach(e -> errors.add(LANGdradigErrorBuilder.format(getCode(), e)));
            Collections.sort(errors);
            for (LANGdradigError e : errors) {
                print(programPane.getTitleAt(programPane.getSelectedIndex()));
                printError(e);
                print("");
            }
            messagesArea.setBackground(Color.PINK);
        } else {
            correctProgram = true;
        }
        variableView.setText(ProgramStructureOverview.printScopes(checker.getForkTable()));
    }

    public void clearMessages() {
        messagesArea.setText("");
        messagesArea.setBackground(Color.WHITE);
    }

    private void toggleMessages() {
        if (splitPane.getBottomComponent() == null) {
            splitPane.setDividerLocation(dividerLocation);
            splitPane.setBottomComponent(messagesAreaScrollPane);
        } else {
            dividerLocation = splitPane.getDividerLocation();
            splitPane.setBottomComponent(null);
        }
        this.revalidate();
    }

    private void setupKeyListener(JTextPane c) {
        c.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setContentChanged(c);
                if (autocomplete) {
                    AutoCompleter.complete(c, e);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setContentChanged(c);
                if (autocomplete) {
                    AutoCompleter.complete(c, e);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setContentChanged(c);
                if (autocomplete) {
                    AutoCompleter.complete(c, e);
                }
            }
        });
        changes.put(c, false);
        c.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown()) {
                    /**     Key shortcuts
                     *      SAVE:       CTRL + S
                     *      OPEN:       CTRL + O
                     *      NEW:        CTRL + N
                     *      START:      CTRL + R
                     *      FORMAT:     CTRL + L
                     *      CLOSE TAB:  CTRL + W
                     *      UNDO:       CTRL + Z
                     *      REDO:       CTRL + Y
                     *      STOP        CTRL + K
                     */
                    switch (e.getKeyCode()) {
                        case 83:    // 'S' key;
                            int result = onSave();
                            if (result == 0) {
                                changes.put(c, false);
                            }
                            break;
                        case 79:    // 'O' key
                            onOpen();
                            break;
                        case 78:    // 'N' key
                            onNew();
                            break;
                        case 82:    // 'R' key
                            onStart();
                            break;
                        case 75:
                            onStop();
                            break;
                        case 76:    // 'L' key
                            //TODO fix formatting
//                            format();
                            break;
                        case 87:    // 'W' key
                            removeTab(programPane.getSelectedIndex());
                            break;
                        case 89:    // 'Y' key
                            redo();
                            break;
                        case 90:    // 'Z' key
                            undo();
                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }

    private void highlight(int lineNumber) {
        String code = getCode();
        String[] lines = code.split("\n");

        // Line numbers start on 1, indices on 0
        int startPos = code.indexOf(lines[lineNumber - 1]);
        int endPos = startPos + lines[lineNumber - 1].length();
        try {
            highlightTags.put(lineNumber, getHighlighter().addHighlight(startPos, endPos, painter));
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private void removeHighlight(int lineNumber) {
        getHighlighter().removeHighlight(highlightTags.get(lineNumber));
    }

    private void printError(LANGdradigError error) {
        int lineNumber = Math.min(error.getLineNumber(), getCode().split("\n").length);
        if (lineNumber > 0) {
            highlight(lineNumber);
        }
        error.setLineNumber(lineNumber);
        print(error.toString());
    }

    public void print(String s) {
        messagesArea.append(s + "\n");
    }

    public String getFilePath() {
        return filePaths.get(programPane.getSelectedIndex());
    }

    public String getFilePath(int index) {
        return filePaths.get(index);
    }

    public Highlighter getHighlighter() {
        return getCodeArea().getHighlighter();
    }

    public void popup(String message) {
        String oldMessage = notificationLabel.getText();
        String newMessage = oldMessage.equals("") ? message : oldMessage + ", " + message;
        notificationLabel.setText(newMessage);
        notificationPanel.setVisible(true);

        if (notificationTimer == null) {
            notificationTimer = new Timer(3000, e -> {
                notificationPanel.setVisible(false);
                notificationLabel.setText("");
                notificationTimer = null;
            });
            notificationTimer.setRepeats(false);
        } else {
            notificationTimer.stop();
            notificationTimer.setInitialDelay(3000);
        }
        notificationTimer.start();
    }

    public void openFile(File file) {
        JTextPane area = new JTextPane();
        area.setFont(font);
        String fileName;
        if (file == null) {
            fileName = "NieuwBestand";
        } else {
            // Check if file is already opened
            for (int i = 0; i < filePaths.size(); i++) {
                String filePath = filePaths.get(i);
                if (file.getAbsolutePath().equals(filePath)) {
                    programPane.setSelectedIndex(i);
                    return;
                }
            }
            fileName = file.getName();
            try {
                String content = new String(Files.readAllBytes(file.toPath()));
                area.setText(content);
                SyntaxHighlighter.colorKeywords(area);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        UndoManager manager = new UndoManager();
        //-1 means no limit
        manager.setLimit(-1);
        undoManagers.put(area, manager);
        area.getDocument().addUndoableEditListener(manager);
        setupKeyListener(area);
        JScrollPane codeScroll = new JScrollPane(area);
        codeScroll.setRowHeaderView(new TextLineNumber(area));
        programPane.addTab(fileName, codeScroll);
        programPane.setSelectedIndex(programPane.getTabCount() - 1);
        JPanel tabPanel = new JPanel();
        tabPanel.setOpaque(false);
        tabPanel.add(new JLabel(fileName));
        JButton closeButton = new JButton("X");
        closeButton.setContentAreaFilled(false);
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                closeButton.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                closeButton.setForeground(Color.BLACK);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                removeTab(programPane.indexOfComponent(codeScroll));
            }
        });
        tabPanel.add(closeButton);

        programPane.setTabComponentAt(programPane.getSelectedIndex(), tabPanel);
        area.requestFocus();

        if (file != null) {
            filePaths.add(file.getAbsolutePath());
        } else {
            filePaths.add(null);
        }
        popup(fileName + " geopend");
    }

    private void removeTab(int index) {
        JTextPane area = getCodeArea(index);
        if (changes.get(area)) {
            Status status = promptSave("Opslaan?", "Dit bestand bevat onopgeslagen wijzigen, wilt u deze opslaan?");
            switch (status) {
                case YES:
                    int result = onSave(index);
                    if (result == -1) {
                        return;
                    }
                case NO:
                    break;
                case CANCEL:
                    return;
                default:
                    return;
            }
        }
        changes.remove(area);
        filePaths.remove(index);
        programPane.removeTabAt(index);
        if (programPane.getTabCount() == 0) {
            variableView.setText("");
        }
    }

    private Status promptSave(String title, String message) {
        int result = JOptionPane.showOptionDialog(this, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{"Ja", "Nee", "Annuleren"}, null);
        switch (result) {
            case JOptionPane.OK_OPTION:
                return Status.YES;
            case JOptionPane.NO_OPTION:
                return Status.NO;
            case JOptionPane.CANCEL_OPTION:
            case JOptionPane.CLOSED_OPTION:
            default:
                return Status.CANCEL;
        }
    }

    public JTextPane getCodeArea() {
        return (JTextPane) ((JViewport) ((JScrollPane) programPane.getSelectedComponent()).getComponent(0)).getComponent(0);
    }

    public JTextPane getCodeArea(int index) {
        return (JTextPane) ((JViewport) ((JScrollPane) programPane.getComponentAt(index)).getComponent(0)).getComponent(0);
    }

    public String getCode(int index) {
        return getCodeArea(index).getText();
    }

    public String getCode() {
        Document doc = getCodeArea().getStyledDocument();
        String result = "";
        try {
            result = doc.getText(0, doc.getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        return result;
    }

    private boolean changes() {
        return changes.values().stream().anyMatch(b -> b);
    }

    private void format() {
        JTextPane area = getCodeArea();
        String newContent = Formatter.format(getCode());
        if (!newContent.equals(getCode())) {
            area.setText(newContent);
            if (!changes.get(area)) {
                JLabel label = ((JLabel) ((JPanel) programPane.getTabComponentAt(programPane.getSelectedIndex())).getComponent(0));
                label.setText(label.getText() + "*");
            }
            changes.put(area, true);
            checkContent();
        }
    }

    private void setContentChanged(JTextPane c) {
        if (!changes.get(c)) {
            JLabel label = ((JLabel) ((JPanel) programPane.getTabComponentAt(programPane.getSelectedIndex())).getComponent(0));
            label.setText(label.getText() + "*");
            changes.put(c, true);
        }
        contentCheckTimer.stop();
        contentCheckTimer.start();
    }

    private void undo() {
        try {
            undoManagers.get(getCodeArea()).undo();
        } catch (CannotUndoException ignore) {
        }
    }

    private void redo() {
        try {
            undoManagers.get(getCodeArea()).redo();
        } catch (CannotRedoException ignore) {
        }
    }

    public void addMainListener() {
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                handleResize();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e);
                handleResize();
            }

            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                handleResize();
            }
        });
    }

    private void handleResize() {
        programmingViews.setDividerLocation(.8);
        splitPane.setDividerLocation(.8);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException ignored) {
        }
        new Main().addMainListener();
    }
}
