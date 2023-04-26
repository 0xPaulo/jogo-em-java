package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyhandler implements KeyListener {

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressend, enterPressed, stopped;
    public boolean arrowUpPressed, arrowDownPressed, arrowLeftPressed, arrowRightPressend;

    // DEBUG
    public boolean checkDrawTime = false;
    public boolean checkCollisionArea = false;

    public Keyhandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        // TITLE STATE
        if (gp.gameState == gp.titleState) {

            if (gp.ui.titleScreenState == 0) {

                // commandNum = 0;
                if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                    gp.ui.commandNum--;
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 2;
                    }
                }
                if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
                    gp.ui.commandNum++;
                    if (gp.ui.commandNum > 2) {
                        gp.ui.commandNum = 0;
                    }
                }
                if (code == KeyEvent.VK_ENTER) {
                    if (gp.ui.commandNum == 0) {
                        // gp.ui.titleScreenState = 1;
                        gp.gameState = gp.playState;

                        // gp.playMusic(0);
                    }
                    if (gp.ui.commandNum == 1) {
                        // add later
                    }
                    if (gp.ui.commandNum == 2) {
                        System.exit(0);
                    }
                }

                // SUB MENU
            } else if (gp.ui.titleScreenState == 1) {

                // commandNum = 0;
                if (code == KeyEvent.VK_W) {
                    gp.ui.commandNum--;
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 3;
                    }
                }
                if (code == KeyEvent.VK_S) {
                    gp.ui.commandNum++;
                    if (gp.ui.commandNum > 3) {
                        gp.ui.commandNum = 0;
                    }
                }
                if (code == KeyEvent.VK_ENTER) {
                    if (gp.ui.commandNum == 0) {
                        System.out.println("Fazer alguma coisa para o papa");
                        gp.gameState = gp.playState;
                        // ou criar outro subtela
                    }
                    if (gp.ui.commandNum == 1) {
                        System.out.println("Fazer alguma coisa para a windows");
                        gp.gameState = gp.playState;
                    }
                    if (gp.ui.commandNum == 2) {
                        System.out.println("Fazer alguma coisa para o manteiga");
                        gp.gameState = gp.playState;
                        gp.playMusic(0);

                    }
                    if (gp.ui.commandNum == 3) {
                        gp.ui.titleScreenState = 0;
                    }
                }
            }
        }

        // PLAY STATE
        if (gp.gameState == gp.playState) {

            if (code == KeyEvent.VK_W) {
                upPressed = true;
                gp.timeWithoutCommands = 0;
            }
            if (code == KeyEvent.VK_S) {
                downPressed = true;
                gp.timeWithoutCommands = 0;
            }
            if (code == KeyEvent.VK_A) {
                leftPressed = true;
                gp.timeWithoutCommands = 0;
            }
            if (code == KeyEvent.VK_D) {
                rightPressend = true;
                gp.timeWithoutCommands = 0;
            }

            if (code == KeyEvent.VK_UP) {
                upPressed = true;
                gp.timeWithoutCommands = 0;
            }
            if (code == KeyEvent.VK_DOWN) {
                downPressed = true;
                gp.timeWithoutCommands = 0;
            }
            if (code == KeyEvent.VK_LEFT) {
                leftPressed = true;
                gp.timeWithoutCommands = 0;
            }
            if (code == KeyEvent.VK_RIGHT) {
                rightPressend = true;
                gp.timeWithoutCommands = 0;
            }
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
            }
            if (code == KeyEvent.VK_E) {
                enterPressed = true;
            }
        }
        // PAUSE STATE SAIR
        else if (gp.gameState == gp.pauseState) {
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.playState;
            }
        }
        // DIALOGUE STATE SAIR
        else if (gp.gameState == gp.dialogueState) {
            if (code == KeyEvent.VK_E) {
                gp.gameState = gp.playState;
            }
        }
        // DEBUG
        if (code == KeyEvent.VK_T) {
            if (checkDrawTime == false) {
                checkDrawTime = true;
            } else if (checkDrawTime == true) {
                checkDrawTime = false;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressend = false;
        }

        if (code == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressend = false;
        }
    }
}
